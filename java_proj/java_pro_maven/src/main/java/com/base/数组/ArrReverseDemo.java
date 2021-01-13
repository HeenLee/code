package com.base.数组;

/**
 * 元素反转
 * 不创建新的数组，在原数组的基础上反转元素
 *  原始[1,2,3,4]
 *  反转后[4,3,2,1]
 */
public class ArrReverseDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("-----------------");

        for (int min = 0, max = arr.length - 1; min < max; min++, max-- ){
            if(min < max){
                int temp = arr[min];
                arr[min] = arr[max];
                arr[max] = temp;
            }
        }

        for (int i : arr) {
            System.out.println(i);

        }

    }
}
