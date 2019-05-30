package com.wishes.market.utils.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wishes.market.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;

/**
 * 对restful请求返回统一的结果格式ActionResult
 *
 * @author 郑龙
 * @date 2019年2月26日08:07:18
 */
@Slf4j
@ControllerAdvice
public class DataResponseBodyAdvice implements ResponseBodyAdvice {
    private ThreadLocal<ObjectMapper> mapperThreadLocal = ThreadLocal.withInitial(ObjectMapper::new);
    private static final String CURRENT_PACKAGE_NAME = "com.wishes";

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        //避免第三方系统参数被格式化 eg.swagger
        String packageName = returnType.getMethod().getDeclaringClass().getPackage().getName();
        if (!packageName.startsWith(CURRENT_PACKAGE_NAME)) {
            return body;
        }

        Object out;
        ObjectMapper mapper = mapperThreadLocal.get();
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        if (body instanceof ResultUtil) {
            out = body;
        } else if (body instanceof String) {
            ResultUtil result = ResultUtil.success(body);
            try {
                //因为是String类型，我们要返回Json字符串，否则SpringBoot框架会转换出错
                out = mapper.writeValueAsString(result);
            } catch (JsonProcessingException e) {
                out = ResultUtil.fail(e.getMessage());
            }
        } else if (body instanceof InputStreamResource) {
            //添加RestFull格式化例外,针对InputStream类型的文件下载做处理
            return body;
        } else {
            out = ResultUtil.success(body);
        }
        return out;
    }

    /**
     * 异常统一处理
     *
     * @param e 异常
     * @return 返回异常信息
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Object exceptionHandle(Exception e) {
        log.error("异常拦截器检测到异常产生：" + e.getMessage(), e);
        return ResultUtil.fail(e.getMessage());
    }

    /**
     * 获取参数验证异常信息
     *
     * @param bindException 参数验证异常
     * @return error message
     */
    private String getErrorMessage(BindException bindException) {
        StringBuilder stringBuilder = new StringBuilder();
        List<FieldError> fieldErrors = bindException.getBindingResult().getFieldErrors();

        for (FieldError error : fieldErrors) {
            stringBuilder.append(error.getField());
            stringBuilder.append(":");
            stringBuilder.append(error.getDefaultMessage());
            stringBuilder.append(";");
        }
        return stringBuilder.toString();
    }
}