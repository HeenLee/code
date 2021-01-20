package com.sino.handler;

import com.sino.util.ServiceTools;

import java.io.ObjectInputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    //目标对象
    private Object target;  //SomeServiceImpl类对象

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //通过代理对象执行方法时，会调用执行这个invoke()
        Object res = null;
        ServiceTools.doLog();

        //执行目标类的方法，通过Method类实现
        method.invoke(target, args);//SomeServiceImpl.doSome  doOther()

        ServiceTools.doTrans();
        //目标方法的执行结果
        return res;
    }
}
