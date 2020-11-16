package com.red;

import java.util.ArrayList;
import java.util.Random;

public class RandomRed implements OpenMode{
    @Override
    public ArrayList<Integer> divide(int totalMoney, int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();
        //随机分配，有可能多，有可能少
        //最少1分钱，最多不超过“剩下金额平均数的2倍"   10元发3个  平均3.33
        //第一次发红包，随机范围0.01-3.33*2
        //第一次发完后，剩下至少3.34
        // 还要发2两个红包，再发范围0.01-3.34（剩下0.01）
        //范围公式 1 + random.nextInt(leftMoney / leftCount * 2)
        Random r = new Random();
        int leftMoney = totalMoney;
        int leftCount = totalCount;

        //随机发前n-1 最后一个不需要速记
        for (int i = 0; i < totalCount - 1; i++) {
            int money = r.nextInt(leftMoney / leftCount * 2) + 1;
            list.add(money);
            leftMoney -= money;
            leftCount-- ;
        }
        list.add(leftMoney);

        return list;
    }
}
