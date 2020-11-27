package com.base.collection.set;

import com.base.collection.Student;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 元素要存储到HashSet中，必须覆盖hashCode方法和equals方法.hashSet无序，去重。
 * 自定义对象比如Student类需要重写hashCode和equals方法
 * @author lihe
 *
 */
public class Demo3_HashSet {

	public static void main(String[] args) {
		Set<Student> set = new HashSet<Student>();
		set.add(new Student("jack",20));
		set.add(new Student("rose",20));
		set.add(new Student("jhmm",20));
		set.add(new Student("lilei",20));
		set.add(new Student("jack",20));
		System.out.println(set);
		Iterator<Student> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}

}
