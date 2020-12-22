package cn.itcast.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 输出字符流
 */
@WebServlet("/responseDemo3")
public class ResponseDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取流之前，设置流的默认编码：ISO  设置为GBK
//        response.setCharacterEncoding("UTF-8");  设置了content-type 的utf-8 该句可以不写

        //告诉浏览器，服务器发送的消息体数据的编码。建议浏览器使用该编码解码
//        response.setHeader("content-type", "text/html;charset=utf-8");
        response.setContentType("text/html;charset=utf-8");

        //1.获取字符输出流
        PrintWriter pw = response.getWriter();
        //2.输出数据
        pw.write("<h1>hello, response</h1>");
        pw.write("你好啊啊");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
