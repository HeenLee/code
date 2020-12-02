package com.application.httpclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.application.json.JsonArrayBase;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

/**
 * http工具类
 */
public class HttpClientUtils {
    private static final Logger log = LoggerFactory.getLogger(HttpClientUtils.class);

    /**
     * 发送http+get请求
     * @param url
     * @return
     */
    public static String sendHttpGet(String url){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        return doGet(url, httpClient);
    }

    /**
     * 发送https+get请求，绕过证书
     * @param url
     * @return
     */
    public static String sendHttpsGet(String url) throws KeyManagementException, NoSuchAlgorithmException {
        CloseableHttpClient httpClient = createIgnoreVerifyHttpClient();
        return doGet(url, httpClient);
    }


    /**
     * 发送http+post请求
     * @return
     */
    public static String sendHttpPost(String url, JSONObject params) throws UnsupportedEncodingException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        return doPost(httpClient, url, params);
    }


    /**
     * 发送https+post请求
     * @param url
     * @param params
     * @return
     */
    public static String sendHttpsPost(String url, JSONObject params) throws UnsupportedEncodingException, KeyManagementException, NoSuchAlgorithmException {
        CloseableHttpClient httpClient = createIgnoreVerifyHttpClient();
        return doPost(httpClient, url, params);
    }

    /**
     * 封装get请求方式
     * @param url
     * @param httpClient
     * @return
     */
    private static String doGet(String url, CloseableHttpClient httpClient) {
        log.info("HttpGet请求url：{}", url);
        HttpGet httpGet = new HttpGet(url);
        return execute(httpClient, httpGet);
    }

    /**
     * 封装post请求方式。把请求首部已经确定的情况
     * @param httpClient
     * @param url
     * @param params
     * @return
     */
    private static String doPost(CloseableHttpClient httpClient, String url, JSONObject params) throws UnsupportedEncodingException {
        log.info("post请求url：{}, 请求参数params:{}", url, params);
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
        httpPost.setEntity(new StringEntity(params.toString()));
        return execute(httpClient, httpPost);

    }

    /**
     * 执行请求发送的方法
     * @param httpClient
     * @param requestBase
     * @return
     */

    private static String execute(CloseableHttpClient httpClient, HttpRequestBase requestBase) {
        String result = null;
        CloseableHttpResponse response = null;
        try {
           response =  httpClient.execute(requestBase);
            int statusCode = response.getStatusLine().getStatusCode();
            log.info("HttpResponse响应code：{}", statusCode);
            if(statusCode == 200){
                result = EntityUtils.toString(response.getEntity());
            }else{
                log.error("httpClient请求失败，错误码：{}", statusCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(httpClient != null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        log.info("HttpClient请求结果：{}", result);
        return result;
    }

    /**
     * https绕过验证的方法
     * @return
     */
    private static CloseableHttpClient createIgnoreVerifyHttpClient() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        //实现一个X509TrustManager接口
        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };

        sslContext.init(null, new TrustManager[]{trustManager}, null);
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", new SSLConnectionSocketFactory(sslContext)).build();

        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connManager).build();
        return httpClient;
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        String url = "https://www.baidu.com";
        String httpGetResponse = sendHttpGet(url);
        String httpsGetResponse = sendHttpGet(url);

        System.out.println(httpGetResponse);
        System.out.println(httpsGetResponse);

        System.out.println("==============");
        JSONObject param = new JSONObject();
        param.put("name", "haha");
        String httpPostResponse = sendHttpPost("http://httpbin.org/post", param);
        System.out.println(httpPostResponse);
    }


}
