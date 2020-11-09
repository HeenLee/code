package com.application.httpclient;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class Post_File {

	public static void main(String[] args) {
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		HttpPost httppost = new HttpPost("http://www.baidu.com");
		
		//1 构造上传文件
		FileBody filebody = new FileBody(new File("D:/hello.txt"));
		//2 设定上传的类型
		StringBody comment = new StringBody("Content-Type", ContentType.MULTIPART_FORM_DATA);
		
		//3
		MultipartEntityBuilder multipart = MultipartEntityBuilder.create();
		multipart.addPart("file",filebody);
		multipart.addPart("Content-Type",comment);
		
		HttpEntity reqEntity = multipart.build();
		httppost.setEntity(reqEntity);
		
		System.out.println("executing request" + httppost.getRequestLine());
		
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httppost);
			System.out.println("------------------------------------");
			System.out.println(response.getStatusLine());
			HttpEntity responseEntity = response.getEntity();
			if(responseEntity != null){
					System.out.println("响应长度为:" + responseEntity.getContentLength());
					System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
			} 
		}catch (ParseException e) {
					e.printStackTrace();
		} catch (ClientProtocolException e) {
					e.printStackTrace();
		 } catch (IOException e) {
			   	e.printStackTrace();
		 }finally{
			 try {
				httpclient.close();
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		 }
	}
}
