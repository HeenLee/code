package com.common.常用类.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * Arrays.toString(数组)
 * Arrays.sort(数组)
 *
 */
public class Demo01Arrays {
    public static void main(String[] args) {
        int[] arr = {10,20,30,5,11,35};
        //数组转为字符串
        String strArr = Arrays.toString(arr);
        System.out.println(strArr);  //[10,20,30,5,11,35]
       //排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));   //[5, 10, 11, 20, 30, 35]

        List<Integer> numbers = Arrays.asList(10, 1, 2, 4, 8);  //asList接收可变参数，返回列表
        System.out.println(numbers);
    }
}
