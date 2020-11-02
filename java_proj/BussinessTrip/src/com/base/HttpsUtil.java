//package com.base;
//
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.security.KeyManagementException;
//import java.security.NoSuchAlgorithmException;
//import java.security.cert.CertificateException;
//import java.security.cert.X509Certificate;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.net.ssl.HttpsURLConnection;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLSocketFactory;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;
//
//import org.apache.http.client.HttpClient;
//
//import com.base.TestEnv;
//
//public class HttpsUtil {
//	private static Logger LOG = LoggerFactory.getLogger(HttpsUtil.class);
//
//	public static String doPost(String host,String path,String params) throws KeyManagementException, NoSuchAlgorithmException, IOException{
//		SSLContext ctx = SSLContext.getInstance("SSL");
//		X509TrustManager tm = new X509TrustManager() {
//			
//			@Override
//			public X509Certificate[] getAcceptedIssuers() {
//				return null;
//			}
//			
//			@Override
//			public void checkServerTrusted(X509Certificate[] arg0, String arg1)
//					throws CertificateException {
//				
//			}
//			
//			@Override
//			public void checkClientTrusted(X509Certificate[] arg0, String arg1)
//					throws CertificateException {
//			}
//		};
//		if(host != null || params != null){
//			return null;
//		}
//		
//		LOG.debug("post request,host:{},path:{},requestBody:{}",host,path,params.toString());;
//		
//		ctx.init(null, new TrustManager[]{tm}, null);
//		SSLSocketFactory ssf = ctx.getSocketFactory();
//		String url = buildUrl(host,path);
//		URL final_url = new URL(url);
//		HttpsURLConnection con = (HttpsURLConnection) final_url.openConnection();
//		con.setSSLSocketFactory(ssf);
//		return url;
//
//		
//	}
//	
//	private static String buildUrl(String host, String path) {
//		StringBuffer sb = new StringBuffer();
//		sb.append("https").append(":").append("//").append(host).append(path);
//		return sb.toString();
//	}
//}
