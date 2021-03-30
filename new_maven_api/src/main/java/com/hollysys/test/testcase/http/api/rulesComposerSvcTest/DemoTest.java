package com.hollysys.test.testcase.http.api.rulesComposerSvcTest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.http.client.ClientProtocolException;
import org.dom4j.DocumentException;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.hollysys.test.base.TestEnv;
import com.hollysys.test.base.database.JDBCUtils;
import com.hollysys.test.base.http.HttpClientWrapper;

public class DemoTest 
{
	/**
	 * 连接数据库
	 * @throws SQLException
	 */
	@Test
	public void testConnectDB() throws SQLException
	{
		Connection conn = JDBCUtils.getConnection();
		Statement st = conn.createStatement();
		String sql = "select * from user where id = 1";
		ResultSet rs = st.executeQuery(sql);
        while(rs.next())
        {
            int id = rs.getInt(1);
            String name = rs.getString("name");
            System.out.println(id + "---" + name);
        }
        JDBCUtils.close(rs, st, conn);
	}
	
	/*
	 * 发送http:post请求
	 */
	@Test
	public void testPost() throws Exception
	{
		String ops = TestEnv.getConfig().getOps();
		JSONObject param = new JSONObject();
		param.put("name", "china");
		
	    JSONObject response = TestEnv.httpClient().sendPost(ops, "post", param.toJSONString());
	    System.out.println(response);
	    
	    
	    boolean ishttps = TestEnv.getConfig().isHttps();
	    System.out.println(ishttps);
	}
	
	/*
	 * 发送http:get请求
	 */
	@Test
	public void testGet() throws DocumentException, KeyManagementException, NoSuchAlgorithmException, IOException, KeyStoreException, URISyntaxException
	{
		String ens = TestEnv.getConfig().getOps();
		JSONObject param = new JSONObject();
		param.put("name", "china");
	    JSONObject response = new HttpClientWrapper().sendGet(ens, "get", param.toJSONString());
	    System.out.println(response);
	}
	
	/*
	 * 测试http请求上传文件
	 */
	@Test
	public void testUpload() throws DocumentException, NoSuchAlgorithmException, KeyStoreException, ClientProtocolException, IOException, URISyntaxException
	{
		String ens = TestEnv.getConfig().getOps();
		String filename = "d:/hello.txt";
	    JSONObject response = new HttpClientWrapper().uploadFile(ens, "post", filename);
	    System.out.println(response);
	}
	
	/*
	 * 发送https:post请求
	 */
	@Test
	public void testPosts() throws DocumentException, KeyManagementException, NoSuchAlgorithmException, IOException
	{
		String ens = TestEnv.getConfig().getOps();
		JSONObject param = new JSONObject();
		param.put("name", "china");
	    JSONObject response = new HttpClientWrapper().sendPosts(ens, "post", param.toJSONString());
	    System.out.println(response);
	}
	
	/*
	 * 发送https:get请求
	 */
	@Test
	public void testGets() throws DocumentException, KeyManagementException, NoSuchAlgorithmException, IOException, KeyStoreException, URISyntaxException
	{
		String ens = TestEnv.getConfig().getOps();
		JSONObject param = new JSONObject();
		param.put("name", "china");
	    JSONObject response = new HttpClientWrapper().sendGets(ens, "get", param.toJSONString());
	    System.out.println(response);
	}
	
	/*
	 * 测试http请求上传文件
	 */
	@Test
	public void testUploads() throws DocumentException, NoSuchAlgorithmException, KeyStoreException, ClientProtocolException, IOException, URISyntaxException, KeyManagementException
	{
		String ens = TestEnv.getConfig().getOps();
		String filename = "d:/hello.txt";
	    JSONObject response = new HttpClientWrapper().uploadFiles(ens, "post", filename);
	    System.out.println(response);
	}

}
