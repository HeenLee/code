package com.base.集合.list;

import java.util.LinkedList;

public class Demo4LinkedList {
    public static void main(String[] args) {
        //创建linkedList集合对象
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        list.addFirst("1");  //集合开头添加
        list.addFirst("0");

        list.addLast("6");   //集合结尾添加
        list.addLast("5");   //addLast等效于add()


        list.push("-1");  //push 等效于addFirst()
        System.out.println(list);

        String first = list.getFirst();
        System.out.println(first);

        String last = list.getLast();
        System.out.println(last);

        String rmfirst = list.removeFirst();
        System.out.println(rmfirst);

        String rmlast = list.removeLast();
        System.out.println(rmlast);

        String pop = list.pop();
        System.out.println(pop);
        System.out.println(list);

    }
}
