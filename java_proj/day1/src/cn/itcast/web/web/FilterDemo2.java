package cn.itcast.web.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对request对象的请求消息增强
        System.out.println("filterdemo2执行了...");
        //放行
        chain.doFilter(req, resp);

        //对response对象的响应消息增强
        System.out.println("filterdemo2回来了");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
