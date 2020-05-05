package com.wishes.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 主页控制器。修复默认主页直接跳转到index，导致页面中链接跳转不正常的bug
 *
 * @author zl
 * @date 2020/5/5 15:06
 */
@Controller
public class IndexController {
    /**
     * 默认主页重定向
     *
     * @param response response
     * @throws IOException 异常
     */
    @RequestMapping("/")
    public void defaultIndex(HttpServletResponse response) throws IOException {
        response.sendRedirect("/console/views/index");
    }

    /**
     * 指定index页重定向
     *
     * @param response response
     * @throws IOException 异常
     */
    @RequestMapping("/index")
    public void index(HttpServletResponse response) throws IOException {
        response.sendRedirect("/console/views/index");
    }
}
