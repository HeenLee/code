package com.study;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TestJson {

	public static void main(String[] args) {
		String s = "{\"name\":\"xiaoming\"}";
		System.out.println(s);
		JSONObject json = JSON.parseObject(s);
		System.out.println(json.toString());
		System.out.println(json.getString("name"));
	}

}
