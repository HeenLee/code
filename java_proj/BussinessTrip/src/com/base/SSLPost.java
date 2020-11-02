package com.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;


public class SSLPost {
	private static final Logger LOG = LoggerFactory.getLogger(SSLPost.class);

	public SSLContextBuilder loadTrustMaterial(KeyStore truststore,TrustStrategy trustStrategy) throws NoSuchAlgorithmException, KeyStoreException{
		TrustManagerFactory tmfactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		tmfactory.init(truststore);
		TrustManager[] tms = tmfactory.getTrustManagers();
		if(tms != null){
			if(trustStrategy != null){
				for(int i=0;i<tms.length;++i){
					TrustManager tm = tms[i];
					 if (tm instanceof X509TrustManager) {
//	                        tms[i] = new SSLContext);
				}
			}
		}
		}
		return null;
	}
		
	    //重载的方法，不需要证书，只需要信任策略
	    public SSLContextBuilder loadTrustMaterial(TrustStrategy trustStrategy) throws NoSuchAlgorithmException, KeyStoreException {
	        return this.loadTrustMaterial((KeyStore)null, (TrustStrategy)trustStrategy);
	    }
	    

public static CloseableHttpClient createSSLClientDefault() {
        try {
            //使用 loadTrustMaterial() 方法实现一个信任策略，信任所有证书
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                // 信任所有
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            //NoopHostnameVerifier类:  作为主机名验证工具，实质上关闭了主机名验证，它接受任何        
            //有效的SSL会话并匹配到目标主机。
            HostnameVerifier hostnameVerifier = NoopHostnameVerifier.INSTANCE;
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return HttpClients.createDefault();
 
}


public static String doPost(String url, String data) {
    //构建POST请求   请求地址请更换为自己的。
    HttpPost post = new HttpPost(url);
    InputStream inputStream = null;
    String result="";
    try {
        //使用之前写的方法创建httpClient实例
        CloseableHttpClient httpClient = createSSLClientDefault();
        // 构造消息头
        post.setHeader("Content-type", "application/json; charset=utf-8");
        post.setHeader("Connection", "Close");
        // 构建消息实体
        StringEntity entity = new StringEntity(data, Charset.forName("UTF-8"));
        entity.setContentEncoding("UTF-8");
        // 发送Json格式的数据请求
        entity.setContentType("application/json");
        post.setEntity(entity);
        //发送请求
        HttpResponse response = httpClient.execute(post);
         result=JSONObject.toJSONString(response);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    return result;
}
}
