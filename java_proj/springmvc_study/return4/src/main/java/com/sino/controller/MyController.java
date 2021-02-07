package com.sino.controller;

import com.sino.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @RequestMapping
 *   value：所有请求地址的公共部分，叫作模块名称。
 *   位置：放在类的上面
 *   访问是/test/some.do
 */
@Controller
public class MyController {

    /**
     * 处理器方法返回String 表示逻辑视图名称 需要适配视图解析器
     */
    @RequestMapping(value = "/returnString-view.do")
    public String doReturnView(HttpServletRequest request, String name ,int age){
        System.out.println("name:" + name + " " + "age:" + age);

        //可以手工添加数据到request作用域
        request.setAttribute("myName",name);
        request.setAttribute("myAge", age);
        //show：逻辑视图名称，项目中配置了视图解析器
        //框架对视图执行forward转发操作
        return "show";
    }

    //处理方法返回String，表示完整视图路径，此时不能配置视图解析器
    @RequestMapping(value = "/returnString-view2.do")
    public String doReturnView2(HttpServletRequest request, String name ,int age){
        System.out.println("===doreturn2===" + "name:" + name + " " + "age:" + age);

        //可以手工添加数据到request作用域
        request.setAttribute("myName",name);
        request.setAttribute("myAge", age);
        //完整视图路径，项目中不能配置视图解析器
        //框架对视图执行forward转发操作
        return "/WEB-INF/view/show.jsp";
    }

    /**
     * 处理方法返回Student,通过框架转为json,响应ajax请求
     * @ResponseBody
     *  作用：把处理器方法返回对象转为json后，通过HttpServletResponse转出给浏览器
     *  位置：在方法的定义上面，和其他注解没有顺序的关系。
     *  返回对象框架的处理流程：
     *      1.框架会把返回的student类型，调用框架中ArrayList<HttpMessageConverter>中每个类的参write()方法
     *      2.框架会调用实现类的wirte()方法。把李四同学的student对象转为json
     *      3.框架会调用@ResponseBody把2的结果数据输出到浏览器，ajax请求处理完成
     *
     */
    @RequestMapping(value = "/returnStudentJson.do")
    @ResponseBody
    public Student doStudentJsonObject( String name ,int age){
        //调用service 获取请求结果数据。 student对象表示结果数据
        Student student = new Student();
        student.setName("李四");
        student.setAge(20);
        return student; //会被框架转为json
    }

    /**
     * 处理器方法发挥List<Student></Student>
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/returnStudentJsonArray.do")
    @ResponseBody
    public List<Student> doStudentJsonObjectArray(String name , Integer age){
        List<Student> list = new ArrayList<>();
        //调用service 获取请求结果数据。 student对象表示结果数据
        Student student = new Student();
        student.setName("李四");
        student.setAge(20);
        list.add(student);

        student = new Student();
        student.setName("张三");
        student.setAge(28);
        list.add(student);
        return list; //返回list。
    }

    /**
     * 处理器方法返回的是Strig  String表示数据的，不是视图
     * 区分返回值String是数据，还是视图。 看有没有@ResponseBody注解
     * 如果有@ResponseBody注解，返回String就是数据，反之就是视图
     * 默认使用text/plain;charset=ISO-8859-1 导致中文乱码
     * 解决方案：给RequestMapping 增加一个属性produces,使用这个属性指定新的contentType
     *
     *
     */
    @RequestMapping(value = "/returnStringData.do",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String doStringDate(String name , Integer age){
        return "hello springmvc返回对象，表示数据";
    }
}
