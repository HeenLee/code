package com.base.类;

public abstract class Demo00User {
    private String name;
    private int  balance; //余额当前用户拥有的钱

    public Demo00User() {
    }

    public Demo00User(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public void show(){
        System.out.println("我叫：" + this.name + ",我的余额是：" + this.balance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
