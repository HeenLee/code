package com.base.map集合;
/**
 * 计算一个字符串中每个字符出现次数
 *
 * 1.使用Scanner获取输入的字符串
 * 2. 创建map集合，key是字符串中的字符，value是字符的个数
 * 3. 遍历字符串，获取每一个字符
 * 4. 使用获取到的字符，去map集合判断key是否存在
 *     key存在：
 *          通过字符key 获取value的个数
 *          value++
 *          put(key,value)把新的value存储到集合中
 *     key不存在
 *          put(key,1)
 * 5.  遍历map集合
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo04Map {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String content = sc.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        Integer count = 0;
        char[] ch = content.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if(map.containsKey(ch[i])){
                Integer value = map.get(ch[i]);
                value++;
                map.put(ch[i],value);
            }else{
                map.put(ch[i], 1);
            }
        }
        System.out.println(map);


    }
}
