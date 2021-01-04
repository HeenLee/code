package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo6 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo6.....");
        chain.doFilter(req, resp);
        System.out.println("filterdemo6回来了");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
