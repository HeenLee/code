package com.application.httpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

/**
 * post无参
 * @author lihe
 *
 */
public class Post_NoParam {
	@Test
	public void doPostTestOne(){
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		HttpPost httppost = new HttpPost("http://local:12345/doPostControllerOne");
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httppost);
			
			HttpEntity responseEntity = response.getEntity();
			System.out.println("响应状态为:" + response.getStatusLine());
			if(responseEntity != null){
				System.out.println("响应内容长度为：" + responseEntity.getContentLength());
				System.out.println("响应内容为：" + EntityUtils.toString(responseEntity));
			}
			System.out.println();
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
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
