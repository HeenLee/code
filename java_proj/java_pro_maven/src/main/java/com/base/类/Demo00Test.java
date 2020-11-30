package com.base.类;

import java.util.ArrayList;

public class Demo00Test {
    public static void main(String[] args) {
        Demo00Manager manager = new Demo00Manager("群主",100);

        Demo00Member member1 = new Demo00Member("成员1",0);
        Demo00Member member2 = new Demo00Member("成员2",0);
        Demo00Member member3 = new Demo00Member("成员3",0);

        manager.show();
        member1.show();
        member2.show();
        member3.show();

        //发20元，发3个红包
        ArrayList<Integer> list = manager.send(20,3);
        member1.receive(list);
        member2.receive(list);
        member3.receive(list);
        manager.show();
        member1.show();
        member2.show();
        member3.show();

    }

}
