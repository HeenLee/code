package cn.itcast.web.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo7 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo7.....");
        chain.doFilter(req, resp);
        System.out.println("filterdemo7回来了");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
