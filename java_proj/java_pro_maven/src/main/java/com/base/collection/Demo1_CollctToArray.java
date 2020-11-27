package com.base.collection;

import java.util.ArrayList;
import java.util.List;

public class Demo1_CollctToArray {

	public static void main(String[] args) {
	       List<String> list = new ArrayList<String>();
	        list.add("This ");
	        list.add("is ");
	        list.add("a ");
	        list.add("IT ");
	        list.add("tutorials ");
	        list.add("website. ");
	        Object[] s1 = list.toArray();

	        for (int i = 0; i < s1.length; ++i) {
	            String contents = (String) s1[i];
	            System.out.println(contents);
	        }

		
	}

}
