package com.application.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
/**
 * get 有参，将参数放入键值对类中，再放入url中，从而通过url得到httpGet实例
 * @author lihe
 *
 */
public class Get_WithParam2 {
	@Test
	public void doGetTestTwo(){
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		URI uri = null;
		try {
			List<NameValuePair> params = new ArrayList<>();
			params.add(new BasicNameValuePair("name", "&"));
			params.add(new BasicNameValuePair("age", "18"));
			uri = new URIBuilder().setScheme("http").setHost("localhost").setPort(12345)
						.setPath("/doGetControllerTwo").setParameters(params).build();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		HttpGet httpget = new HttpGet(uri);
		CloseableHttpResponse response = null;
		
		try {
			RequestConfig requsetConfig = RequestConfig.custom().setConnectTimeout(5000)
										.setConnectionRequestTimeout(5000)
										.setSocketTimeout(5000)
										.setRedirectsEnabled(true).build();
			httpget.setConfig(requsetConfig);
			response = httpclient.execute(httpget);
			
			HttpEntity responseEntity = response.getEntity();
			System.out.println("响应状态为： " + response.getStatusLine());
			if(responseEntity != null){
				System.out.println("响应内容长度为：" + responseEntity.getContentLength());
				System.out.println("响应内容为" + EntityUtils.toString(responseEntity));
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
