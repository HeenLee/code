package com.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 斗地主联系：
 * 1.有大王 小王  红桃 黑桃 方块 梅花  共计54张牌。 索引0-53
 * 2.三个人玩，还有底牌是4张。  每人平分17张   51 52 53号索引是底牌
 *   轮番发牌时，根据牌的索引分给三个人。
 *   索引是0 分给3个人   0 给 A  1给B  2 给C
 *  3.洗牌                    3
 *  4.发牌
 */
public class Demo01DouDiZhu {
    public static void main(String[] args) {
        //1. 牌的列表
        List<String> poker = new ArrayList<>();
        poker.add("大王");
        poker.add("小王");

        //2. 将花色牌加入到列表
        String[] kinds = {"红桃","黑桃","方块","梅花"};
        String[] numbers = {"2","A","3","4","5","6","7","8","9","10","J","Q","K"};
        for (String kind : kinds) {
            for (String number : numbers) {
                poker.add(kind+number);
            }
        }
        System.out.println(poker + "长度：" + poker.size());
        // 3. 洗牌
        Collections.shuffle(poker);

        //洗完后打印
        System.out.println(poker);

        //4. 定义3个列表是人物，1个列表是底牌
        List<String> playA = new ArrayList<>();
        List<String> playB = new ArrayList<>();
        List<String> playC = new ArrayList<>();
        List<String> dipai = new ArrayList<>();
        //5.发牌 遍历集合，根据索引进行发牌的操作
        for (int i = 0; i < poker.size(); i++) {
            //获取集合中的元素
            String element = poker.get(i);
            if(i >= 51){
                dipai.add(element);
            }else if(i % 3 == 0){
                playA.add(element);
            }else if(i % 3 == 1){
                playB.add(element);
            }else if (i % 3 ==2){
                playC.add(element);
            }
        }
        //6. 看牌
        System.out.println(playA + "大小:" + playA.size());
        System.out.println(playB + "大小:" + playB.size());
        System.out.println(playC + "大小:" + playC.size());
        System.out.println(dipai + "大小:" + dipai.size());
    }
}
