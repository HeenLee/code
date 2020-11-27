package com.base.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Demo2_Calendar {

	public static void main(String[] args) {
	     Date d1 = new Date();
         Calendar cal = Calendar.getInstance();
         cal.setTime(d1);

         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
         String dt = sdf.format(cal.getTime());
         
         System.out.println(cal.get(Calendar.DAY_OF_MONTH));
         System.out.println(cal.get(Calendar.DAY_OF_WEEK));
         System.out.println(cal.get(Calendar.WEEK_OF_MONTH));
         System.out.println(cal.get(Calendar.MONTH));
         System.out.println(dt);
         
         
         
         

	}

}
