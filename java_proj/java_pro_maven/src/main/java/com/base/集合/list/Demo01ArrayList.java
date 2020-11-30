package com.base.集合.list;

import java.util.ArrayList;

public class Demo01ArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");// 添加元素
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));     //循环遍历，通过get()方法获取元素
        }

        list.set(0,"e");   //设置元素
        System.out.println(list);

    }
}
