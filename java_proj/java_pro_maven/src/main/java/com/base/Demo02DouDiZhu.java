package com.base;

import java.util.*;

/**
 * 发完牌后进行排序。通过索引来排序，发牌
 * 0-大王
 * 1- 小王
 * 2
 * 53
 * 1.准备拍
 * 2.洗牌
 * 3.发牌
 * 4.排序
 * 5.看牌
 *
 */
public class Demo02DouDiZhu {
    public static void main(String[] args) {
        //1 .准备牌
        // 存储索引和牌
        Map<Integer, String> poker = new HashMap<>();
        //存储索引
        List<Integer> list = new ArrayList<>();

        // 牌的花色
        List<String> colors = new ArrayList<>();
        colors.add("红桃");
        colors.add("黑桃");
        colors.add("梅花");
        colors.add("方块");

        // 牌的数组
        List<String> numbers = new ArrayList<>();
        numbers.add("2");
        numbers.add("3");
        numbers.add("4");
        numbers.add("5");
        numbers.add("6");
        numbers.add("7");
        numbers.add("8");
        numbers.add("9");
        numbers.add("10");
        numbers.add("J");
        numbers.add("Q");
        numbers.add("K");
        numbers.add("A");

        //把大王和小王存储在集合中
        int index = 0;  //牌的索引
        poker.put(index, "大王");
        list.add(index);
        index++;
        poker.put(index, "小王");
        list.add(index);
        index++;
        //循环嵌套遍历两个集合，组装52张牌存储到集合中
        for (String number : numbers) {
            for (String color : colors) {
                poker.put(index, color + number);
                list.add(index);
                index++;
            }
        }

        System.out.println(poker);
        System.out.println(list);

        //2. 洗牌
        //使用Collections的shuffle(list)方法
        Collections.shuffle(list);
        System.out.println(list);

        //3. 发牌
        //定义4个集合，存储玩家牌的索引和底牌的索引
        List<Integer> playerA = new ArrayList<>();
        List<Integer> playerB = new ArrayList<>();
        List<Integer> playerC = new ArrayList<>();
        List<Integer> dipai = new ArrayList<>();

        //遍历存储索引的list集合，获取每一个牌的索引
        for (int i = 0; i < list.size(); i++) {
            Integer in  = list.get(i);
            //先判断底牌
            if(i >= 51){
                dipai.add(in);
            }else if(i % 3 == 0){
                playerA.add(in);
            }else if(i % 3 == 1){
                playerB.add(in);
            }else if(i % 3 == 2){
                playerC.add(in);
            }
        }

        //4. 排序
        //使用Collections的sort进行排序
        Collections.sort(playerA);
        Collections.sort(playerB);
        Collections.sort(playerC);
        Collections.sort(dipai);

        //5. 看牌
        lookpoker("刘", poker, playerA);
        lookpoker("王", poker, playerB);
        lookpoker("张", poker, playerC);
        lookpoker("底牌", poker, dipai);


    }

    /**
     * 看牌的方法
     * 参数：
     *  String name 玩家的名称
     *  HashMap<Integer,String> poker 存储牌的poker集合
     *  ArrayList<Integer> list 存储玩家和底牌的list集合
     * 查表发:
     *  遍历玩家或者底牌集合，获取牌的索引
     *  使用牌的索引，去map集合中找到对应的牌
     */
    public static void lookpoker(String name, Map<Integer,String> poker, List<Integer> list){
        //输出玩家的名称
        System.out.print(name + ":");
        //遍历玩家或者底牌集合，获取索引
        for (Integer key : list) {
            //使用牌的索引，去map集合中，找到对应的牌
            String value = poker.get(key);
            System.out.print(value + " ");
        }
        System.out.println();  //打印完每个玩家的牌换行
    }
}
