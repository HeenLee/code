package com.sino;

import com.sino.ba02.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest02 {
    @Test
    public void test01(){
        String config = "ba02/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
       //从容器中获取目标对象
        SomeService proxy = (SomeService) context.getBean("someService");
        //通过代理的对象执行方法，实现目标方法执行时，增强了功能
        String str = proxy.doOther("zhangsan", 1);
        System.out.println(str);


    }
}
