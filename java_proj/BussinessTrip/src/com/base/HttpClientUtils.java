package com.base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Consts;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;


public class HttpClientUtils {
	private static Logger LOG = LoggerFactory.getLogger(HttpClientUtils.class);
	
	 /**
     * 发送post请求
     *
     * @param url:请求地址
     * @param header:请求头参数
     * @param params:表单参数  form提交
     * @param httpEntity   json/xml参数
     * @return
     */
    public static String doPostRequest(String url, Map<String, String> header, Map<String, String> params, HttpEntity httpEntity) {
        String resultStr = "";
        if (url.isEmpty()) {
            return resultStr;
        }
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        try {
            httpClient = SSLClientCustom.getHttpClinet();
            HttpPost httpPost = new HttpPost(url);
            //请求头header信息
            if (!(header.isEmpty())) {
                for (Map.Entry<String, String> stringStringEntry : header.entrySet()) {
                    httpPost.setHeader(stringStringEntry.getKey(), stringStringEntry.getValue());
                }
            }
            //请求参数信息
            if (!(params.isEmpty())) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (Map.Entry<String, String> stringStringEntry : params.entrySet()) {
                    paramList.add(new BasicNameValuePair(stringStringEntry.getKey(), stringStringEntry.getValue()));
                }
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(paramList, Consts.UTF_8);
                httpPost.setEntity(urlEncodedFormEntity);
            }
            //实体设置
            if (httpEntity != null) {
                httpPost.setEntity(httpEntity);
            }

            //发起请求
            httpResponse = httpClient.execute(httpPost);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity httpResponseEntity = httpResponse.getEntity();
                resultStr = EntityUtils.toString(httpResponseEntity);
                LOG.debug("请求正常,请求地址:{},响应结果:{}", url, resultStr);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                HeaderIterator headerIterator = httpResponse.headerIterator();
                while (headerIterator.hasNext()) {
                    stringBuffer.append("\t" + headerIterator.next());
                }
                LOG.debug("异常信息:请求地址:{},响应状态:{},请求返回结果:{}", url, httpResponse.getStatusLine().getStatusCode(), stringBuffer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HttpClientUtils.closeConnection(httpClient, httpResponse);
        }
        return resultStr;
    }
    
    /**
     * post上传文件
     * @param url
     * @param params
     * @param file
     * @return
     * @throws IOException
     */
    public static String doPostFile(String url, Map<String,String> params,File file) throws IOException {
    	CloseableHttpClient httpClient = null;
    	CloseableHttpResponse httpResponse = null;
    	RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(200000).setSocketTimeout(2000000).build();
    	httpClient = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
    	HttpPost httppost = new HttpPost(url);	
    	httppost.setConfig(requestConfig);
    	
    	MultipartEntityBuilder multipart  = MultipartEntityBuilder.create();
    	
    	for (Entry<String,String> param : params.entrySet()) {
			multipart.addTextBody(param.getKey(), param.getValue());
		}
    	
    	FileBody fileBody = new FileBody(file);
    	StringBody comment = new StringBody("Content-Type", ContentType.MULTIPART_FORM_DATA);
    	multipart.addPart("file", fileBody);
    	multipart.addPart("Content-Type", comment);
    	
    	HttpEntity httpEntity = multipart.build();
    	httppost.setEntity(httpEntity);
    	
        httpResponse = httpClient.execute(httppost);
    	
    	HttpEntity resEntity = httpResponse.getEntity();
    	String str = JSON.toJSONString(resEntity);
    	System.out.println(str);
    	return str;
    	
    }
    
    /**
     * 发送Get请求
     * @param url
     * @param header
     * @param params
     * @return
     */
    public static String doGetRequest(String url, Map<String, String> header, Map<String, String> params) {
        String resultStr = "";
        if (url.isEmpty()) {
            return resultStr;
        }
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        try {
            httpClient = SSLClientCustom.getHttpClinet();
            //请求参数信息
            if (!(params.isEmpty())) {
                url = url + buildUrl(params);
            }
            HttpGet httpGet = new HttpGet(url);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)//连接超时
                    .setConnectionRequestTimeout(5000)//请求超时
                    .setSocketTimeout(5000)//套接字连接超时
                    .setRedirectsEnabled(true).build();//允许重定向
            httpGet.setConfig(requestConfig);
            if (!(header.isEmpty())) {
                for (Map.Entry<String, String> stringStringEntry : header.entrySet()) {
                    httpGet.setHeader(stringStringEntry.getKey(), stringStringEntry.getValue());
                }
            }
            //发起请求
            httpResponse = httpClient.execute(httpGet);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                resultStr = EntityUtils.toString(httpResponse.getEntity(), Consts.UTF_8);
                LOG.debug("请求地址:{},响应结果:{}", url, resultStr);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                HeaderIterator headerIterator = httpResponse.headerIterator();
                while (headerIterator.hasNext()) {
                    stringBuffer.append("\t" + headerIterator.next());
                }
                LOG.debug("异常信息:请求响应状态:{},请求返回结果:{}", httpResponse.getStatusLine().getStatusCode(), stringBuffer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HttpClientUtils.closeConnection(httpClient, httpResponse);
        }
        return resultStr;
    }


    /**
     * 关掉连接释放资源
     */
    private static void closeConnection(CloseableHttpClient httpClient, CloseableHttpResponse httpResponse) {
        if (httpClient != null) {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (httpResponse != null) {
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * get请求的参数传递
     * @param map
     * @return
     */
    private static String buildUrl(Map<String, String> map) {
    	String result = "";
        if (map.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer("?");
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            stringBuffer.append(stringStringEntry.getKey()).append("=").append(stringStringEntry.getValue()).append("&");
        }
        result = stringBuffer.toString();
        if (!(result.isEmpty())) {
            result = result.substring(0, result.length() - 1);   //去掉结尾的&连接符
        }
        return result;
    }
    
    /**
     * 构造url
     */
    private String buildUrl(String host,String path){
    	StringBuffer sb = new StringBuffer();
    	sb.append("http://").append("host").append(path);
    	return sb.toString();
    }
 }