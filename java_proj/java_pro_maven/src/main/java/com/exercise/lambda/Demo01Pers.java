package com.exercise.lambda;

import java.util.Arrays;
import java.util.Comparator;

/*
lambda 表达式有参数有返回值的联系
需求：
    使用数组存储多个Person对象
    对数组中的Person对象使用Arrays的sort方法通过年龄进行升序排序
 */
public class Demo01Pers {
    public static void main(String[] args) {
        Person[] arr = {
                    new Person("小王",18),
                    new Person("小红",20),
                    new Person("小明",28),
                    new Person("小强",30),
        };
/*
        //排序需要实现Comparator接口
        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });*/


        //使用Lambda表达式，简化匿名内部类
        Arrays.sort(arr, (Person p1,Person p2) -> {
            return p1.getAge() - p2.getAge();
        });

        for (Person person : arr) {
            System.out.println(person);
        }
    }
}
