package com.hollysys.test.base.http;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class HttpClientWrapper 
{
	/**
	 * 请求类型
	 */
	private boolean isHttps = false;
	
	/**
	 * 日志
	 */
	private static final Logger LOG = LoggerFactory.getLogger(HttpClientWrapper.class);
	
	/**
	 * 发送http:post请求
	 * @param host
	 * @param path
	 * @param param
	 * @return
	 * @throws KeyManagementException 
	 * @throws NoSuchAlgorithmException 
	 * @throws IOException 
	 */
	public JSONObject sendPost(String host, String path, String param) throws KeyManagementException, NoSuchAlgorithmException, IOException
	{
		LOG.info("send post request, host:{}, path:{}, param:{}", host, path, param);
		String url = buildUrl(host, path);
		try 
		{
			RequestConfig requestconfig = RequestConfig.custom().setConnectTimeout(30000)
					        .setConnectionRequestTimeout(30000)
							.setSocketTimeout(30000).build();
			
			HttpClient httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);
			
			HttpEntity requestEntity = new StringEntity(param, ContentType.APPLICATION_JSON);
			httpPost.setHeader("Content-Type", "application/json;charset=utf8");
			httpPost.setEntity(requestEntity);
			httpPost.setConfig(requestconfig);
			
			HttpResponse response = httpclient.execute(httpPost);
			if(response.getStatusLine().getStatusCode() == 200)
			{
				HttpEntity responseEntity = response.getEntity();
				String responseData = EntityUtils.toString(responseEntity,"utf-8");
				LOG.info(responseData);
				return JSONObject.parseObject(responseData);
			}
			else
			{
				LOG.info("response fail");
			}
		} catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 发送http:get请求
	 * @return 
	 * @throws NoSuchAlgorithmException
	 * @throws KeyStoreException
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * @throws URISyntaxException 
	 */
	public JSONObject sendGet(String host, String path, String param) throws NoSuchAlgorithmException, KeyStoreException, ClientProtocolException, IOException, URISyntaxException
	{
		LOG.info("send get request, host:{}, path:{}, param:{}", host, path, param);
		String url = buildUrl(host, path);
		JSONObject json = JSONObject.parseObject(param);
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		Set<Entry<String, Object>> paramValues= json.entrySet();
		for(Entry<String, Object> valuePair: paramValues)
		{
			String key = valuePair.getKey();
			String value = (String)valuePair.getValue();
			formparams.add(new BasicNameValuePair(key, value));
		}
		URI uri = new URIBuilder(url).setParameters(formparams).build();
		try 
		  {
			RequestConfig requestconfig = RequestConfig.custom().setConnectTimeout(30000).setConnectionRequestTimeout(30000)
							.setSocketTimeout(30000).build();
			
			HttpClient httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(uri);
			httpGet.setConfig(requestconfig);
			
			HttpResponse response = httpclient.execute(httpGet);
			
			if(response.getStatusLine().getStatusCode() == 200)
			{
				HttpEntity responseEntity = response.getEntity();
				String responseData = EntityUtils.toString(responseEntity,"utf-8");
				LOG.info(responseData);
				return JSONObject.parseObject(responseData);
			}else
			{
				LOG.info("response fail");
			}
		} catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 发送http:put请求
	 * @param host
	 * @param path
	 * @param param
	 * @return
	 * @throws KeyManagementException 
	 * @throws NoSuchAlgorithmException 
	 * @throws IOException 
	 */
	public JSONObject sendPut(String host, String path, String param) throws KeyManagementException, NoSuchAlgorithmException, IOException
	{
		LOG.info("send post request, host:{}, path:{}, param:{}", host, path, param);
		String url = buildUrl(host, path);
		try 
		{
			RequestConfig requestconfig = RequestConfig.custom().setConnectTimeout(30000)
							.setConnectionRequestTimeout(30000)
							.setSocketTimeout(30000).build();
			
			HttpEntity requestEntity = new StringEntity(param, ContentType.APPLICATION_JSON);
			HttpClient httpclient = HttpClients.createDefault();
			HttpPut httpPut = new HttpPut(url);
			httpPut.setHeader("Content-Type", "application/json;charset=utf8");
			httpPut.setEntity(requestEntity);
			httpPut.setConfig(requestconfig);
			
			HttpResponse response = httpclient.execute(httpPut);
			
			if(response.getStatusLine().getStatusCode() == 200)
			{
				HttpEntity responseEntity = response.getEntity();
				String responseData = EntityUtils.toString(responseEntity,"utf-8");
				LOG.info(responseData);
				return JSONObject.parseObject(responseData);
			}
			else
			{
				LOG.info("response fail");
			}
		} catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 发送http:delete请求
	 * @param host
	 * @param path
	 * @param param
	 * @return
	 * @throws KeyManagementException 
	 * @throws NoSuchAlgorithmException 
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	public JSONObject sendDelete(String host, String path, String param) throws KeyManagementException, NoSuchAlgorithmException, IOException, URISyntaxException
	{
		LOG.info("send post request, host:{}, path:{}, param:{}", host, path, param);
		String url = buildUrl(host, path);
		JSONObject json = JSONObject.parseObject(param);
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		Set<Entry<String, Object>> paramValues= json.entrySet();
		for(Entry<String, Object> valuePair: paramValues)
		{
			String key = valuePair.getKey();
			String value = (String)valuePair.getValue();
			formparams.add(new BasicNameValuePair(key, value));
		}
		try 
		{
			//编码参数，将参数格式为value1=""&value2=""&value3=""
			URI uri = new URIBuilder(url).setParameters(formparams).build();
			
			RequestConfig requestconfig = RequestConfig.custom().setConnectTimeout(30000).setConnectionRequestTimeout(5000)
							.setSocketTimeout(30000).build();
			
			HttpClient httpclient = HttpClients.createDefault();
			HttpDelete httpDelete = new HttpDelete(uri);
			httpDelete.setHeader("Content-Type", "application/json;charset=utf8");
			httpDelete.setConfig(requestconfig);
			
			HttpResponse response = httpclient.execute(httpDelete);
			
			if(response.getStatusLine().getStatusCode() == 200)
			{
				HttpEntity responseEntity = response.getEntity();
				String responseData = EntityUtils.toString(responseEntity,"utf-8");
				LOG.info(responseData);
				return JSONObject.parseObject(responseData);
			}
			else
			{
				LOG.info("response fail");
			}
		} catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 发送http:post上传文件请求
	 * @param host 请求地址
	 * @param path 请求路径
	 * @param filename 上传文件名
	 */
    public JSONObject uploadFile(String host, String path, String filename) 
    {
    	LOG.info("post request, host:{}, path:{}, filename:{}", host, path, filename);
        //创建客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = buildUrl(host, path);
        //构造post请求
        HttpPost httpPost = new HttpPost(url);
        LOG.info("请求url：{}", url);
        
        File file = new File(filename);
        //创建上传文件实体
        FileBody filebody = new FileBody(file);

        //设定上传的文件类型
        StringBody comment = new StringBody("Content-Type", ContentType.MULTIPART_FORM_DATA);

        //文件上传的首部类型需要设置为Multipart/form-data
        MultipartEntityBuilder multiPart = MultipartEntityBuilder.create();
        multiPart.addPart(filename, filebody);
        multiPart.addPart("Content-Type", comment);

        //查看首部
/*        Header[] headers = httpPost.getHeaders("Content-Type");
        for (Header header : headers) {
            System.out.println(header.getName());
        }*/

        //实体
        HttpEntity requestEntity = multiPart.build();
        httpPost.setEntity(requestEntity);

        CloseableHttpResponse response = null;
        try {
            //发送请求
            response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode(); //查看响应码。如果是200，取出实体内容
            LOG.info("响应码：{}", statusCode);
            if (statusCode == 200) 
            {
                String result = EntityUtils.toString(responseEntity);  //将响应实体转为字符串
                LOG.info("响应内容为：{}", result);
                return JSONObject.parseObject(result);
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        } finally 
        {
            try 
            {
                httpClient.close();
            } catch (IOException e) 
            {
                e.printStackTrace();
            }
            try 
            {
                response.close();
            } catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
        return null;
    }
	
    
	/**
	 * 发送https:post请求
	 */
	public JSONObject sendPosts(String host, String path, String param) throws KeyManagementException, NoSuchAlgorithmException, IOException
	{
		LOG.info("send post request, host:{}, path:{}, param:{}", host, path, param);
		String url = buildUrl(host, path);
		JSONObject json = JSONObject.parseObject(param);
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		Set<Entry<String, Object>> paramValues= json.entrySet();
		for(Entry<String, Object> valuePair: paramValues)
		{
			String key = valuePair.getKey();
			String value = (String)valuePair.getValue();
			formparams.add(new BasicNameValuePair(key, value));
		}
		try 
		{
			//编码参数，将参数格式为value1=""&value2=""&value3=""
			HttpEntity requestEntity = new UrlEncodedFormEntity(formparams,"utf-8");
			
			RequestConfig requestconfig = RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(5000)
							.setSocketTimeout(5000).build();
			
			
			HttpClient httpclient = createIgnoreHttpClient();
			HttpPost httpPost = new HttpPost(url);
			httpPost.setHeader("Content-Type", "application/json;charset=utf8");
			httpPost.setEntity(requestEntity);
			httpPost.setConfig(requestconfig);
			
			HttpResponse response = httpclient.execute(httpPost);
			
			if(response.getStatusLine().getStatusCode() == 200)
			{
				HttpEntity responseEntity = response.getEntity();
				String responseData = EntityUtils.toString(responseEntity,"utf-8");
				LOG.info(responseData);
				return JSONObject.parseObject(responseData);
			}else
			{
				LOG.info("response fail");
			}
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return null;
	}
    
    
	/**
	 * 发送https:get请求
	 * 
	 * @throws KeyManagementException 
	 */
	public JSONObject sendGets(String host, String path, String param) throws NoSuchAlgorithmException, KeyStoreException, ClientProtocolException, IOException, URISyntaxException, KeyManagementException
	{
		LOG.info("send get request, host:{}, path:{}, param:{}", host, path, param);
		String url = buildUrl(host, path);
		JSONObject json = JSONObject.parseObject(param);
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		Set<Entry<String, Object>> paramValues= json.entrySet();
		for(Entry<String, Object> valuePair: paramValues)
		{
			String key = valuePair.getKey();
			String value = (String)valuePair.getValue();
			formparams.add(new BasicNameValuePair(key, value));
		}
		URI uri = new URIBuilder(url).setParameters(formparams).build();
		try 
		{
			
			RequestConfig requestconfig = RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(5000)
							.setSocketTimeout(5000).build();
			
			HttpClient httpclient = createIgnoreHttpClient();
			
			HttpGet httpGet = new HttpGet(uri);
			httpGet.setConfig(requestconfig);
			
			HttpResponse response = httpclient.execute(httpGet);
			
			if(response.getStatusLine().getStatusCode() == 200)
			{
				HttpEntity responseEntity = response.getEntity();
				String responseData = EntityUtils.toString(responseEntity,"utf-8");
				LOG.info(responseData);
				return JSONObject.parseObject(responseData);
			}
			else
			 	{
					LOG.info("response fail");
			 	}
		} catch (UnsupportedEncodingException e) 
			{
				e.printStackTrace();
			}
		return null;
	}
    
    
   
	/**
	 * https:post上传文件请求
	 */
    public JSONObject uploadFiles(String host, String path, String filename) throws KeyManagementException, NoSuchAlgorithmException
    {
    	LOG.info("post request, host:{}, path:{}, filename:{}", host, path, filename);
    	String url = buildUrl(host, path);
        //创建一个不需要安全验证的https客户端
        CloseableHttpClient httpClient = createIgnoreHttpClient();
        HttpPost httpPost = new HttpPost(url);
        LOG.info("请求url：{}", url);
        File file = new File(filename);
        //创建上传文件实体
        FileBody filebody = new FileBody(file);

        //设定上传的文件类型
        StringBody comment = new StringBody("Content-Type", ContentType.MULTIPART_FORM_DATA);

        //文件上传的首部类型需要设置为Multipart/form-data
        MultipartEntityBuilder multiPart = MultipartEntityBuilder.create();
        multiPart.addPart(filename, filebody);
        multiPart.addPart("Content-Type", comment);

/*        //查看首部
        Header[] headers = httpPost.getHeaders("Content-Type");
        for (Header header : headers) {
            System.out.println(header.getName());
        }*/

        //实体
        HttpEntity requestEntity = multiPart.build();
        httpPost.setEntity(requestEntity);

        CloseableHttpResponse response = null;
        try 
        {
            //发送请求
            response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode(); //查看响应码。如果是200，取出实体内容
            LOG.info("响应码：{}", statusCode);
            if (statusCode == 200) 
            {
                String result = EntityUtils.toString(responseEntity);  //将响应实体转为字符串
                LOG.info("响应内容为：{}", result);
                return JSONObject.parseObject(result);
            }
        } catch (IOException e)
        {
        	e.printStackTrace();
        } finally
        {
            try 
            {
                httpClient.close();
            } catch (IOException e) 
            {
                e.printStackTrace();
            }
            try 
            {
                response.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }
    

    /**
	 * 构建URL
	 * @param host  请求地址
	 * @param path  请求路径
	 * @return    返回全路径
	 * 
	 */
    private String buildUrl(String host, String path)
    {
    	StringBuilder sb = new StringBuilder();
    	//构建https请求URL
    	if(isHttps)
    	{
    		  sb.append("https://");
    	      sb.append(host).append(path);
    	      LOG.info("build path: {}",sb.toString());
    	}
    	//构建http请求URL
    	else
    	{                                 
  		  sb.append("http://");
	      sb.append(host).append(path);
	      LOG.info("build path: {}",sb.toString());
    	}
        return sb.toString();
    }
    
    
    /**
     * 创建https客户端的方法
     *
     * @return
     */
    private static CloseableHttpClient createIgnoreHttpClient() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        //实现X509TrustManager接口
        X509TrustManager x509TrustManager = new X509TrustManager() 
        {
            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException 
            {
            	
            }
            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException 
            {
            	
            }
            @Override
            public X509Certificate[] getAcceptedIssuers() 
            {
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
