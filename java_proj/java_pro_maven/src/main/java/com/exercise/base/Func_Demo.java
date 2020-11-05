package com.exercise.base;

public class Func_Demo {
    public static void main(String[] args) {
        System.out.println(isEqusl(3,2));
        int sum = getSum(100);
        System.out.println(sum);
    }

    public static boolean isEqusl(int a, int b) {
        return a == b;
    }
    public static int getSum(int n){
        int i = 1;
        int sum = 0;
        while(i < n + 1){
            sum += i;
            i++;
        }
        return sum;

    }
}
