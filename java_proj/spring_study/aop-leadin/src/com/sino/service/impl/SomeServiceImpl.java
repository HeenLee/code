package com.sino.service.impl;

import com.sino.handler.MyInvocationHandler;
import com.sino.service.SomeService;
import com.sino.util.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

//service类的代码不修改，也能够增加输出时间，事务的操作
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        System.out.println("执行业务方法doSome");

/*    老的方式    ServiceTools.doLog();//虽然可以解决，但是不是最好的。   非业务方法
        System.out.println("执行业务方法doSome");
        ServiceTools.doTrans();  //虽然可以解决，但是不是最好的。   非业务方法*/


    }

    @Override
    public void doOther() {

        System.out.println("执行业务方法doOther");

    }
}
