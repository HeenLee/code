package com.bp.testcase;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.EntityBuilder;
import org.junit.Test;

import com.base.HttpClientUtils;

public class TestRequest {
	@Test
	public void testPost(){
		Map<String, String> param = new HashMap<String, String>();
		param.put("name", "sino");
		param.put("pwd", "123");
		
		Map<String, String> header = new HashMap<String, String>();
		header.put("content-type", "application/json");
		
		EntityBuilder entity =  EntityBuilder.create();
		entity.setText("hahah");
		HttpEntity entity1 = entity.build();
		String result = HttpClientUtils.doPostRequest("https://www.baidu.com", header, param, entity1);
		System.out.println(result);
	}
	
	@Test
	public void testPostFile() throws IOException{
		Map<String, String> param = new HashMap<String, String>();
		param.put("name", "sino");
		param.put("pwd", "123");
//		File file = File.createTempFile("abc", ".txt");
		File file = new File("/conf/a.txt");
		
		String result = HttpClientUtils.doPostFile("http://httpbin.org", param, file);
		System.out.println(result);
	}
	
	@Test
	public void testGet(){
		Map<String, String> param = new HashMap<String, String>();
		param.put("name", "sino");
		param.put("pwd", "123");
		
		Map<String, String> header = new HashMap<String, String>();
		header.put("content-type", "application/json");
		
		String result = HttpClientUtils.doGetRequest("https://www.baidu.com", header, param);
		System.out.println(result);
		
	}

}
