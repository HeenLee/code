package com.common.lei.string;

import java.util.Scanner;

/**
 * 按指定格式拼接字符串
 * 把数组[1,2,3]按照指定格式拼接成一个字符串
 * [word1#word2#word3]
 */
public class string {
    public static void main(String[] args) {
        int[] arr = {1,2,3};

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1){
                sb.append("word").append(arr[i]).append("]");
            }else {
                sb.append("word").append(arr[i]).append("#");
            }
        }
        System.out.println(sb.toString());

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        count(str);

    }

    public static void count(String str){
        char[] c = str.toCharArray();
        int countUpper = 0;
        int countLower = 0;
        int countNum = 0;
        int countOther = 0;
        for (int i = 0; i < c.length; i++) {
            char ch = c[i];
            if('A' <= ch && ch <= 'Z'){  //大写字母范围
                 countUpper++;
            }else if('a' <= ch && ch <= 'z'){   //小写字母范围
                countLower++;
            }else if('0' <= ch && ch <= '9'){   //数字范围
                countNum++;
            }else{
                countOther++;
            }
        }
        System.out.println(countUpper);
        System.out.println(countLower);
        System.out.println(countNum);
        System.out.println(countOther);
    }
}
