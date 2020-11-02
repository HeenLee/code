package com.li.arr;
/**
 * 冒泡排序:相邻两个元素之间比较
 * @author lihe
 *
 */
public class Demo3_BuddleSort {

	public static void main(String[] args) {
		int arr[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
		bubbleSort(arr);

	}
	
	public static void bubbleSort(int[] arr){
		for (int i = 0; i < arr.length - 1; i++) {  //1     1  
			for (int j = 0; j < arr.length - 1 - i; j++) {    //8  
				if(arr[j] > arr[j+1]){
					int tmp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=tmp;
				}
			}
		}
		for (int i : arr) {
			System.out.print(i+" ");
		}
		
	}

}
