package cn.itcast.web.filter;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo3 implements Filter {
    /**
     * 服务器关闭后，Fileter对象被销毁。如果服务器正常关闭，会执行destory方法。只执行一次
     * 释放资源
     */
    public void destroy() {
        System.out.println("destory...");
    }

    /**
     *每一次请求被拦截资源时，会执行。执行多次
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterdemo3...");
        chain.doFilter(req, resp);
    }

    /**
     * 服务器启动后，会创建Filter对象，然后调用init方法。只执行一次。加载资源
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init...");
    }

}
