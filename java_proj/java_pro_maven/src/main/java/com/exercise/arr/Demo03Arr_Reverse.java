package com.exercise.arr;
/**
 * 数组元素反转
 * 原来：[1,2,3,4]
 * 之后：[4,3,2,1]
 * 要求不能使用新数组，就用原来的唯一一个数组
 * 思路：元素位置交换
 */

public class Demo03Arr_Reverse {

	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		//循环遍历数组原来的样子
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		System.out.println("============");

		/*
		初始化语句：int min = 0, max = arr.length - 1
		条件判断 min < max
		步进表达式  min++   max--
		循环体  用第三个变量倒手
		 */

		for(int min = 0, max = arr.length -1; min < max; min++, max--){
			int temp = arr[min];
			arr[min] = arr[max];
			arr[max] = temp;
		}
		//再次遍历打印数组
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}
}


