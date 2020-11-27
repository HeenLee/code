package com.base.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * set不能更改，只有添加 删除和查
 */
import org.junit.Test;

public class Demo2_Set {
	@Test
	public void test_method(){
		Set<String> set = new HashSet<String>();
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("4");
		
		set.remove("2");//删除元素，没有索引
		System.out.println(set);
		
		for (String str : set) {
			System.out.println(str);
		}
		
		System.out.println("---------------------");
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		System.out.println("*******************");
		
		String[] ss = set.toArray(new String[1]);
		for (int i = 0; i < ss.length; i++) {
			System.out.println(ss[i]);
		}
	}
	
	

}
