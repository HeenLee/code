package com.sino.controller;

import com.sino.domain.Student;
import com.sino.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String strId = request.getParameter("id");
        String strName = request.getParameter("name");
        String strEmail = request.getParameter("email");
        String strAge = request.getParameter("age");

        //方法1.创建spring的容器对象
/*        String config = "spring.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);*/   //非全局对象

        WebApplicationContext ctx = null;   //全局容器对象
 /*       //方法2.获取ServletContext中的容器对象，创建好的容器对象，拿来就用
        String key = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        Object attr = getServletContext().getAttribute(key);
        if(attr != null){
            ctx = (WebApplicationContext) attr;
        }*/

        //方法3.使用框架中的方法，获取容器对象
        ServletContext sc = getServletContext();
        WebApplicationContextUtils.getRequiredWebApplicationContext(sc)
        System.out.println("容器对象的信息：" + ctx);

        //获取service
        StudentService service = (StudentService) ctx.getBean("studentService");
        Student student = new Student();
        student.setId(Integer.parseInt(strId));
        student.setName(strName);
        student.setEmail(strEmail);
        student.setAge(Integer.parseInt(strAge));

        service.addStudent(student);

        //给一个结果页面
        request.getRequestDispatcher("/result.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
