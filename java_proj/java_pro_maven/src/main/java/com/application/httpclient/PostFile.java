package com.application.httpclient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class PostFile {
    private static Logger Log = LoggerFactory.getLogger(PostFile.class);

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException {
        String url = "https://httpbin.org/post";
        File file = new File("d:/hello.txt");
        String filename = "abc";
        //http请求上传
        uploadFile(url, file, filename);

        //https请求上传
        uploadFiles(url, file, filename);
    }

    //发送http + post请求，上传文件
    private static void uploadFile(String url, File file, String filename) {
        //创建客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //构造post请求
        HttpPost httpPost = new HttpPost(url);
//        httpPost.addHeader("Content-type",ContentType.MULTIPART_FORM_DATA.toString());
        Log.info("请求url：{}", url);

        //创建上传文件实体
        FileBody filebody = new FileBody(file);

        //设定上传的文件类型
        StringBody comment = new StringBody("Content-Type", ContentType.MULTIPART_FORM_DATA);

        //文件上传的首部类型需要设置为Multipart/form-data
        MultipartEntityBuilder multiPart = MultipartEntityBuilder.create();
        multiPart.addPart(filename, filebody);
        multiPart.addPart("Content-Type", comment);

        //查看首部
        Header[] headers = httpPost.getHeaders("Content-Type");
        for (Header header : headers) {
            System.out.println(header.getName());
        }

        //实体
        HttpEntity requestEntity = multiPart.build();
        httpPost.setEntity(requestEntity);

        CloseableHttpResponse response = null;
        try {
            //发送请求
            response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode(); //查看响应码。如果是200，取出实体内容
            Log.info("响应码：{}", statusCode);
            if (statusCode == 200) {
                String result = EntityUtils.toString(responseEntity);  //将响应实体转为字符串
                Log.info("响应内容为：{}", result);
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * https+post 上传文件
     *
     * @param url
     * @param file
     * @param filename
     */
    public static void uploadFiles(String url, File file, String filename) throws KeyManagementException, NoSuchAlgorithmException {
        //创建一个不需要安全验证的https客户端
        CloseableHttpClient httpClient = createIgnoreHttpClient();
        HttpPost httpPost = new HttpPost(url);
//        httpPost.addHeader("Content-type",ContentType.MULTIPART_FORM_DATA.toString());
        Log.info("请求url：{}", url);

        //创建上传文件实体
        FileBody filebody = new FileBody(file);

        //设定上传的文件类型
        StringBody comment = new StringBody("Content-Type", ContentType.MULTIPART_FORM_DATA);

        //文件上传的首部类型需要设置为Multipart/form-data
        MultipartEntityBuilder multiPart = MultipartEntityBuilder.create();
        multiPart.addPart(filename, filebody);
        multiPart.addPart("Content-Type", comment);

        //查看首部
        Header[] headers = httpPost.getHeaders("Content-Type");
        for (Header header : headers) {
            System.out.println(header.getName());
        }

        //实体
        HttpEntity requestEntity = multiPart.build();
        httpPost.setEntity(requestEntity);

        CloseableHttpResponse response = null;
        try {
            //发送请求
            response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode(); //查看响应码。如果是200，取出实体内容
            Log.info("响应码：{}", statusCode);
            if (statusCode == 200) {
                String result = EntityUtils.toString(responseEntity);  //将响应实体转为字符串
                Log.info("响应内容为：{}", result);
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 创建https客户端的方法
     *
     * @return
     */
    private static CloseableHttpClient createIgnoreHttpClient() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        //实现X509TrustManager接口
        X509TrustManager x509TrustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };

        sslContext.init(null, new TrustManager[]{x509TrustManager}, null);

        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", new SSLConnectionSocketFactory(sslContext))
                .build();
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);

        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
        return httpClient;

    }
}
