package cn.itcast.web.filter;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter("/index.jsp")  //1.具体资源路径
public class FilterDemo4 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo4....");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
