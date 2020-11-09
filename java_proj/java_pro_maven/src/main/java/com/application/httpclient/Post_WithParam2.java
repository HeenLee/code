package com.application.httpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * POST---有参测试(对象参数)
 * @author lihe
 *
 */
public class Post_WithParam2 {
	@Test
	public void doPostTest(){
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		HttpPost httppost = new HttpPost("http://localhost:12345/doPostController");
		User user = new User();
		user.setName("xiaomi");
		user.setAge(18);
		user.setGender("女");
		user.setMotto("indepent");
		String jsonString = JSON.toJSONString(user);
		StringEntity entity = new StringEntity(jsonString,"utf-8");
		httppost.setEntity(entity);
		httppost.setHeader("Content-Type", "application/json;charset=utf8");
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httppost);
			
			HttpEntity responseEntity = response.getEntity();
			System.out.println("响应状态为:" + response.getStatusLine());
			if(responseEntity != null){
				System.out.println("响应内容长度为:" + responseEntity.getContentLength());
				System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
			}
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				// 释放资源
				if (httpclient != null) {
					httpclient.close();
				}
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		}
}
