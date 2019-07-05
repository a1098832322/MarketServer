package com.wishes.market.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie工具
 *
 * @author 郑龙
 * @create 2018年11月21日10:31:03
 **/
public class CookieUtil {

    /**
     * 判断当前登录是否含有cookie
     *
     * @param request
     * @return
     */
    public static boolean isHasCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        return cookies != null;
    }

    /**
     * 从请求中读取cookie
     *
     * @param request
     * @return
     */
    public static String getCookie(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("UId")) {
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

    /**
     * 将信息写入cookie
     *
     * @param response
     * @param cookieName
     * @param value
     */
    public static void writeCookie(HttpServletResponse response, String cookieName, String value) {
        Cookie cookie = new Cookie(cookieName, value);
        cookie.setPath("/");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
    }
}
