package com.base.时间日期;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Demo2_Calendar {

	public static void main(String[] args) {
//	     Date d1 = new Date();
         Calendar cal = Calendar.getInstance();
//         cal.setTime(d1);

         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
         String dt = sdf.format(cal.getTime());
        cal.add(Calendar.DAY_OF_MONTH,2);
        System.out.println(cal.getTime());
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH));
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
        System.out.println(cal.get(Calendar.HOUR));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));

        System.out.println("==================");



         System.out.println(cal.get(Calendar.DAY_OF_MONTH));
         System.out.println(cal.get(Calendar.DAY_OF_WEEK));
         System.out.println(cal.get(Calendar.WEEK_OF_MONTH));
         System.out.println(cal.get(Calendar.MONTH));
         System.out.println(dt);
         
         
         
         

	}

}
