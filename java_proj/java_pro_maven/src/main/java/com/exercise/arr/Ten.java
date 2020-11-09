package com.exercise.arr;

public class Ten {
  public static void main(String[] args) {
	ss(7);
}
  public static void ss(int n){
		int[][] arr = new int[n][];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new int[i+1];
		}
		
		for(int i =0;i<arr.length;i++){
			for(int j = 0;j<arr[i].length ; j++){
				arr[i][0] = arr[i][i] = 1;
				if(i>1 && j<i && j>0){
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
			}
		}
		   for(int i = 0; i < arr.length; i ++)
			        {
			          for(int j = 0; j < (n - i - 1) / 2; j ++)
			            System.out.print("\t");
			          for(int j = 0; j < arr[i].length; j ++)
			            System.out.print(arr[i][j] + "\t");
			   
			          System.out.println();
			        }
	}
}
