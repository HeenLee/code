package com.exercise.neibulei;

public class Demo01Hero {
    private String name;
    private Demo01Weapon weapon;   //类作为成员变量类型
    private int age;

    public Demo01Hero() {
    }

    public Demo01Hero(String name, Demo01Weapon weapon, int age) {
        this.name = name;
        this.weapon = weapon;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Demo01Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Demo01Weapon weapon) {
        this.weapon = weapon;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void attack(){
        System.out.println("年龄为：" + this.age + "的" + this.name + "有" + this.weapon.getCode() + "武器");
    }
}
