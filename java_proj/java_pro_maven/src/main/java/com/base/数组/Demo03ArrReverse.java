package com.base.数组;
/**
 * 逆转列表元素
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Demo03ArrReverse {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(-1);
		list.add(2);
		list.add(5);
		list.add(4);
		Collections.reverse(list);
		System.out.println(list);
		
		int numbers[] = new int[] {28, 21, 17, 41, 34, 29, 15 };
		int max = numbers[0];
		int min = numbers[0];
		for (int i = 0; i < numbers.length; i++) {
			if(max < numbers[i]){
				max = numbers[i];
			}
			if(min>numbers[i]){
				min = numbers[i];
			}
		}
		System.out.println(max);
		System.out.println(min);
		
        String[] a = { "y", "i", "i" };
        String[] b = { "b", "a", "i" };
        List<String> list1 = new ArrayList<String>(Arrays.asList(a));
        list1.addAll(Arrays.asList(b));
        
        Object[] c = list1.toArray();
        
        System.out.println(Arrays.toString(c));

	}
	

}
