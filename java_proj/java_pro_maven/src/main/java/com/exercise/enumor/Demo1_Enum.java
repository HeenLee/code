package com.exercise.enumor;

public class Demo1_Enum {

	public static void main(String[] args) {
		//1.
		Week mon = Week.MON;
		System.out.println(mon);
		
		//2.
		Week2 mon1 = Week2.MON;
		System.out.println(mon1.getName());
		
		//3.
		Week3 mon2 = Week3.MON;
		mon2.show();
	}

}
