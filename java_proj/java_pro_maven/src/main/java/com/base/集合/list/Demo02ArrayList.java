package com.base.集合.list;

import java.util.ArrayList;

/**
 * 指定格式输出集合
 * 原来 [a,b,c,d]
 * 输出{a@b@c@d}
 */
public class Demo02ArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");// 添加元素
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println("原来数组:" + list);

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < list.size(); i++) {
            if( i == list.size() - 1){
                sb.append(list.get(i)).append("}");
            }else {
                sb.append(list.get(i)).append("@");
            }
        }
        System.out.println(sb.toString());
    }
}
