package com.base.数组;

import org.junit.Test;

/**
 * java二维数组
 * @author lihe
 *
 */
public class Demo02ArrayTwo {
@Test
/**
 * 遍历二维数组
 */
public void testTwo(){
	int[][] arr = {{1,2,3},{4,5,6}};
	for (int i = 0; i < arr.length; i++) {
		for (int j = 0; j < arr[i].length; j++) {
			System.out.println(arr[i][j]);
		}
	}
}

@Test
/**
 * 二维数组元素求和
 */
public void testOneSum(){
	int[][] arr = {{1,2,3},{4,5,6}};
	int sum = 0;
	for (int i = 0; i < arr.length; i++) {
		for (int j = 0; j < arr[i].length; j++) {
			sum+= arr[i][j];
		}
	}
	
	System.out.println(sum);
}
/**
 * 杨辉三角
 */
@Test
public void testSanjiao(){

} 

}
