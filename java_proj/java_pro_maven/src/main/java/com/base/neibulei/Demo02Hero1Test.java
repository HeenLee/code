package com.base.neibulei;

public class Demo02Hero1Test {
    public static void main(String[] args) {
        //创建一个英雄
        Demo02Hero1 hero = new Demo02Hero1();
        hero.setName("John");

        //创建一个技能对象
        Demo02Skill skill = new Demo02Skill(){
            @Override
            public void use() {
                System.out.println("biubiu");
            }
        };
        hero.setSkill(skill);

        hero.attack();



    }
}
