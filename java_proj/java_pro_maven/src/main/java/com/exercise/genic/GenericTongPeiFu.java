package com.exercise.genic;
/**
 * 泛型通配符的使用
 * 需要将？作为方法参数传递
 */

import java.util.ArrayList;

public class GenericTongPeiFu {
    public static void main(String[] args) {
        //泛型为String
        ArrayList<String> list01 = new ArrayList<>();
        list01.add("a");
        list01.add("b");

        //泛型为Integer
        ArrayList<Integer> list02 = new ArrayList<>();
        list02.add(1);
        list02.add(2);

        printArr(list01);
        printArr(list02);  //只能遍历String泛型
    }

    //遍历list集合
    public static void printArr(ArrayList<?> list){
        for (Object s : list) {    //泛型接收时用Object
            System.out.println(s);
        }
    }

}
