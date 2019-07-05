package com.wishes.market.interceptor;

import com.wishes.market.config.CommConfig;
import com.wishes.market.dto.PrivilegeInfo;
import com.wishes.market.service.CurrentUserService;
import com.wishes.market.utils.CookieUtil;
import com.wishes.market.utils.security.AESTool;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

/**
 * 请求拦截读取登录用户
 * //TODO 可在此进行权限校验 暂时不需要
 *
 * @author huangt
 * @create 2018-02-01 15:13
 **/
@Slf4j
public class PrivilegeInterceptor extends HandlerInterceptorAdapter {
    @Autowired(required = false)
    private CurrentUserService currentUserService;

    private static List<String> urls = new LinkedList<>();

    /**
     * 允许访问的URL列表
     */
    static {
        //swagger
        urls.add("/swagger-resources/");
        urls.add("/swagger-ui.html");
        urls.add("/webjars/");
        urls.add("/v2/");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //对URL白名单放行
        if (urls.contains(request.getRequestURI())) {
            return true;
            //业务接口
        } else if (request.getRequestURI().startsWith("/business/")
                //登录登出接口
                || request.getRequestURI().startsWith("/control/")
                //Api
                || request.getRequestURI().startsWith("/api/")) {
            // 不拦截api请求，ApiAuth会对api请求拦截鉴权。
            return true;
        } else {
            Object userName = null;
            if (request.getSession() != null) {
                userName = request.getSession().getAttribute("userName");
            }

            if ((userName instanceof String)) {
                //如果用户名存在且有效
                //写入用户Service
                PrivilegeInfo privilegeInfo = new PrivilegeInfo();
                privilegeInfo.setAccount(userName.toString());
                currentUserService.setPvginfo(privilegeInfo);
                log.info("用户：" + userName.toString() + " 已登陆！");
                return true;
            } else {
                //检测cookie
                if (CookieUtil.isHasCookie(request)) {
                    //使用cookie
                    try {
                        //拿到加密后的sessionId
                        String sessionId = CookieUtil.getCookie(request);
                        //AES解密
                        sessionId = AESTool.decrypt(sessionId,
                                CommConfig.MARKET_KEY);

                        HttpSession session =
                                request.getSession().getSessionContext()
                                        .getSession(sessionId);
                        String name = (String) session.getAttribute("userName");
                        if (StringUtils.isNotBlank(name)) {
                            //写入用户Service
                            PrivilegeInfo privilegeInfo = new PrivilegeInfo();
                            privilegeInfo.setAccount(name);
                            currentUserService.setPvginfo(privilegeInfo);

                            return true;
                        }
                    } catch (Exception e) {
                        //Cookie和Session验证不通过,则重定向到登录页
                        response.sendRedirect("/views/login");
                    }
                }
            }
        }

        return false;
    }
}
