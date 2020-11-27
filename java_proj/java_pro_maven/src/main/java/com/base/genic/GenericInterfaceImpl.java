package com.base.genic;

/**
 * 含有泛型的接口，第一种使用方式：定义接口的实现类,实现接口的时候，指定接口的泛型
 * public final class Scanner implements Interator<String>
 *
 */
public class GenericInterfaceImpl implements GenericInterface<String>{
    public void method(String s ) {
        System.out.println(s);

    }
}
