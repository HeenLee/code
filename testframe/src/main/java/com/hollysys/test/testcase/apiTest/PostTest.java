package com.hollysys.test.testcase.apiTest;

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
import com.hollysys.test.base.Config;
import com.hollysys.test.base.TestEnv;
import com.hollysys.test.base.database.JDBCUtils;
import com.hollysys.test.base.request.HttpClientWrapper;

public class PostTest 
{
	/*
	 * 连接数据库
	 */
	@Test
	public void testConDB() throws SQLException{
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
	public void testPost() throws DocumentException, KeyManagementException, NoSuchAlgorithmException, IOException
	{
		Config config = TestEnv.getConfig();
		String address = config.loadConfig().getAddress();
		System.out.println(address);
		
		JSONObject param = new JSONObject();
		param.put("name", "china");
		
	    JSONObject response = new HttpClientWrapper().sendPost(address, "post", param.toJSONString());
	    System.out.println(response);
	}
	
	/*
	 * 发送http:get请求
	 */
	@Test
	public void testGet() throws DocumentException, KeyManagementException, NoSuchAlgorithmException, IOException, KeyStoreException, URISyntaxException
	{
		Config config = TestEnv.getConfig();
		String address = config.loadConfig().getAddress();
		System.out.println(address);
		
		JSONObject param = new JSONObject();
		param.put("name", "china");
	    JSONObject response = new HttpClientWrapper().sendGet(address, "get", param.toJSONString());
	    System.out.println(response);
	}
	
	/*
	 * 测试http请求上传文件
	 */
	@Test
	public void testUpload() throws DocumentException, NoSuchAlgorithmException, KeyStoreException, ClientProtocolException, IOException, URISyntaxException
	{
		Config config = TestEnv.getConfig();
		String address = config.loadConfig().getAddress();
		System.out.println(address);
		
		String filename = "d:/hello.txt";
	    JSONObject response = new HttpClientWrapper().uploadFile(address, "post", filename);
	    System.out.println(response);
	}
	
	/*
	 * 发送https:post请求
	 */
	@Test
	public void testPosts() throws DocumentException, KeyManagementException, NoSuchAlgorithmException, IOException
	{
		Config config = TestEnv.getConfig();
		String address = config.loadConfig().getAddress();
		System.out.println(address);
		
		JSONObject param = new JSONObject();
		param.put("name", "china");
	    JSONObject response = new HttpClientWrapper().sendPosts(address, "post", param.toJSONString());
	    System.out.println(response);
	}
	
	/*
	 * 发送https:get请求
	 */
	@Test
	public void testGets() throws DocumentException, KeyManagementException, NoSuchAlgorithmException, IOException, KeyStoreException, URISyntaxException
	{
		Config config = TestEnv.getConfig();
		String address = config.loadConfig().getAddress();
		System.out.println(address);
		
		JSONObject param = new JSONObject();
		param.put("name", "china");
	    JSONObject response = new HttpClientWrapper().sendGets(address, "get", param.toJSONString());
	    System.out.println(response);
	}
	
	/*
	 * 测试http请求上传文件
	 */
	@Test
	public void testUploads() throws DocumentException, NoSuchAlgorithmException, KeyStoreException, ClientProtocolException, IOException, URISyntaxException, KeyManagementException
	{
		Config config = TestEnv.getConfig();
		String address = config.loadConfig().getAddress();
		System.out.println(address);
		
		String filename = "d:/hello.txt";
	    JSONObject response = new HttpClientWrapper().uploadFiles(address, "post", filename);
	    System.out.println(response);
	}

}
