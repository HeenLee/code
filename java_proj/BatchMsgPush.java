package com.sinosun.mstp.test.integration.http.testcase;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.google.common.util.concurrent.RateLimiter;
import com.sinosun.mstp.test.base.JWTGenerateManager;
import com.sinosun.mstp.test.integration.base.TestEnv;
import com.sinosun.mstp.test.integration.base.http.HttpClientWrapper;
import com.sinosun.mstp.test.integration.base.http.HttpRequestBody;
import com.sinosun.mstp.test.integration.base.http.HttpRequestBodyBuilder;
import com.sinosun.mstp.test.integration.base.http.HttpResponseBody;
import com.sinosun.mstp.test.integration.base.mes.MsgPushReq;
import com.sinosun.mstp.test.integration.base.mes.MsgPushReqBuilder;
import com.sinosun.mstp.test.integration.base.mes.MsgType;
import com.sinosun.mstp.test.integration.base.mes.NotificationReq;
import com.sinosun.mstp.test.integration.base.mes.TextMessageBody;
import com.sinosun.mstp.test.integration.base.ums.UserRegisterReq;
import com.sinosun.mstp.test.integration.base.ums.UserRegisterVo;
import com.sinosun.mstp.test.integration.base.ums.UserRegisterVoBuilder;
import com.sinosun.mstp.test.integration.base.url.MessageServiceUrl;
/**
 * 批量推送性能测试用例
 *
 */
public class BatchMsgPush
{
	/**
	 * 注册url
	 */
	private static final String USER_REGISTER_NEW = "/mstp/user/v2/register";
	
	/**
	 * 消息推送url
	 */
	public static final String MESSAGE_PUSH = "/message/v2/push";
	
	/**
	 * 通知推送url
	 */
	public static final String NOTIFICATION_PUSH = "/notification/v2/push";
	
	/**
	 * 用户注册后保存路径
	 */
	private static String FILE_PATH = System.getProperty("user.dir") +  File.separator + "conf" + File.separator + "bizemateIds.properties";
	
	private static String CONF_PATH = System.getProperty("user.dir") +  File.separator + "conf" + File.separator + "conf.properties";

	/**
	 * 注册用户个数
	 */
	private static int REGISTER_NUM = 300000;
	
	/**
	 * 消息发送条数
	 */
	private static int MES_NUM = 500;
	
	
	/**
	 * 日志
	 */
	private static Logger LOG = LoggerFactory.getLogger(BatchMsgPush.class);
	
	//如果不存在用户，先注册
	static
	{
		File file = new File(FILE_PATH);
		if(!file.exists())
		{
			for(int i = 0; i < REGISTER_NUM; i++){
				String bizmateId = "mstp_test_poc_batch" + i ;
				try {
					String jwt = JWTGenerateManager.getJwt(bizmateId);
					registers(jwt);
				} catch (Exception e) {
					LOG.debug("regist user fail");
				}
				
			}
		}
	}
	
