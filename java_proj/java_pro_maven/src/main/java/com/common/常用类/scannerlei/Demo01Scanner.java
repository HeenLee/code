package com.common.常用类.scannerlei;

import java.util.Scanner;

/**
 *
 */
public class Demo01Scanner {
    public static void main(String[] args) {
        //System.in表示从键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String content = sc.nextLine();
        System.out.println(content);

        int max = getMax();
        System.out.println(max);
    }

    private static int  getMax() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数：");
        int a = sc.nextInt();
        System.out.println("请输入第二个数：");
        int b = sc.nextInt();
        System.out.println("请输入第三个数：");
        int c = sc.nextInt();
/*        int max = 0;
        if(a > b){
            max = a;
        }else{
            max = b;
        }

        if(c > max){
            max = c;
            return max;
        }else{
            return max;
        }*/

        int temp = a > b ? a : b;
        int max = temp > c ? temp : c;
        return max;

    }


}
