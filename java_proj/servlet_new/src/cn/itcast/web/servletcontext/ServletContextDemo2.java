package cn.itcast.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        1.获取MIME类型
         */
       //1.通过httpServlet获取servletContext
        ServletContext context = this.getServletContext();
        //2.定义文件名称
        String file = "a.jpg";
        //3.获取MIME类型
        String mimeType = context.getMimeType(file);
        System.out.println(mimeType);  //image/jpeg


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
