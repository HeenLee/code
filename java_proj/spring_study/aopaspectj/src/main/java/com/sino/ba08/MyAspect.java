package com.sino.ba08;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

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

    @Before(value= "execution(* *..SomeServiceImpl.doThird(..))")
    public void myBefore(){
        System.out.println("前置通知，在目标方法之前执行的" );
        //一般做资源清除工作的
    }


    @After(value= "mypt()")
    public void myAfter1(){
        System.out.println("执行最终通知mypt，总是会被执行的代码：" );
        //一般做资源清除工作的
    }

    @Before(value= "mypt()")
    public void myBefore1(){
        System.out.println("前置通知mypt，在目标方法之前执行的" );
        //一般做资源清除工作的
    }
    /**
     * 以上两个切入点表达式重复了。可以使用@Pointcut
     * @Pointcut:定义和管理切入点，如果你的项目中有多个切入点表达式是重复的，可以复用的
     *      可以使用@Pointcut
     *  属性：
     *      value: 切入点表达式
     *      位置：在定义方法的上面
     *  特点：
     *    当使用@Pointcut定义在一个方法的上面，此时这个方法的名称就是切入点表达式的别名
     *     其他的通知中，value属性就可以使用这个方法名称，代替切入点表达式了
     */
    @Pointcut(value="execution(* *..SomeServiceImpl.doThird(..))")
    private void mypt(){
        //无需代码
    }
}
