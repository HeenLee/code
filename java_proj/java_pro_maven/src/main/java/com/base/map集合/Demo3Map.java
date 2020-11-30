package com.base.map集合;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Demo3Map {
    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();
        map.put(new Person("女王", 18), "英国");
        map.put(new Person("秦始皇", 15), "秦国");
        map.put(new Person("普京", 30), "俄罗斯");
        map.put(new Person("女王", 18), "法国");
        System.out.println(map);

        Map<String, String> s = new LinkedHashMap<>();
        s.put("小胡", "12");
        s.put("小高", "12");
        s.put("小王", "12");
        s.put("小周", "12");
        System.out.println(s);


    }
}
