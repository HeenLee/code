package com.base.接口;

/**
 * 接口默认方法
 */
public interface Demo02MyInterfaceDefault {
    public abstract void methodAbs();

    public default void methodDefault(){
        System.out.println("这是新添加的默认方法");
    }
}
