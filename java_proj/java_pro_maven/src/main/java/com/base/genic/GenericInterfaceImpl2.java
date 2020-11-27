package com.base.genic;

/**
 * 含有泛型的接口，第二种使用方式：定接口使用什么泛型，实现类就使用什么泛型.
 * 就相当于定义一个含有泛型的类，创建对象的时候确定泛型的类型
 *
 */
public class GenericInterfaceImpl2<I> implements GenericInterface<I>{
    public void method(I i ) {
        System.out.println(i);

    }
}
