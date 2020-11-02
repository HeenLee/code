package com.study;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSimpleDateFormat {

	public static void main(String[] args) throws ParseException {
		
		//1.将日期格式转换为字符串形式 format()
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1 = new Date();
		String day = sdf.format(date1);
		System.out.println(day);
		//2.将字符串格式转为日期格式  parse()  字符串指定格式与sdf给定的格式要一致
		String str = "2018-12-31 23:56:12";
		Date date2 = sdf.parse(str);
		System.out.println(date2);
	}

}
