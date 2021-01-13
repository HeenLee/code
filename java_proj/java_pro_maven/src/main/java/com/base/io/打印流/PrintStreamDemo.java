package com.base.io.打印流;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream("d:/print.txt");
        ps.print("你好");
        ps.println();
        ps.write(97);
        ps.close();

        System.out.println("我是在控制台输出");
        PrintStream ps1 = new PrintStream("d:/dest.txt");
        //调用方法改变控制台的输出
        System.setOut(ps1);
        System.out.println("我在打印流的目的地输出");

        ps1.close();

    }
}
