package com.application.httpclient;
/**
 * get请求url带参数时，需要使用URIBuilder类  把参数进行编码格式
 * post请求参数实体是key=value格式时，需要使用UrlEncodedFormEntity类对实体进行编码格式
 *      参数实体是json时，需要使用StringEntiry()字符串对象
 */

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.Charsets;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;

/**
 * http工具类
 */
public class HttpClientUtils {
    private static final Logger log = LoggerFactory.getLogger(HttpClientUtils.class);

    /**
     * 发送http+get请求  不带参数
     * @param url
     * @return
     */
    public static String sendHttpGet(String url){
        //创建http请求客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        return doGet(url, httpClient);
    }

    /**
     * 发送https+get请求，绕过证书  不带参数
     * @param url
     * @return
     */
    public static String sendHttpsGet(String url) throws KeyManagementException, NoSuchAlgorithmException {
        //创建https请求客户端
        CloseableHttpClient httpClient = createIgnoreVerifyHttpClient();
        return doGet(url, httpClient);
    }

    public static String sendHttpsGet(String url, Map<String, String> param) throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException {
        CloseableHttpClient httpClient = createIgnoreVerifyHttpClient();
        return doGet(url, httpClient, param);
    }


    /**
     * 发送http+post请求
     * @return
     */
    public static String sendHttpPost(String url, JSONObject params) throws UnsupportedEncodingException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        return doPost(httpClient, url, params);
    }

    public static String sendHttpPost(String url, JSONObject params, Map<String, String> header) throws UnsupportedEncodingException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        return doPost(httpClient, url, params, header);
    }

    public static String sendHttpPost(String url, Map<String, String> params, Map<String, String> header) throws UnsupportedEncodingException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        return doPost(httpClient, url, params, header);
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
     * 封装get请求方式，不带参数
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
     * get请求带参数
     * @param url
     * @param httpClient
     * @param params
     * @return
     * @throws URISyntaxException
     */
    private static String doGet(String url, CloseableHttpClient httpClient, Map<String, String> params) throws URISyntaxException {

        log.info("HttpGet请求url：{}", url);
        //url的构造对象 将key ：value 在url中改为key=vaule&key=value形式
        URIBuilder uriBuilder = new URIBuilder(url);
        //创建键值对列表，NameValuePair是键值对形式key=value。对个参数就是list集合
        List<NameValuePair> list = new ArrayList<>();
        for (String key : params.keySet()) {
            String value = params.get(key);
            list.add(new BasicNameValuePair(key, value));

        }
        //多个参数放在参数中
        uriBuilder.setParameters(list);
        //创建get对象
        HttpGet httpGet = new HttpGet(uriBuilder.build());  //请求时将参数以？隔开

        return execute(httpClient, httpGet);
    }

    /**
     * 封装post请求方式。把请求首部已经确定的情况。参数是json  "key":"value"
     * @param httpClient
     * @param url
     * @param params
     * @return
     */
    private static String doPost(CloseableHttpClient httpClient, String url, JSONObject params) throws UnsupportedEncodingException {
        log.info("post请求url：{}, 请求参数params:{}", url, params);
        HttpPost httpPost = new HttpPost(url);

        //添加请求首部
        httpPost.addHeader("Content-Type", "application/json;charset=utf-8");

        //添加请求实体entity，也就是参数.传入的是json字符串格式
        httpPost.setEntity(new StringEntity(params.toString()));
        return execute(httpClient, httpPost);

    }

    /**
     * 封装post请求。首部可以自己定义。参数类型是json    "key":"value"
     */
    private static String doPost(CloseableHttpClient httpClient, String url, JSONObject params, Map<String, String> mapHeader) throws UnsupportedEncodingException {
        log.info("请求url：{}，请求参数{}",url, mapHeader);
        HttpPost httpPost = new HttpPost(url);

        for (String key : mapHeader.keySet()) {
            httpPost.addHeader(key,mapHeader.get(key));
        }
        //设置请求实体   传入的是json字符串格式
        httpPost.setEntity(new StringEntity(JSONObject.toJSONString(params)));
        return execute(httpClient, httpPost);
    }

    /**
     * 封装post请求。首部和参数都是map类型。参数是map  key=value
     */
    private static String doPost(CloseableHttpClient httpClient, String url, Map<String, String> params, Map<String, String> mapHeader) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(url);

        //post请求添加header
        for (String key : mapHeader.keySet()) {
            httpPost.addHeader(key, mapHeader.get(key));
        }

        //添加参数，键值对的形式 key=value&key=value形式
        List<NameValuePair> list = new ArrayList<>();
        Set<Map.Entry<String, String>> entrys = params.entrySet();
        for (Map.Entry<String, String> entry : entrys) {
            NameValuePair nameValue = new BasicNameValuePair(entry.getKey(), entry.getValue());
            list.add(nameValue);
        }
        //将参数编码为key=value&key=value的形式
        httpPost.setEntity(new UrlEncodedFormEntity(list, Charsets.UTF_8));
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
                //getEntity()获取到响应实体，将实体转为String对象
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
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

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


    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        String url = "https://www.baidu.com";
        String httpGetResponse = sendHttpGet(url);

        System.out.println(httpGetResponse);

        System.out.println("==============");
        JSONObject param = new JSONObject();
        param.put("name", "haha");
        String httpPostResponse = sendHttpPost("http://httpbin.org/post", param);
        System.out.println(httpPostResponse);

        System.out.println("***********************************");


        Map<String, String> map = new HashMap<>();
        map.put("name", "sino");
        map.put("pwd", "123");

        Map<String, String> mapParam = new HashMap<>();
        mapParam.put("content-type", "application/json");
        String Response = sendHttpPost("http://httpbin.org/post", map, mapParam);
        System.out.println(Response);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


        String result = sendHttpsGet("http://httpbin.org/get", map);
        System.out.println(result);

    }


}
