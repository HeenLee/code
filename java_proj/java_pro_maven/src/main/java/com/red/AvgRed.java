package com.red;

import java.util.ArrayList;

public class AvgRed  implements OpenMode{
    @Override
    public ArrayList<Integer> divide(int totalMoney, int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();

        int avg = totalMoney / totalCount;
        int mod = totalMoney % totalCount;
        for (int i = 0; i < totalCount - 1; i++) {   //最后一个红包先留着
            list.add(avg);
        }
        list.add(avg + mod);

        return null;
    }
}
