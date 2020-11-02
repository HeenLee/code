package com.li.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonArrayBase {
	public static void main(String[] args) {
		//json对象
		JSONObject js = new JSONObject();
		String[] major = {"lifa","wajueji"};
		js.put("name", "xiaoer");
		js.put("age", 25);
		js.put("birthday", "1990-01-01");
		js.put("school", "lanxiang");
		js.put("major",major);
		js.put("has_girlfriend", false);
		js.put("car", false);
		js.put("house", false);
		System.out.println(js.toString());
		
		//json对象
		JSONObject js1 = new JSONObject();
		js1.put("gf1", "xiao");
		js1.put("gf2", "da");
		
		//json数组，遍历json数组
		JSONArray  ja = new JSONArray();
		ja.add(js);//将上面的两个json对象存入数组中
		ja.add(js1);
		for (Object obj : ja) {
			System.out.println(obj);
		}
		System.out.println(ja);
	}

}
