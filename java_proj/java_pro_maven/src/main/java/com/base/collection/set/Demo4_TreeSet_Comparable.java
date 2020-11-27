package com.base.collection.set;

import com.base.collection.Person;

import java.util.Set;
import java.util.TreeSet;

public class Demo4_TreeSet_Comparable {

	public static void main(String[] args) {
		Set<Person> set = new TreeSet<Person>();
		set.add(new Person("aa",20,"男"));
		set.add(new Person("bb",18,"女"));
		set.add(new Person("cc",17,"男"));
		set.add(new Person("dd",17,"女"));
		set.add(new Person("dd",15,"女"));
		set.add(new Person("dd",15,"女"));
		System.out.println(set);
		System.out.println(set.size());
	}

}
