package com.sino.controller;

import com.sino.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @RequestMapping
 *   value：所有请求地址的公共部分，叫作模块名称。
 *   位置：放在类的上面
 *   访问是/test/some.do
 */
@Controller
public class MyController {

    /**
     * 逐个接收请求的参数
     *  要求：处理器(控制器)方法的形参名和请求中参数名必须一致。
     *     同名的请求参数赋值给同名的形参
     *   框架接收请求参数
     *         1.使用request对象接收请求参数
     *          String name = request.getParameter("name")
     *          String age = request.getParameter("age")
     *         2.springmvc框架通过DispatcherServlet调用MyController的doSome()方法
     *           调用方法时，按名称对应，把接收的参数赋值给形参
     *           doSome(name,Integer.valueOf(age))
     *           框架会提供类型转换的功能，能把String转为int，long，float，double等类型
     *   400的状态码：客户端错误，表示提交请求参数过程中发生了问题
     *
     *
     * @return
     */
    @RequestMapping(value = "/receiveproperty.do")
    public ModelAndView doSome(String name ,int age){
        //可以在方法中直接使用name，age
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName", name);
        mv.addObject("myAge", age);

        //show是视图文件的逻辑名称（文件名称）
        mv.setViewName("show");
        //返回mv
        return mv;
    }

    /**
     * 请求中参数名和处理器方法的形参名不一样
     * @RequestParam：接收请求参数中，解决请求中参数名和形参名不一样的问题
     *   属性： 1. value 请求中的参数名称
     *          2. required 是一个boolean 默认是true。true表示请求中必须包含此参数
     *   位置： 在处理器方法的形参定义的前面
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/receiveparam.do")
    public ModelAndView receiveParam(@RequestParam(value = "rname",required = false) String name ,
                                     @RequestParam(value = "rage",required = false)Integer age){
        System.out.println("name=" + name + " " + "age=" + age);
        //可以在方法中直接使用name，age
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName", name);   //Model ：模拟数据
        mv.addObject("myAge", age);

        //show是视图文件的逻辑名称（文件名称）
        mv.setViewName("show");             //视图
        //返回mv
        return mv;
    }

    /**
     *处理器方法形参是java对象，这个对象的属性名和请求参数名一样的
     * 框架会创建形参的java对象，给属性赋值。请求中的参数是name，框架会调用setName()
     * @return
     */
    @RequestMapping(value = "/receiveobject.do")
    public ModelAndView receiveParam(Student myStudent){
        System.out.println("receiveParam" + "name=" + myStudent.getName() + " " + "age=" + myStudent.getAge());
        //可以在方法中直接使用name，age
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName", myStudent.getName());
        mv.addObject("myAge", myStudent.getAge());
        mv.addObject("myStudent", myStudent);
        //show是视图文件的逻辑名称（文件名称）
        mv.setViewName("show");
        //返回mv
        return mv;
    }




}
