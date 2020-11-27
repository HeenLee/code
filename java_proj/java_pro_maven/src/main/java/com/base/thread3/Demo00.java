package com.base.thread3;

public class Demo00 {
    public static void main(String[] args) {
        Baozi bz = new Baozi();

        new Baozipu(bz).start();
        new Chihuo(bz).start();
    }
}
