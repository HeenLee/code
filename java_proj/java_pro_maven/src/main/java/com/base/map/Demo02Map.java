package com.base.map;

/**
 *
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 遍历集合
 *
 */
public class Demo02Map {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("张三", "20");
        map.put("小明","10");
        map.put("小文","18");

        //通过keySet获取键的集合
        Set<String> keys = map.keySet();
        //增强for循环
        for (String key : keys) {
            System.out.println(key + ": " + map.get(key));
        }

        System.out.println("================");
        //迭代器遍历键的集合
        Iterator<String> it = keys.iterator();
        while (it.hasNext()){
            String key = it.next();
            String value  = map.get(key);
            System.out.println(key + ":" + value);
        }

        //通过entry键值对遍历
        Set<Map.Entry<String,String>> entryset = map.entrySet();
        for (Map.Entry<String, String> entry : entryset) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);

        }
        
        Iterator<Map.Entry<String,String>> iterator = entryset.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);

        }
        System.out.println(entryset);
        System.out.println(map);
    }
}
