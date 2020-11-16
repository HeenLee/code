package com.exercise.neibulei;

import java.util.ArrayList;
import java.util.List;

public class Demo03Interface {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> result = addNames(list);
        System.out.println(result);

    }

    public static List<String> addNames(List<String > list){
        list.add("小米");
        list.add("小红");
        list.add("小王");
        return list;
    }
}
