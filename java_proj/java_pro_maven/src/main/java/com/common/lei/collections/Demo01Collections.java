package com.common.lei.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo01Collections {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "a", "b", "c", "d");  //往集合中添加元素
        System.out.println(list);

        Collections.shuffle(list); //打乱顺序

        System.out.println(list);

        Collections.sort(list); //默认顺序
        System.out.println(list);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        System.out.println(list);

    }
}
