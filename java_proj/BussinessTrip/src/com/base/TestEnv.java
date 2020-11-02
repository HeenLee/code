//package com.base;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class TestEnv {
//	private static Logger LOG = LoggerFactory.getLogger(TestEnv.class);
//	private static TestEnv INSTANCE = new TestEnv();
//	private HttpClientWrapper mHttpClient = new HttpClientWrapper();
//	
//	private  Config config = new Config();
//	private HttpRequestBody requestBody = new HttpRequestBody();
//	
//	
//	
//	public static HttpClientWrapper httpClient(){
//		return INSTANCE.mHttpClient;
//	}
//	
//	public static Config getConfig(){
//		return INSTANCE.config;
//	}
//	
//	public static HttpRequestBody getParam(){
//		return INSTANCE.requestBody;
//	}
//	
//}
