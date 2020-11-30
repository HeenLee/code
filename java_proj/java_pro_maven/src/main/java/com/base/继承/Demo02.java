package com.base.继承;

public class Demo02 {
    public static void main(String[] args) {
        //父类引用指向子类对象
        Demo02Animal animal = new Demo02Cat();
        animal.eat();

        //判断是否为Cat
        if(animal instanceof Demo02Cat){
            Demo02Cat cat = (Demo02Cat) animal;
            cat.catchMouse();
        }

        //判断是否为Dog
        if(animal instanceof Demo02Dog){
            Demo02Dog dog = (Demo02Dog) animal;
            dog.watchDoor();
        }


    }



    public static void giveAnimal(Demo02Animal animal){
        if(animal instanceof Demo02Cat){
            Demo02Cat cat = (Demo02Cat) animal;
            cat.catchMouse();
        }
        //判断是否为Dog
        if(animal instanceof Demo02Cat){
            Demo02Dog dog = (Demo02Dog) animal;
            dog.watchDoor();
        }
    }
}
