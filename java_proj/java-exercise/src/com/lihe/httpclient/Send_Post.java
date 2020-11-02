package com.lihe.httpclient;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class Send_Post {
	@Test
	public void test() throws ClientProtocolException, IOException{
		String url = "https://yqtblackbox.sinosun.com:18093/yqt/tcm/pages/login";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mgrPhone", "lh1234");
		map.put("mgrPwd", "Lh666666");
		sendPost(url,map);
		sendGet(url,map);
		
	}
	public static String sendPost(String url,Map<String,Object> params) throws ClientProtocolException, IOException{
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse  httpresponse = null;
		httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url);
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000).setConnectionRequestTimeout(35000)
									 .setSocketTimeout(60000).build();
		httppost.setConfig(requestConfig);
		httppost.addHeader("Content-Type", "text/html");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>() ;
		for (Map.Entry<String,Object> paramEntry : params.entrySet()) {
			nvps.add(new BasicNameValuePair(paramEntry.getKey(),paramEntry.getValue().toString()));
		}
		httppost.setEntity(new UrlEncodedFormEntity(nvps,"utf-8"));
		
		 httpresponse =  httpclient.execute(httppost);
		String result = EntityUtils.toString(httpresponse.getEntity());
		return result;
	}
	
	public static String sendGet(String url,Map<String,Object> params) throws ClientProtocolException, IOException{
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse  httpresponse = null;
		httpclient = HttpClients.createDefault();
		
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000).setConnectionRequestTimeout(35000)
									 .setSocketTimeout(60000).build();
		
		List<NameValuePair> nvps = new ArrayList<NameValuePair>() ;
		for (Map.Entry<String,Object> paramEntry : params.entrySet()) {
			nvps.add(new BasicNameValuePair(paramEntry.getKey(),paramEntry.getValue().toString()));
			url = url + "?" + paramEntry.getKey() + "=" + paramEntry.getValue().toString()  + "&";
		}
		url = url.substring(0, url.length() - 1);
		HttpGet httpget = new HttpGet(url);
		httpget.setConfig(requestConfig);
		httpget.addHeader("Content-Type", "text/html");
		httpresponse = httpclient.execute(httpget);
		HttpEntity entity = httpresponse.getEntity();
		String result = EntityUtils.toString(entity);
		return result;
		
	}

}
