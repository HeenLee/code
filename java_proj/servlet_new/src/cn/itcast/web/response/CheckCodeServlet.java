package cn.itcast.web.response;

import jdk.nashorn.internal.ir.WithNode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 输出字符流
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        //1. 创建一对象，在内存中图片（验证码图片对象）
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //2 美化图片
        //2.1填充背景色
        Graphics g = image.getGraphics();//画笔对象
        g.setColor(Color.PINK); //设置画笔颜色
        g.fillRect(0,0, width,height);

        //2.2 画边框
        g.setColor(Color.BLUE);
        g.fillRect(0,0, width-1,height-1);
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //获取字符
        //生成随机角标
        Random r = new Random();
        for (int i = 1; i <= 4; i++) {
            int index = r.nextInt(str.length());
            //获取字符
            char c = str.charAt(index);//随机字符
            g.drawString(c+"",width/5*i,height/2);
        }





        //2.3写验证码

        g.drawString("B",40,25);
        g.drawString("C",60,25);
        g.drawString("D",80,25);

        //3. 将图片输出到页面展示
        ImageIO.write(image, "jpg", response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
