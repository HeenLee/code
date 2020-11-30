package com.base.集合;

import java.util.Comparator;

public class Book_MyComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		Book b1 = (Book) o1;
		Book b2 = (Book) o2;
		if(b1.getPrice() > b2.getPrice()){
			return 1;
		}
		if(b1.getPrice() < b2.getPrice()){
			return -1;
		}
		return b1.getName().compareTo(b2.getName());
	}

}
