package com.base.arr;
/**
 * 如何从数组中查找公共的元素
 * 检查两个数组相等用Arrays.equls()
 */
import java.util.ArrayList;
import java.util.List;

public class Demo04RetainAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		
		list1.add("common1");
		list1.add("common2");
		list1.add("not common");
		list1.add("not common1");
		list2.add("common1");
		list2.add("common2");
		list2.add("not common2");
		//list1.retainAll(list2);   //取交集retainAll()
		System.out.println(list1);
		System.out.println(list1.contains("common1"));
		
		//通过遍历数组比较相同的元素
		int[] arr1 = { 14, 17, 13, 19, 12 };
	    int[] arr2 = { 13, 12, 112, 19, 400, 32, 14 };
	    for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if(arr1[i] == arr2[j]){
					System.out.println(arr1[i]);
				}
			}
		}
	    
	}
}
