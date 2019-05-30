package com.wishes.market.utils;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * log输出配置,使用@Aspect使记录日志的功能面向切面，记录Controller的输入与输出参数
 *
 * @author 郑龙
 * @date 2019/4/5 23:35
 **/
@Component
@Aspect
@Slf4j
public class LogUtil {

    /**
     * Controller请求参数输出
     *
     * @param joinPoint
     */
    @Before("within(com.wishes.market.controller.*)")
    public void before(JoinPoint joinPoint) {
        String[] args = toStringArray(joinPoint.getArgs());
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        log.info(method.getDeclaringClass().getName() + "." + method.getName()
                + ": 请求参数：" + StringUtils.join(args, " ; "));

    }

    /**
     * Controller返回参数输出
     *
     * @param joinPoint
     */
    @AfterReturning(value = "within(com.wishes.market.controller.*)", returning = "rvt")
    public void after(JoinPoint joinPoint, Object rvt) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        log.info(method.getDeclaringClass().getName() + "." + method.getName()
                + ": 返回参数：" + JSON.toJSONString(rvt));
    }

    /**
     * 将任意输入参数转为String数组输出
     *
     * @param objects 传入参数
     * @return String[]
     */
    private String[] toStringArray(Object[] objects) {
        List<String> array = new ArrayList<>();
        for (Object obj : objects) {
            if (obj instanceof java.lang.String) {
                array.add(obj.toString());
            } else {
                array.add(obj + "");
            }
        }

        return array.toArray(new String[0]);
    }
}
