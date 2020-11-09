package com.exercise.enumor;

public class Demo2_Enum {

	public static void main(String[] args) {
		Week2[] arr = Week2.values();
		for (Week2 week2 : arr) {
			System.out.println(week2);
		}
		
		Week2 mon = Week2.valueOf(Week2.class, "MON");
		System.out.println(mon);
	}

}
