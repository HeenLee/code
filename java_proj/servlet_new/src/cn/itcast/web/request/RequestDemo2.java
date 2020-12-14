package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 获取请求头数据
 */
@WebServlet("/requestDemo2")
public class RequestDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取所有请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();

        //2.遍历
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            String value = request.getHeader(headerName);
            System.out.println(headerName + ":" + value);
        }

        String referer = request.getHeader("referer");
        System.out.println("referer::::" + referer);
    }
}
