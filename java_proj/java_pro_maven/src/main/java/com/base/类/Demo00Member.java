package com.base.类;

import java.util.ArrayList;
import java.util.Random;

/**
 * 普通成员
 */
public class Demo00Member extends Demo00User {
    public Demo00Member() {
    }

    public Demo00Member(String name, int balance) {
        super(name, balance);
    }

    //收红包
    public void receive(ArrayList<Integer> list){
        int balance = super.getBalance();
        //从多个红包中随机抽取一个
        int index = new Random().nextInt(list.size());
        //集合中的红包，取一个要删一个
        int money = list.remove(index);
        //把自己原来的 和 收到的红包加起来，重置自己的余额
        super.setBalance(balance + money);

    }
}
