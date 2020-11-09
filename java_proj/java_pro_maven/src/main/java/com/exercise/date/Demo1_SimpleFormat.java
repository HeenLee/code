package com.exercise.date;
/**
 * 格式化日期
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Demo1_SimpleFormat {

	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		//setTime将Date转换
		cal.setTime(date);
		
		//getTime得到Date类型
		cal.getTime();
		
		System.out.println(date);
		System.out.println(date.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String time = "2019-10-21 12:00:00";
		Date d = sdf.parse(time);
		System.out.println(sdf.format(date));
		System.out.println(d);
	}

}
