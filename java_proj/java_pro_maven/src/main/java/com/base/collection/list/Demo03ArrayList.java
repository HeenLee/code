package com.base.collection.list;

import java.util.ArrayList;
import java.util.Random;

/**
 * 用一个大集合存入20个随机数字，然后筛选其中的偶数元素，放到小集合中
 */
public class Demo03ArrayList {
    public static void main(String[] args) {
        Random r = new Random(); //创建随机数对象
        ArrayList<Integer> list = new ArrayList<>(); //定义大集合
        for (int i = 0; i < 20; i++) {    //循环20次，添加到大集合中
            list.add(r.nextInt(100) + 1);
        }
        System.out.println(list);

 /*        ArrayList<Integer> smallList = new ArrayList<>(); //定义小集合
       //遍历大集合,筛选偶数，然后添加到小集合.  这个过程可以抽取一个方法
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) % 2 == 0){
                smallList.add(list.get(i));
            }
        }
        System.out.println(smallList);*/

        ArrayList<Integer> smallList = getSmallList(list);
        System.out.println(smallList);
    }


    /**
     * 该方法是通过传入的集合，筛选出偶数，添加到小集合中
     * @return 返回小集合
     */
    public static ArrayList<Integer> getSmallList(ArrayList<Integer> bigList){
        //定义一个小集合
        ArrayList<Integer> smallList = new ArrayList<>();
        for (int i = 0; i < bigList.size(); i++) {
            if(bigList.get(i) % 2 == 0){
                smallList.add(bigList.get(i));
            }
        }
        return smallList;
    }
}
