package com.sino.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @RequestMapping
 *   value：所有请求地址的公共部分，叫作模块名称。
 *   位置：放在类的上面
 *   访问是/test/some.do
 */
@Controller
public class MyController {

    /**
     * 处理器方法返回ModelAndView实现转发forward
     * 语法：setViewName("forward:视图文件完整路径")
     * 特点： 不和视图解析器一同使用，就当项目中没有视图解析器
     */
    @RequestMapping(value = "/doForward.do")
    public ModelAndView doSome(){

        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用springmvc做web开发");
        mv.addObject("fun", "执行的是doSome方法");
        mv.setViewName("forward:/WEB-INF/view/show.jsp");
        return mv;
    }

    /**
     * 处理器返回ModelAndView 实现重定向
     * 语法 ：setViewName("redirect"/路径")
     * 特点： 不和视图解析器一同使用，就当项目中没有视图解析器
     * 框架对重定向的操作：
     * 1.框架会把Model中的简单类型的数据，转为String使用，作为hello.jsp的get请求参数使用
     *   目的是在doRedirect.do和hello.jsp两次请求之间传递数据
     *
     */
    @RequestMapping(value = "/doRedirect.do")
    public ModelAndView doWithRedirect(String name ,Integer age){

        ModelAndView mv = new ModelAndView();
        mv.addObject("myName", name);
        mv.addObject("myAge", age);
        mv.setViewName("redirect:/hello.jsp");
        return mv;
    }

}
