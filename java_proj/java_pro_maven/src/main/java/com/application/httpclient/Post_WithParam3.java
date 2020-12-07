package com.application.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * post有参(普通参数 + 对象参数)。url中带有key=value&key=value的参数。 实体也带有entity
 * @author lihe
 *
 */
public class Post_WithParam3 {
	@Test
	public void doPostTest(){

		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		
		URI url = null;
		try {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("name", "4"));
			params.add(new BasicNameValuePair("age", "sino"));
		
			url = new URIBuilder().setScheme("http").setHost("localhost")
					.setPort(12345).setPath("doPostControllerThree").setParameters(params).build();
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		HttpPost httppost = new HttpPost(url);
		System.out.println(url);
		
		User user = new User();
		user.setName("xiaosan");
		user.setAge(18);
		user.setGender("女");
		user.setMotto("indepent");
		
		StringEntity entity = new StringEntity(JSON.toJSONString(user),"utf-8");
		httppost.setEntity(entity);
		httppost.setHeader("Content-Type", "application/json;charset=utf8");
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httppost);
			HttpEntity responseEntity = response.getEntity();
			System.out.println("响应状态为："+ response.getStatusLine());
			if (responseEntity != null) {
				System.out.println("响应内容长度为:" + responseEntity.getContentLength());
				System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
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
