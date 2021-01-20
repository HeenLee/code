package com.sino;

import com.sino.ba04.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest04 {
    @Test
    public void test01(){
        String config = "ba04/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
       //从容器中获取目标对象
        SomeService proxy = (SomeService) context.getBean("someService");
        //通过代理的对象执行方法，实现目标方法执行时，增强了功能
        proxy.doSecond();


    }
}
