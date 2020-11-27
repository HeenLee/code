package com.base.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo08Iterator {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("a");
        coll.add("b");
        coll.add("c");
        coll.add("d");
        coll.add("e");
        Iterator<String> it = coll.iterator();
        while (it.hasNext()){
            String element = it.next();
            if("a".equals(element)){
                it.remove();
            }
            System.out.println(element);
        }

    }
}
