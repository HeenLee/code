package com.lihe.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
/**
 * get有参（方式一：直接拼接URL）手动在url后面加上参数
 * @author lihe
 *
 */
public class Get_WithParam1 {
	@Test
	public void doGetTestOne(){
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		StringBuffer params = new StringBuffer();
		try {
			params.append("name=" + URLEncoder.encode("&","utf-8"));
			params.append("&");
			params.append("age=24");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		HttpGet httpget = new HttpGet("http://localhost:12345/doGetControllerTwo" + "?" + "params");
		CloseableHttpResponse response = null;
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(5000)
									 .setSocketTimeout(5000).setRedirectsEnabled(true).build();
		httpget.setConfig(requestConfig);
		try {
			response = httpclient.execute(httpget);
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
				if(httpclient != null){
					httpclient.close();
				} 
				if (response != null) {
					response.close();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
