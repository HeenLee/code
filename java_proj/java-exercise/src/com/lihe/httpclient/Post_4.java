package com.lihe.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class Post_4 {
	@Test
	public void test1() throws ParseException, IOException{
		List<NameValuePair> formparams = new ArrayList<>();
		formparams.add(new BasicNameValuePair("account", "hahaha"));
		formparams.add(new BasicNameValuePair("password", "111111"));
		try {
			//编码参数，将参数格式为value1=""&value2=""&value3=""
			HttpEntity requestEntity = new UrlEncodedFormEntity(formparams,"utf-8");
			
			RequestConfig requestconfig = RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(5000)
							.setSocketTimeout(5000).build();
			
			System.out.println(requestEntity);
			
			HttpClient httpclient = HttpClients.createDefault();
			System.out.println(EntityUtils.toString(requestEntity));
			
			HttpPost httppost = new HttpPost("http://cnivi.com.cn/login");
			httppost.setEntity(requestEntity);
			httppost.setConfig(requestconfig);
			
			HttpResponse response = httpclient.execute(httppost);
			
			if(response.getStatusLine().getStatusCode() == 200){
				HttpEntity responseEntity = response.getEntity();
				String message = EntityUtils.toString(responseEntity,"utf-8");
				System.out.println(message);
			}
			else{
				System.out.println("请求失败");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
