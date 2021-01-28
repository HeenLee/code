package com.sino.ba03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;

@Aspect
public class MyAspect {
    /**
     * 环绕通知定义方法，方法是实现切面功能的。
     * 方法的定义要求：
     * 1.公共方法 public
     * 2.方法必须有返回值 推荐使用Object
     * 3.方法名称自定义
     * 4.方法有参数，固定参数：ProceedingJointPoint
     */

    /**
     *
     * @Around：环绕通知
     *  属性： 1.value 切入点表达式
     *         位置：在方法定义的上面
     *  特点：
     *   1.它是功能最强的通知
     *   2.在目标方法的前和后都能增强功能
     *   3.控制目标方法是否被调用执行
     *   4.修改原来的目标方法的执行结果。影响最后的调用结果
     *   环绕通知，等同于jdk动态代理的InvcationHandler接口
     *   参数：ProceedingJoinPoint等同于InvationHandler的Method
     *       作用：执行目标方法的
     *    返回值：就是目标方法的执行结果，可以被修改
     *
     *
     *     环绕通知：经常做事务，在目标方法之前开始事务，执行目标方法，在目标方法之后提交事务
     */
    @Around(value= "execution(* *..SomeServiceImpl.doFirst(..))")
    public Object myAround(ProceedingJoinPoint pjp){
       String name = "";
        //获取第一个参数
        Object[] args = pjp.getArgs();
        if (args != null && args.length > 1){
            Object arg = args[0];
            name = (String) arg;
        }
        //实现环绕通知
        Object result = null;
        System.out.println("环绕通知：在目标方法之前，输出时间："+new Date());
        //1.目标方法调用
        if ("zhangsan".equals(name)) {
            //符合条件
            try {
                result = pjp.proceed();              //method.invoke()
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

        System.out.println("环绕通知：在目标方法之后，提交事务：" + new Date());

        //2.在目标方法的前/或者后加入功能

        //修改目标方法的执行结果，影响方法最好的调用结果
        if(result != null){
            result = "hello aspect";
        }
        return result;

    }
}
