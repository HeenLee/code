package com.sino.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/user")
public class MyController {
    /**
     * @RequestMapping：请求映射
     *   属性：method 表示请求的方式。它的值RequestMethod类枚举值。
     *          例如表示get请求方式：RequestMethod.GET
     *                  post  ：RequestMethod.POST
     *
     *
     */
    //指定get请求
    @RequestMapping(value = {"/some.do", "/first.do"},method = RequestMethod.GET)
    public ModelAndView doSome(){   //doGet() --调用service处理请求
        //处理some.do请求了。相当于service调用处理完成了。
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","欢迎使用springmvc做web开发");
        mv.addObject("fun", "执行的是doSome方法");

        mv.setViewName("show");
        //返回mv
        return mv;
    }

    //指定post请求
    @RequestMapping(value = {"/other.do", "/second.do"}, method = RequestMethod.POST)
    public ModelAndView doOther(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","欢迎使用springmvc做web开发");
        mv.addObject("fun", "执行的是doOther方法");
        mv.setViewName("other");
        //返回mv
        return mv;
    }

    //不指定请求方式，没有限制
    @RequestMapping(value = "/hello.do")
    public ModelAndView doHello(HttpServletRequest request, HttpServletResponse response
                                , HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","欢迎使用springmvc做web开发===" + request.getParameter("name"));
        mv.addObject("fun", "执行的是doOther方法");
        mv.setViewName("other");
        //返回mv
        return mv;
    }


}
