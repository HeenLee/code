package com.study;

import java.util.Calendar;
import java.util.Date;
/**
 * 特殊的：AM_PM 返回1则表示是下午，返回0表示上午
 * 月份是从0-11
 * 
 * calendar  
 * set()   
 * setTime(Date date)  
 * Date getTime()
 * long getTimeInMillies()
 * @author lihe
 *
 */
public class TestCalendar {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		//获取字段
		int year = cal.get(Calendar.YEAR);  //2020
		int month = cal.get(Calendar.MONTH);//2
		int date = cal.get(Calendar.DATE);//2
		int hour = cal.get(Calendar.HOUR);//12小时制    1
		int hour1 = cal.get(Calendar.HOUR_OF_DAY);//24小时制       13
		int minute = cal.get(Calendar.MINUTE);    //54
		int second = cal.get(Calendar.SECOND);    //28
		int millsecond = cal.get(Calendar.MILLISECOND); //289
		int day_of_month = cal.get(Calendar.DAY_OF_MONTH); //2
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK); //2
		int day_of_week_in_month = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);//1
		int week_of_month = cal.get(Calendar.DAY_OF_WEEK);  //2
		int day_of_year = cal.get(Calendar.DAY_OF_YEAR);   // 62
		int week_of_year = cal.get(Calendar.WEEK_OF_YEAR);//10
		//获取上午下午   0
		int moa = cal.get(Calendar.AM_PM);
		System.out.println(hour);
		System.out.println(hour1);
		System.out.println(moa);
		if(moa == 1){
			System.out.println("下午");
		}else{
			System.out.println("上午");
		}
		System.out.println(year + "年" + (month + 1) + "月" + date + "日" + hour + "时");
		
		//设置日期
		cal.set(2021, 3, 4);//设置指定日期
		cal.setTime(new Date()); //设置实时日期
		System.out.println("-----" +cal.get(Calendar.YEAR));
		
		Date date1 = cal.getTime();
		System.out.println(date1);
		
		cal.add(Calendar.YEAR, 5);
		cal.add(Calendar.DATE, -1);
		System.out.println(cal.get(Calendar.YEAR) + "年" + (month + 1) + "月" + date1 + "日" + hour + "时");
		System.out.println(cal.getTimeInMillis());
	}

}
