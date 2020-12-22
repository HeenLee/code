package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

//获取通用请求参数
@WebServlet("/requestDemo4")
public class RequestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post获取请求参数
        String username = request.getParameter("username");

        //根据名称获取参数值
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }


        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String parameterName = parameterNames.nextElement();
            String parameterValue = request.getParameter(parameterName);
            System.out.println(parameterName + "----" + parameterValue);
        }


        Map<String, String[]> parameterMap = request.getParameterMap();
        for (String key : parameterMap.keySet()) {
            System.out.println(key);
            //根据key获取值
            String[] values = parameterMap.get(key);
            for (String value : values) {
                System.out.println(value);
            }
            System.out.println("--------------");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get 获取请求参数

/*        String username = request.getParameter("username");
        System.out.println("get");
        System.out.println(username);*/
        this.doPost(request, response);
    }
}
