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

    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name, Integer age){
        System.out.println("-----执行MyController的doSome方法----");
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName", name);
        mv.addObject("myAge", age);
        mv.setViewName("show");
        return mv;
    }

}
