package com.exercise.arr;

import org.junit.Test;

public class ForForExercise {
@Test
/**
 * 1.打印4层***
*****
*****
*****
*****
 */
public void test1(){
	for(int i = 0; i < 4;i++){
		for (int j = 0; j < 5; j++) {
			System.out.print("*");
		}
		System.out.println();
	}
}

/**
 * 2.打印5层*，每层递减
*****
****
***
**
*
 */
@Test
public void test2(){
	for(int i = 0; i < 5;i++){
		for (int j = 0; j < 5 - i; j++) {
			System.out.print("*");
		}
		System.out.println();
	}
}

/**
 * 2.打印5层*，每层递曾
*
**
***
****
*****
 */
@Test
public void test3(){
	for(int i = 0; i < 5; i++) {
		for(int j = 0; j < i+1; j++) {
			System.out.print("*");
		}
		System.out.println();
	}
}

/**
 * 打印54321，每层递减
 * 
54321
5432
543
54
5
 */
@Test
public void test4(){
	for (int i = 0; i < 5; i++) {
		for (int j = 5-i; j >0; j++) {
			System.out.print(j);
		}
		System.out.println();
		
	}
}

/**
 * 4.打印12345，每层递增
1
22
333
4444
55555
 */
@Test
public void test5(){
	for (int i = 1; i <=5; i++) {
		for (int j = 1 ; j <= i; j++) {
			System.out.print(i);
		}
		System.out.println();
		
	}
}

/**5.九九乘法表

1×1=1   
1×2=2   2×2=4   
1×3=3   2×3=6   3×3=9   
1×4=4   2×4=8   3×4=12  4×4=16  
1×5=5   2×5=10  3×5=15  4×5=20  5×5=25  
1×6=6   2×6=12  3×6=18  4×6=24  5×6=30  6×6=36  
1×7=7   2×7=14  3×7=21  4×7=28  5×7=35  6×7=42  7×7=49  
1×8=8   2×8=16  3×8=24  4×8=32  5×8=40  6×8=48  7×8=56  8×8=64  
1×9=9   2×9=18  3×9=27  4×9=36  5×9=45  6×9=54  7×9=63  8×9=72  9×9=81
*/

@Test
public void test6(){
	for (int i = 1; i <= 9; i++) {
		for (int j = 1; j <=i; j++) {
			System.out.print(j + "*" +i +"="+ (i*j)+"\t");
		}
		System.out.println();
		
	}
}

/**
 * 6.打印倒三角形

      *******     先打印空格，再打印*  最后打印换行
       ***** 
        *** 
         * 
 */
@Test
public void test7(){
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j <i; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < 2*(4-i) -1; j++) {
			System.out.print("*");
		}
		System.out.println();
	}
	}
	/**
	 * 倒三角形方法   
	 * @param n
	 */
    public static void sta(int n)
    {
    	for (int i = 0; i<n; i++ )
    	{
    		for (int j = 0; j<i; j++)
    		{
    			System.out.print(" ");
    		}
    		for (int k = 0; k<2*(n-i)-1; k++)
    		{
    			System.out.print("*");
    		}
    		System.out.println();
    	    
    	}
    }
/**
 * 正三角形 
 */
    @Test
    public void test8(){
    	for (int i = 0; i<4; i++ )
    	{
    		for (int k = 0; k<3-i; k++)
    		{
    			System.out.print(" ");
    		}
    		for (int j = 0; j< 2*i + 1; j++)
    		{
    			System.out.print("*");
    		}

    		System.out.println();
    	    
    	}
    }
    /**
     * 正三角形m行
     * @param m
     */
    public static void showSanJao(int m){ 
    	for(int i=1;i<=m;i++){ 
	    	for(int j=1;j<=m-i+1;j++){ 
	    		System.out.print(" "); 
	    	} 
	    	for(int z=1;z<=2*i-1;z++){ 
	    		System.out.print("*"); 
	    	} 
	    	System.out.println(); 
    	} 
    }
    @Test
    public void test9(){
    	showSanJao(9);
    }
}
