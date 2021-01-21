package com.sino;

import com.sino.ba07.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest07 {
    @Test
    public void test01(){
        String config = "ba07/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
       //从容器中获取目标对象
        SomeServiceImpl proxy = (SomeServiceImpl) context.getBean("someService");

        /**
         * 目标类没有接口，使用cglib动态代理，spring框架会自动应用cglib
         */
        //通过代理的对象执行方法，实现目标方法执行时，增强了功能
        System.out.println(proxy.getClass().getName());
        proxy.doThird();


    }
}
