package com.common.常用类.objects;

import java.util.Random;

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person("xiaoming",18);
        Person p2 = new Person("xiaoming",18);

        Random r = new Random();
        boolean b = p1.equals(r);
        System.out.println(b);

    }
}
