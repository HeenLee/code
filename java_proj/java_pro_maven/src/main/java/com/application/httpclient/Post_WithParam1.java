package com.application.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

/**
 * post有参（普通参数）  创建get/post的请求参数   然后execute执行请求，收到response，然后把responseEntity具体内容拿到。
 * 参数可以构造在url中，也可以放在entity中。 对象参数的话先转为json,放在entity中
 * @author lihe
 *
 */
public class Post_WithParam1 {
	@Test
	public void doPostTest(){
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		
		StringBuffer params = new StringBuffer();
		try {
			params.append("name=" + URLEncoder.encode("&","utf-8"));
			params.append("&");
			params.append("age=24");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		HttpPost httppost = new HttpPost("http://localhost:12345/doPostContraollerFour" + "?" + params);
		httppost.setHeader("Content-Type", "application/json;charset=utf-8");
		CloseableHttpResponse response = null;
		
		try {
			response = httpclient.execute(httppost);
			HttpEntity responseEntity = response.getEntity();
			System.out.println("响应状态为:" + response.getStatusLine());
			if(responseEntity != null){
				System.out.println("响应内容长度为:" + responseEntity.getContentLength());
				System.out.println("响应内容为：" + EntityUtils.toString(responseEntity));
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			
				try {
					if(httpclient != null){
						httpclient.close();
					} 
					if(response != null){
						response.close();
					}
				}catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
