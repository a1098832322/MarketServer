package com.wishes.market.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.wishes.market.config.CheckLogin;
import com.wishes.market.config.CommConfig;
import com.wishes.market.config.PrintLog;
import com.wishes.market.dto.PrivilegeInfo;
import com.wishes.market.service.CurrentUserService;
import com.wishes.market.utils.exception.BizException;
import com.wishes.market.utils.security.AESTool;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求拦截读取登录用户
 * //TODO 可在此进行权限校验 暂时不需要
 *
 * @author huangt
 * @create 2018-02-01 15:13
 **/
public class PrivilegeInterceptor extends HandlerInterceptorAdapter {
    // private static final Logger logger = LoggerFactory.getLogger(PrivilegeInterceptor.class);
    // @Autowired
    // private CurrentUserService currentUserService;
    //
    // @Override
    // public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    //     //打印请求
    //     if (!CommConfig.OPTIONS.equals(request.getMethod())) {
    //         String token = request.getHeader("token");
    //         if (StringUtils.isEmpty(token)) {
    //             token = request.getParameter("token");
    //         }
    //         if (handler instanceof HandlerMethod) {
    //             HandlerMethod handlerMethod = (HandlerMethod) handler;
    //             //打印日志
    //             boolean outLog = true;
    //             PrintLog printLog = handlerMethod.getMethodAnnotation(PrintLog.class);
    //             if (null != printLog && printLog.required() == false) {
    //                 outLog = false;
    //             }
    //             if (outLog) {
    //                 StringBuilder sb = new StringBuilder();
    //                 sb.append(request.getRemoteHost())
    //                         .append(" ")
    //                         .append(request.getMethod())
    //                         .append(" ")
    //                         .append(request.getRequestURL()).append(" params:").append(JSONObject.toJSONString(request.getParameterMap()));
    //                 logger.info(sb.toString());
    //                 /*    post body中的内容 流被读取一次 后面controller就不能再读取绑定参数, TODO;HUANGTAO;后续优化
    //                 StringBuffer json = new StringBuffer();
    //                 String line = null;
    //                 BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
    //                 while ((line = reader.readLine()) != null) {
    //                     json.append(line);
    //                 }*/
    //             }
    //             //检查级别  方法 大于 类
    //             CheckLogin checkLogin = handlerMethod.getMethodAnnotation(CheckLogin.class);
    //             if (null == checkLogin) {
    //                 checkLogin = handlerMethod.getBeanType().getAnnotation(CheckLogin.class);
    //             }
    //             if (null != checkLogin && checkLogin.required() && StringUtils.isEmpty(token)) {
    //                 throw new BizException("token失效,请重新登录!");
    //             }
    //         }
    //         //获取登录用户 存储到 会话单例user
    //         if (StringUtils.isNotEmpty(token)) {
    //             String userJson = null;
    //             try {
    //                 userJson = AESTool.decrypt(token, CommConfig.GUANGKONG_KEY);
    //             } catch (Exception e) {
    //                 throw new BizException("token不合法,请重新登录!");
    //             }
    //             if (StringUtils.isNotEmpty(userJson)) {
    //                 PrivilegeInfo privilegeInfo = JSONObject.parseObject(userJson, PrivilegeInfo.class);
    //                 // 获得ip
    //                 String hostContent = request.getHeader("Host");
    //                 String localIp = hostContent.substring(0, hostContent.indexOf(":"));
    //                 privilegeInfo.setIp(localIp);
    //                 currentUserService.setPvginfo(privilegeInfo);
    //             }
    //         }
    //     }
    //
    //     return super.preHandle(request, response, handler);
    // }
    //
    // @Override
    // public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    //     currentUserService.clean();
    //     super.afterCompletion(request, response, handler, ex);
    // }
}
