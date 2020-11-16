package com.exercise.neibulei;

public class Demo02Hero1 {
    private String name;
    private Demo02Skill skill;   //接口作为成员变量类型


    public Demo02Hero1() {
    }

    public Demo02Hero1(String name, Demo02Skill skill) {
        this.name = name;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Demo02Skill getSkill() {
        return skill;
    }

    public void setSkill(Demo02Skill skill) {
        this.skill = skill;
    }

    public void attack(){
        System.out.println(this.name + "施放技能");
        this.skill.use();
        System.out.println("施放完毕");
    }
}
