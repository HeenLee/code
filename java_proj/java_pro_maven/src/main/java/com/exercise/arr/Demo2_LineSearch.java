package com.exercise.arr;

public class Demo2_LineSearch {

	public static void main(String[] args) {
		int[] arr = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
		int target = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == target){
				System.out.println(i);
				break;
			}
		}
	}
}
