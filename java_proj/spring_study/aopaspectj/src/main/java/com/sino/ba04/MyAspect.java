package com.sino.ba04;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyAspect {
    /**
     * 异常通知定义方法，方法是实现切面功能的。
     * 方法的定义要求：
     * 1.公共方法 public
     * 2.方法没有返回值
     * 3.方法名称自定义
     * 4.方法有一个Exception，如果还有是joinpoint
     */

    /**
     * @AfterThrowing：异常通知
     *  属性： 1.value 切入点表达式
     *         2.throwding 自定义的变量，表示目标方法抛出的异常对象
     *           自定义变量名必须和方法的参数名一样。
     *         位置：在方法定义的上面
     *  特点：
     *   1.在目标方法之抛出异常时执行的
     *   2.可以做异常的监控程序，监控目标方法执行时是不是有异常
     *   如果有异常，可以发送邮件，短信进行通知
     *
     *   执行就是：
     *     发送异常执行
     */
    @AfterThrowing(value= "execution(* *..SomeServiceImpl.doSecond(..))", throwing = "ex")
    public void myAfterThrowing(Exception ex){
        System.out.println("异常通知：方法发送异常时执行：" + ex.getMessage());
        //发送邮件、短信通知开发人员

    }
}
