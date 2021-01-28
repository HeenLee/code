package com.sino;

import com.sino.service.SomeService;
import com.sino.service.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class SomeServiceTest {
    @Test
    public void test01(){
        SomeService someService = new SomeServiceImpl();
        someService.doSome();
    }

    /**
     * spring默认创建对象的时间：在创建spring的容器时，会创建配置文件中所有的对象
     */
    @Test
    public void test02() {
        //使用spring容器创建的对象
        //1.指定spring配置文件的名称
        String config = "beans.xml";
        //2.创建表示spring容器的对象 AapplicationContext
        //ApplicationContext就表示Spring容器，通过容器对象就能够获取对象了
        //ClassPathXmlApplicationContext表示从类路径中加载spring的配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        //从容器中获取某个对象，需要调用方法
        //getBean("配置文件中bean的id值")
        SomeService someService = (SomeService) context.getBean("someService");
        //使用spring创建好的对象调用方法
        someService.doSome();
    }

    /**
     * 获取容器中java对象的方法
     */
    @Test
    public void test03(){
        String config = "beans.xml";
        ApplicationContext context  = new ClassPathXmlApplicationContext(config);
        //使用spring提供的方法，获取容器中定义的对象的数量
        int count = context.getBeanDefinitionCount();
        System.out.println(count);

        //容器中每个定义的对象的名称
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);

        }
    }

    /**
     * 创建非自定义对象
     */
    @Test
    public void test04(){
        String config = "beans.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        Date mydate = (Date) context.getBean("mydate");
        System.out.println(mydate);

    }

}
