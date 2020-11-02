//package com.bp.testcase;
//
//import java.io.IOException;
//
//import org.junit.Test;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.util.Base64;
//import com.base.TestEnv;
//import com.bp.sso.BuildDataReq;
//import com.bp.sso.BuilderDateReqBuilder;
//
//public class GetRegistCodeTest {
//	@Test
//	public void test_regis_code() throws IOException{
//		JSONObject jsonData = new JSONObject();
//		jsonData.put("userPhone", "123");
//		jsonData.put("vType", "1");
//		jsonData.put("IMEI","12345");
//		
//		BuildDataReq data = new BuilderDateReqBuilder().setKey("").setZip("0").setData(Base64.decodeFast(jsonData.toString()).toString()).build();
//		String param = "bdata=" + JSON.toJSONString(data);
//		JSONObject response = null;
//		try {
//			response = TestEnv.httpClient().sendPost(TestEnv.getConfig().getYQTAddress(), "/yqt/user/user.getVerifyCode",param);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//}
