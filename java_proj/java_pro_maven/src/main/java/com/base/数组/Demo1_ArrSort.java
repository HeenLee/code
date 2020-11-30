package com.base.数组;

import java.util.Arrays;
/**
 * 排序和二分查找
 * @author lihe
 *
 */
public class Demo1_ArrSort {

	public static void main(String[] args) {
		int[] arr = {2,3,1,5,4,7,8,6};
		printArray("sort", arr);
		Arrays.sort(arr); //排序
		System.out.println();
		for (int i : arr) {
			System.out.print(i + " ");
		}
		
		int index = Arrays.binarySearch(arr, 2);//二分查找
		System.out.println("\t" + index);

	}
	private static void printArray(String mes, int[] arr){
		System.out.println(mes);
		for (int i = 0; i < arr.length; i++) {
			if(i != 0){
				System.out.print(", ");
			}
			System.out.print(arr[i]);
		}
	}

}
