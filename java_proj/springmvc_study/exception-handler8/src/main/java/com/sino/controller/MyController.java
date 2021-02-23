package com.sino.controller;

import com.sino.exception.AgeException;
import com.sino.exception.MyUserException;
import com.sino.exception.NameException;
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
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name, Integer age) throws MyUserException {

        ModelAndView mv = new ModelAndView();

        //根据请求参数，抛出异常
        if(!"zs".equals(name)){
            throw new NameException("姓名不正确！");
        }
        if(age==null || age > 80){
            throw new AgeException("年龄比较大！！");
        }

        mv.addObject("myName", name);
        mv.addObject("myAge", age);
        mv.setViewName("show");
        return mv;
    }

}