	public static void main(String[] args) throws Exception 
	{
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File(CONF_PATH)));
		int threadNum = Integer.parseInt(prop.getProperty("threadNum"));
		int mesType = Integer.parseInt(prop.getProperty("mesType"));
		
		MetricRegistry metrics = new MetricRegistry();
		
	    Meter meter = metrics.meter(MetricRegistry.name(BatchMsgPush.class, "request"));
	    
	    ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics)
	                .convertRatesTo(TimeUnit.SECONDS)
	                .convertDurationsTo(TimeUnit.SECONDS)
	                .build();
		reporter.start(3, TimeUnit.SECONDS);
		
		for(int i = 0; i < threadNum; i++)
		{
			new Thread(new Runnable(){

				@Override
				public void run() 
				{
					RateLimiter rateLimiter = RateLimiter.create(1);
					HttpResponseBody  response  = null;
					int count = 0;
					while(true) 
					{
						try
						{
							rateLimiter.acquire();
							String url;
							HttpRequestBody request;
							if (mesType == 1)
							{
								url = MessageServiceUrl.buildUrl(NOTIFICATION_PUSH);
								request = buildNotificationHttpBody();
							}
							else
							{
								url = MessageServiceUrl.buildUrl(MESSAGE_PUSH);
								request = buildMsgHttpBody();
							}
							response = TestEnv.httpClient().post(TestEnv.domainManager().getAsAddress(), url, request);
							int num = count ++ ;
						    LOG.debug("消息总数：{}", num);
							meter.mark();
						}
						catch (Exception e)
						{
							
						}
					}
				}
				
			}).start();
		}
	}
	
	/**
	 * 创建消息推送请求
	 * @return 返回httpRequestBody
	 * @throws Exception 
	 */
	public static HttpRequestBody buildMsgHttpBody() throws Exception
	{
		Properties prop = new Properties();
		InputStream is = new BufferedInputStream(new FileInputStream(FILE_PATH));
		prop.load(is);
		
		Iterator<String> iterator = prop.stringPropertyNames().iterator();
		
		List<String> toAppAccountList = new ArrayList<String>();
		//再次开始遍历迭代器
		while(iterator.hasNext()){
			String mstpId = iterator.next();
			String bizmateId = prop.getProperty(mstpId);
			toAppAccountList.add(bizmateId);
			
			if(toAppAccountList.size() == MES_NUM) {
				break;
			}
		}
		

		TextMessageBody msgBody = new TextMessageBody();
//		msgBody.setText("mstp_test_poc mes push, p2p normal");
		msgBody.setText(String.valueOf(System.currentTimeMillis()) + "@PocPushTimeStamp");
		
		//推送请求
		MsgPushReq params = new MsgPushReqBuilder().setFromAppAccount("9279").setToAppAccountList(toAppAccountList)
							.setMsgType(MsgType.TEXT).setMsgBody(msgBody).build();
		HttpRequestBody request = TestEnv.newHttpRequest().setMstpId(4563405793L).setJwt(JWTGenerateManager.getJwt("mstp_test_poc_0")).setParams(JSON.toJSONString(params)).build();
		
		return request;

	}
	
	
	/**
	 * 创建通知推送请求
	 * @return
	 * @throws Exception
	 */
	public static HttpRequestBody buildNotificationHttpBody() throws Exception
	{
		Properties prop = new Properties();
		InputStream is = new BufferedInputStream(new FileInputStream(FILE_PATH));
		prop.load(is);
		
		Iterator<String> iterator = prop.stringPropertyNames().iterator();
		
		List<String> toAppAccountList = new ArrayList<String>();
		//再次开始遍历迭代器
		while(iterator.hasNext()){
			String mstpId = iterator.next();
			String bizmateId = prop.getProperty(mstpId);
			toAppAccountList.add(bizmateId);
			if(toAppAccountList.size() == MES_NUM) {
				break;
			}
		}
		
		//推送请求
		NotificationReq params = new NotificationReq();
		params.setFromAppAccount("9279");
		params.setToAppAccountList(toAppAccountList);
//		params.setPayload("test notification push");
		params.setPayload(String.valueOf(System.currentTimeMillis()) + "@PocPushTimeStamp");
		HttpRequestBody request = TestEnv.newHttpRequest().setMstpId(4563405793L).setJwt(JWTGenerateManager.getJwt("mstp_test_poc_0")).setParams(JSON.toJSONString(params)).build();
		
		return request;

	}
	
	
	/**
	 * 注册用户
	 */
	private static void registers(String jwt) throws Exception
	{
		List<UserRegisterVo> userRegisterList = new ArrayList<UserRegisterVo>();
		long timeStamp = System.currentTimeMillis() / 1000;
		UserRegisterVo userRegisterInfo = new UserRegisterVoBuilder()
				.setAppAccount("mstp_integration_test_" + timeStamp)
				.build();
		userRegisterList.add(userRegisterInfo);
		UserRegisterReq params = new UserRegisterReq();
		params.setUserList(userRegisterList);
		HttpRequestBody request = new HttpRequestBodyBuilder()
				.setParams(JSON.toJSONString(params)).setJwt(jwt)
				.build();
		HttpResponseBody response = new HttpClientWrapper()
				.post(TestEnv.domainManager().getAsAddress(), USER_REGISTER_NEW, request);
		
		if (response.getCode().equals("0"))
		{
			JSONObject json = JSON.parseObject(response.getDataPlaintext());
			json.remove("code"); 
			LOG.debug("Register users : {}", json);
			saveToProperties(json);
		}
		else
		{
			throw new Exception("Failed to register users.");
		}
	}
	
	
	/**
	 * 保存内容到properties文件
	 * @param jsonObject
	 */
	public static void saveToProperties(JSONObject jsonObject)
	{
		Properties prop = new Properties();
        File file = new File(FILE_PATH);
        OutputStream out = null;
        try {
			out = new FileOutputStream(file,true);
			String bizmateId = jsonObject.getString("appAccount");
			String mstpId = jsonObject.getString("mstpId");
			prop.setProperty(mstpId, bizmateId);
			try {
				prop.store(out, "users");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 
	}
}
