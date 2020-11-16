package com.exercise.duotai;


import java.security.Key;

public class Computer {
    public void powerOn(){
        System.out.println("笔记本开机");
    }

    public void powerOff(){
        System.out.println("笔记本关机");
    }

    //使用USB设备的方法。实现USB接口的类或者子类可以直接传入参数。但是
    //如果是子类特有的方法，需要向下转型
    public void usrDevice(USB usb){
        usb.open(); //打开设备
        if(usb instanceof Mouse){
            Mouse mouseUsb = (Mouse) usb;
            mouseUsb.click();
        }
        if(usb instanceof Keyboard){
            Keyboard keyboardUsb = (Keyboard) usb;
            keyboardUsb.type();
        }
        usb.close();  //关闭设备
    }
}
