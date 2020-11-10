package com.common.lei.random;

import java.util.Random;

public class Demo01Random {
    public static void main(String[] args) {
        Random r = new Random();
        int num = r.nextInt(); //随机选取数字
        System.out.println(num);

    }
}
