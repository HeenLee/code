package com.base.数组;


import org.junit.Test;

/**
 * java一维数组
 *
 * @author lihe
 */
public class Demo01ArrayOne {
    /**
     * 遍历一维数组
     */
    public void testOne() {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        String[] arr2 = {"shanghai", "beijign", "shenzhen", "guangzhou"};
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
        System.out.println(arr2[0]);//打印元素时没有引号了
    }

    @Test
/**
 * 一维数组元素求和
 */
    public void testOneSum() {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }

    /**
     * 冒泡排序
     *
     * @param arr 相邻元素比较
     * @return
     */
    private int[] buddle(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;

    }
}
