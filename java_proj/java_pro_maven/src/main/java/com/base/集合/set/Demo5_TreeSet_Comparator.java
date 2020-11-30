package com.base.集合.set;

import com.base.集合.Book;
import com.base.集合.Book_MyComparator;

import java.util.Set;
import java.util.TreeSet;

public class Demo5_TreeSet_Comparator {

	public static void main(String[] args) {
		Set<Book> set = new TreeSet<Book>(new Book_MyComparator());
		set.add(new Book("think in java",100));
		set.add(new Book("java 核心技术",75));
		set.add(new Book("现代操作系统",50));
		set.add(new Book("java就业教程",35));
		set.add(new Book("think in java",100));
		set.add(new Book("ccc in java",100));
		System.out.println(set);
		System.out.println(set.size());
	}

}
