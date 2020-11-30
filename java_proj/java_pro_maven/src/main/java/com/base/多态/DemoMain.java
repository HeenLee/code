package com.base.多态;

public class DemoMain {
    public static void main(String[] args) {
        Computer c = new Computer();
        c.powerOn();

        //准备一个鼠标，供电脑使用.向上转型。
        USB usbMouse = new Mouse();
        USB usbKeyboard = new Keyboard();

        //传递子类对象或者实现类
        c.usrDevice(usbMouse);
        c.usrDevice(usbKeyboard);

        c.powerOff();

    }
}
