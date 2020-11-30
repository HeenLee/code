package com.base.集合.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class Demo1_List {
	/**
	 * 添加元素add()  addAll()  remove()  set()  get()
	 */
	@Test
	public void test_method(){
		List<String> list = new ArrayList<String>();
		list.add("big");
		list.add("small");
		list.add("width");
		list.add("height");
		System.out.println(list);//[big, small, width, height]
		list.add(0, "fat");
		
		System.out.println(list);//[fat, big, small, width, height]
		
		List<String> list1 = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		list1.add("4");
		list1.add("width");
		list1.add("height");
		
//		list.addAll(list1);
/*		System.out.println(list);//[fat, big, small, width, height, 1, 2, 3, 4]
		//删除
		String 字符串 = list.remove(0);//根据索引删除
		list.remove("2");//根据元素删除
		System.out.println(字符串);
		System.out.println(list);
		
		System.out.println(list.get(0));
		
		list.set(0, "cat");*/
		System.out.println(list);
		list.retainAll(list1);  //取交集
		System.out.println(list);
		
		System.out.println(list1);
	}
	
	/**
	 * 遍历集合 for循环   foreach循环   iterator()
	 */
	@Test
	public void testLoop(){
		List<String> list = new ArrayList<String>();
		list.add("big");
		list.add("small");
		list.add("width");
		list.add("height");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("-------------------");
		for (String str : list) {
			System.out.println(str);
		}
		System.out.println("****************");
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		
	}
}
