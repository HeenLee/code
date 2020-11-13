package com.exercise.iherite;

public class Demo02Dog extends Demo02Animal{
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }

    public void watchDoor(){
        System.out.println("看门");
    }
}
