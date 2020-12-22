package cn.itcast.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Demo1被访问了...");
        //第一种
        //访问/responseDemo1,会自动跳转到/responseDemo2资源
        //设置状态码为302
//        response.setStatus(302);
        //设置响应头Location
//        response.setHeader("Location","/servlet_new/responseDemo2");

        //第二种方式
        String contextPath = request.getContextPath(); //动态生成虚拟目录
        response.sendRedirect("/servlet_new/responseDemo2");  //前面的虚拟目录写死不好
//        response.sendRedirect(contextPath + "/responseDemo2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
