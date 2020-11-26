package com.exercise.file;

public class Digui {
    public static void main(String[] args) {
//        a();

        int n = jie(5);
        System.out.println(n);
    }

/*    private static void a() {
        System.out.println("a方法");
        a();
    }*/

    public static int sum(int n){
        if (n == 1){
            return 1;
        }
        return n + sum(n-1);
    }

    public static int jie(int n){
        if(n == 1){
            return 1;
        }
        return n* jie(n-1);
    }
}
