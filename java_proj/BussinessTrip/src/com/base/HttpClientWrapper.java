//package com.base;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.io.PrintWriter;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.security.KeyManagementException;
//import java.security.KeyStore;
//import java.security.KeyStoreException;
//import java.security.NoSuchAlgorithmException;
//import java.security.cert.CertificateException;
//import java.security.cert.X509Certificate;
//
//import javax.net.ssl.HttpsURLConnection;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLSocketFactory;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.conn.scheme.Scheme;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.apache.http.ssl.SSLContextBuilder;
//import org.apache.http.ssl.TrustStrategy;
//import org.apache.http.util.EntityUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.alibaba.fastjson.JSONObject;
//
//public class HttpClientWrapper 
//{
//	/**
//	 * Log
//	 */
//	private static final Logger LOG = LoggerFactory.getLogger(HttpClientWrapper.class);
//	
//	
//	   private static final String HTTP = "http";
//	    private static final String HTTPS = "https";
//	    private static final SSLConnectionSocketFactory sslConnection = null;
//	    private static PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = null;//连接池管理类
//	    private static SSLContextBuilder sslContextBuilder = null;//管理Https连接的上下文类
//	/**
//	 * 发送post  https请求
//	 * @param host
//	 * @param path
//	 * @param param
//	 * @return
//	 * @throws KeyManagementException 
//	 * @throws NoSuchAlgorithmException 
//	 * @throws IOException 
//	 */
//	public JSONObject doPost(String host, String path, String param) throws KeyManagementException, NoSuchAlgorithmException, IOException{
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
//		if(host != null || param != null){
//			return null;
//		}
//		
//		LOG.debug("post request,host:{},path:{},requestBody:{}",host,path,param.toString());;
//		
//		ctx.init(null, new TrustManager[]{tm}, null);
//		SSLSocketFactory ssf = ctx.getSocketFactory();
//		String url = buildUrl(host,path);
//		URL final_url = new URL(url);
//		HttpsURLConnection con = (HttpsURLConnection) final_url.openConnection();
//		con.setSSLSocketFactory(ssf);
//		HttpClient c = null;
//		return null;
//		
//	}
//	
//	public JSONObject doGet() throws NoSuchAlgorithmException, KeyStoreException{
//		
//
//		SSLContextBuilder ssl = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy(){
//		
//			@Override
//			public boolean isTrusted(X509Certificate[] arg0, String arg1)
//					throws CertificateException {
//				return true;
//			}
//			
//			ssl
//			
//		});
//			
//		return null;
//	}
//	
//	
//	/**
//	 * 组装访问路径
//	 * @param host
//	 * 地址
//	 * @param path
//	 * url
//	 * @return
//	 * 返回全路径
//	 */
//    private static String buildUrl(String host, String path)
//    {
//    	//服务地址信息
//        StringBuilder sb = new StringBuilder();
//        sb.append("https://");
//        sb.append(host).append(path);
//        LOG.info("build path: {}",sb.toString());
//        return sb.toString();
//    }
//    
//	/**
//	 * https请求
//	 * @param param
//	 * 参数
//	 * @param host
//	 * url
//	 * @param path
//	 * 地址
//	 * @return
//	 * 请求结果
//	 */
//    public JSONObject sendPost(String param, String host, String path) 
//    {
//    	LOG.debug("get request, param:{}, host:{}, path:{}", param, host, path);
//        PrintWriter out = null;
//        BufferedReader in = null;
//        String result = "";
//        try {
//        	// 创建SSLContext对象，并使用我们指定的信任管理器初始化
//            TrustManager[] tm = { new MyX509TrustManager()};    
//            SSLContext sslContext = SSLContext.getInstance("SSL");             
//            sslContext.init(null, tm, new java.security.SecureRandom());    
//            SSLSocketFactory ssf = sslContext.getSocketFactory(); 
//            String url = buildUrl(host, path);
//            // 打开和URL之间的连接
//            URL realUrl = new URL(url);
//            HttpsURLConnection conn = (HttpsURLConnection) realUrl.openConnection();
//            conn.setSSLSocketFactory(ssf); 
//            
//            // 设置通用的请求属性
//            conn.setRequestProperty("accept", "*/*");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("content-Type", "application/json");
//            conn.setRequestProperty("user-agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            // 发送POST请求必须设置如下两行
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//            out = new PrintWriter(conn.getOutputStream());
//                     
//            out.print(param);
//            out.flush();
//            in = new BufferedReader(
//                    new InputStreamReader(conn.getInputStream()));
//            String line;
//            while ((line = in.readLine()) != null) {
//                result += line;
//            }
//        } catch (Exception e) {
//            LOG.error("send https failed",e);
//            e.printStackTrace();
//        }
//        finally
//        {
//            try
//            {
//                if (out != null)
//                {
//                    out.close();
//                }
//                if (in != null)
//                {
//                    in.close();
//                }
//            }
//            catch (IOException ex)
//            {
//                ex.printStackTrace();
//            }
//        }
//        //将结果解析为Json
//        JSONObject jsonresult = JSONObject.parseObject(result);
//        LOG.debug("http response :{}", jsonresult);
//        return jsonresult;
//    }   
//    
//    /**
//     * https请求
//     * @param host
//     * 地址
//     * @param path
//     * url
//     * @param requestMethod
//     * 请求格式
//     * @param outputStr
//     * 参数
//     * @return
//     * 返回值
//     */
//    public JSONObject httpsRequest(String host, String path, String requestMethod,String outputStr)
//    {  
//    	LOG.debug("get request, host:{}, path: {} method:{}, param:{}", host, path, requestMethod, outputStr);
//    	String url1 = buildUrl(host, path);
//        StringBuffer buffer = null;  
//        try
//        {  
//        //创建SSLContext对象，并使用我们指定的信任管理器初始化
//        SSLContext sslContext = SSLContext.getInstance("SSL");  
//        TrustManager[] tm = {new MyX509TrustManager()};  
//        sslContext.init(null, tm, new java.security.SecureRandom());;  
//        //从上述SSLContext对象中得到SSLSocketFactory对象
//        SSLSocketFactory ssf = sslContext.getSocketFactory();  
//        URL url = new URL(url1);  
//        HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();  
//        conn.setDoOutput(true);  
//        conn.setDoInput(true);  
//        conn.setUseCaches(false);
//        conn.setRequestMethod(requestMethod); 
//        conn.setSSLSocketFactory(ssf);  
//        conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
//        conn.connect();
//        //当有数据需要提交时
//        if (null != outputStr)
//        {  
//            OutputStream os = conn.getOutputStream();  
//            os.write(outputStr.getBytes("utf-8"));  
//            os.close();  
//        }  
//          
//        InputStream is = conn.getInputStream();  
//        InputStreamReader isr = new InputStreamReader(is,"utf-8");  
//        BufferedReader br = new BufferedReader(isr);  
//        buffer = new StringBuffer();  
//        String line = null;  
//        while ((line = br.readLine()) != null)
//        {  
//            buffer.append(line);  
//        }  
//        }
//        catch (Exception e)
//        {  
//            e.printStackTrace();  
//        }
//        if (buffer == null)
//        {
//        	return null;
//        }
//        //将结果解析为Json
//        JSONObject jsonresult = JSONObject.parseObject(buffer.toString());
//        LOG.debug("http response :{}", jsonresult);
//        return jsonresult;  
//    }  
//    
//    /**
//     * https请求
//     * @param host
//     * 地址
//     * @param path
//     * url
//     * @param requestMethod
//     * 请求格式
//     * @param outputStr
//     * 参数
//     * @return
//     * 返回值
//     */
//    public JSONObject httpsGetTgcRequest(String host, String path, String requestMethod,String outputStr)
//    {  
//    	LOG.debug("get request, host:{}, path: {} method:{}, param:{}", host, path, requestMethod, outputStr);
//    	String url1 = buildUrl(host, path);
//        StringBuffer buffer = null;  
//        try
//        {  
//        //创建SSLContext对象，并使用我们指定的信任管理器初始化
//        SSLContext sslContext = SSLContext.getInstance("SSL");  
//        TrustManager[] tm = {new MyX509TrustManager()};  
//        sslContext.init(null, tm, new java.security.SecureRandom());;  
//        //从上述SSLContext对象中得到SSLSocketFactory对象
//        SSLSocketFactory ssf = sslContext.getSocketFactory();  
//        URL url = new URL(url1);  
//        HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();  
//        conn.setDoOutput(true);  
//        conn.setDoInput(true);  
//        conn.setUseCaches(false);
//        conn.setRequestMethod(requestMethod); 
//        conn.setSSLSocketFactory(ssf);  
//        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//        conn.connect();
//        //当有数据需要提交时
//        if (null != outputStr)
//        {  
//            OutputStream os = conn.getOutputStream();  
//            os.write(outputStr.getBytes("utf-8"));  
//            os.close();  
//        }  
//          
//        InputStream is = conn.getInputStream();  
//        InputStreamReader isr = new InputStreamReader(is,"utf-8");  
//        BufferedReader br = new BufferedReader(isr);  
//        buffer = new StringBuffer();  
//        String line = null;  
//        while ((line = br.readLine()) != null)
//        {  
//            buffer.append(line);  
//        }  
//        }
//        catch (Exception e)
//        {  
//            e.printStackTrace();  
//        }
//        if (buffer == null)
//        {
//        	return null;
//        }
//        //将结果解析为Json
//        JSONObject jsonresult = JSONObject.parseObject(buffer.toString());
//        LOG.debug("http response :{}", jsonresult);
//        return jsonresult;  
//    }   
//}
