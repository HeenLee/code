package cn.itcast.web.servletcontext;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        1.获取文件的真实路径
         */
       //1.通过httpServlet获取servletContext
        ServletContext context = this.getServletContext();

        //获取文件的服务器路径
        String realPath = context.getRealPath("/b.txt"); //web目录下资源访问
        System.out.println(realPath);
        File file = new File(realPath);

        String realPath1 = context.getRealPath("/WEB-INF/c.txt"); //WEB-INF目录下资源访问
        System.out.println(realPath1);


        String realPath2 = context.getRealPath("/WEB-INF/classes/a.txt"); //WEB-INF目录下资源访问
        System.out.println(realPath2);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
