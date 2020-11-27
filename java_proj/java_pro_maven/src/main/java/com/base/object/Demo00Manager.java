package com.base.object;

import java.util.ArrayList;

/**
 * 群主类
 */
public class Demo00Manager extends Demo00User {
    public Demo00Manager() {
    }

    public Demo00Manager(String name, int balance) {
        super(name, balance);
    }

    /**
     * @param  totalMoney 发出去的红包金额
     * @param count  红包个数
      * @return 发完分成若干份
     */
    public ArrayList<Integer> send(int totalMoney, int count){
        //需要一个集合，存储若干红包的金额
        ArrayList<Integer> redList = new ArrayList<>();

        //首先看一下群主自己有多少钱
        int balance = super.getBalance();
        //判断剩余的钱 要是小于发出去的，就提示不足
        if (balance < totalMoney){
            System.out.println("余额不足");
            return redList;
        }

        //要是钱够，就开始平给每个红包放钱，平均分到整数的钱
        int avg = totalMoney / count;
        //要是除不尽，有剩下的钱，则默认加到最后一个红包上
        int mod = totalMoney % count;

        //遍历红包集合，将钱放到集合中.这里需要注意，平均分给几个红包，得留一个红包放除不尽的钱，所有默认放到最后一个红包
        //遍历的时候，平均的放到count - 1
        for (int i = 0; i < count - 1; i++) {
            redList.add(avg);
        }
        redList.add(avg + mod);

        //这样，群主剩余钱数为 balance - totalMoney,重置余额
        super.setBalance(balance - totalMoney);
        return redList;

    }
}
