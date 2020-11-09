package com.application.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class Demo1_Https {
/**
 * 发送https请求
 * @throws KeyStoreException 
 * @throws NoSuchAlgorithmException 
 * @throws KeyManagementException 
 * @throws IOException 
 * @throws CertificateException 
 */
	public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
		CloseableHttpClient httpclient = getHttpClient(true);
		HttpGet httpget = new HttpGet("https://yqtblackbox.sinosun.com:18093/static/tcm/pages/login.html");
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpget);
			HttpEntity responseEntity = response.getEntity();
			System.out.println("响应状态为:" + response.getStatusLine());
			if(responseEntity != null){
				System.out.println("响应内容长度为:" + responseEntity.getContentLength());
				String responseStr = EntityUtils.toString(responseEntity, "utf-8");
				System.out.println("响应内容为:" + responseStr);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
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

	private static CloseableHttpClient getHttpClient(boolean isHttps) throws KeyManagementException, 
														NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
		CloseableHttpClient httpclient;
		if(isHttps){
			SSLConnectionSocketFactory sslSocketFactory;
			sslSocketFactory = getSocketFactory(false,null,null);
			httpclient = HttpClientBuilder.create().setSSLSocketFactory(sslSocketFactory).build();
			return httpclient;
		}
		httpclient = HttpClientBuilder.create().build();
		return httpclient;
	}

	private static SSLConnectionSocketFactory getSocketFactory(boolean needVerifyCa,
								InputStream caInputStream, String caAlias) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, CertificateException, IOException {
		X509TrustManager x509TrustManager;
		//https请求，需要校验
		if(needVerifyCa){
			KeyStore keyStore = getKeyStore(caInputStream,caAlias);
			TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
			trustManagerFactory.init(keyStore);
			TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
			if(trustManagers.length != 1 || (trustManagers[0] instanceof X509TrustManager)){
				throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
			}
			x509TrustManager = (X509TrustManager) trustManagers[0];
			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(null, new TrustManager[]{x509TrustManager}, new SecureRandom());
			
			return new SSLConnectionSocketFactory(sslContext);
		}
		
		//https请求，不作证书校验
		x509TrustManager = new X509TrustManager() {
			
			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}
			
			@Override
			public void checkServerTrusted(X509Certificate[] chain, String authType)
					throws CertificateException {
				
			}
			
			@Override
			public void checkClientTrusted(X509Certificate[] chain, String authType)
					throws CertificateException {
				
			}
		};
		SSLContext sslContext = SSLContext.getInstance("TLS");
		sslContext.init(null,new TrustManager[]{x509TrustManager},new SecureRandom());
		return new SSLConnectionSocketFactory(sslContext);
		
	}

	private static KeyStore getKeyStore(InputStream caInputStream,String caAlias) throws CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException {
		CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
		KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
		keyStore.load(null);
		keyStore.setCertificateEntry(caAlias, certificateFactory.generateCertificate(caInputStream));
		return keyStore;
	}


}
