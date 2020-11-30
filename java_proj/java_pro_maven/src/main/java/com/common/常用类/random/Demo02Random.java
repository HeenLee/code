package com.common.常用类.random;


import java.util.Random;
import java.util.Scanner;

/**
 * 猜数字游戏:
 * 如果猜的过大，提示太大，反之太小，继续输入
 * 猜正确，结束循环
 */
public class Demo02Random {
    public static void main(String[] args) {
        Random r = new Random();
        int num = r.nextInt(100) + 1;   //获取[1,100]的整数
        System.out.println(num);
        Scanner sc = new Scanner(System.in);   //创建键盘输入对象
        while(true){
            System.out.println("请输入一个数字:");
            int guessNum = sc.nextInt();
            if(guessNum < num){
                System.out.println("太小了");
            }else if(guessNum > num){
                System.out.println("太大了");
            }else{
                System.out.println("正确");
                break;
            }

        }
    }
}
