package com.sino.service;

import com.sino.handler.MyInvocationHandler;
import com.sino.service.impl.SomeServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MyApp {
    public static void main(String[] args) {
        SomeService service = new SomeServiceImpl();
 /*    老的方式    ServiceTools.doLog();//虽然可以解决，但是不是最好的。   非业务方法
        System.out.println("执行业务方法doSome");
        ServiceTools.doTrans();  //虽然可以解决，但是不是最好的。   非业务方法*/


        //使用jdk的Proxy创建代理对象
        //创建目标对象
        SomeService target = new SomeServiceImpl();

        //创建InvocationHandler对象
        InvocationHandler handler = new MyInvocationHandler(target);

        //使用Proxy创建代理
        SomeService proxy = (SomeService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);

        //通过代理方法，会调用handler中的invoke()
        proxy.doSome();
        proxy.doOther();
    }
}
