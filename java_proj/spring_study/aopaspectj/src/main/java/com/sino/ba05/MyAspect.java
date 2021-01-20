package com.sino.ba05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyAspect {
    /**
     * 最终通知定义方法，方法是实现切面功能的。
     * 方法的定义要求：
     * 1.公共方法 public
     * 2.方法没有返回值
     * 3.方法名称自定义
     * 4.方法没有参数，如果有是joinpoint
     */

    /**
     * @After：最终通知
     *  属性： 1.value 切入点表达式
     *         位置：在方法定义的上面
     *   特点：1.总是会执行 即使有异常，也执行
     *         2.在目标方法之后执行的
     */
    @After(value= "execution(* *..SomeServiceImpl.doThird(..))")
    public void myAfter(){
        System.out.println("执行最终通知，总是会被执行的代码：" );
        //一般做资源清除工作的
    }
}
