package com.base.内部类;

public class Demo01HeroTest {
    public static void main(String[] args) {
        //创建一个英雄
        Demo01Hero hero = new Demo01Hero();
        hero.setAge(20);
        hero.setName("John");

        //创建一个武器对象
        Demo01Weapon weapon = new Demo01Weapon("尚方宝剑");

        hero.setWeapon(weapon);
        hero.attack();


    }
}
