package com.base.map;

/**
 *
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 添加 删除map元素
 */
public class Demo01Map {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        String v = map.put("张三", "18");  //添加元素
        String v2 = map.put("张三", "20");
        System.out.println(v2);
        System.out.println(map);

        map.put("小明","10");

        String value1 = map.remove("张三");  //删除元素
        String value2 = map.remove("小强");
        System.out.println(value1);
        System.out.println(value2);

        System.out.println(map);


        //
        String value3 = map.get("小明");  //获取元素
        String value4 = map.get("小吴");  //获取元素
        System.out.println(value3);
        System.out.println(value4); //null


        boolean b = map.containsKey("小明"); //判断是否包含键
        System.out.println(b);
    }
}
