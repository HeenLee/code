package com.hollysys.test.testcase.http.api.rulesComposerSvcTest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.hollysys.test.base.TestEnv;
import com.hollysys.test.http.api.rules.composer.svc.DecisionGroupUpdateName;
import com.hollysys.test.http.api.url.ComposerSvcURL;

public class DecisionGroupUpdateNameTest 
{
	@Test
	public void testUP() throws NoSuchAlgorithmException, KeyStoreException, ClientProtocolException, IOException, URISyntaxException, KeyManagementException
	{
		DecisionGroupUpdateName dgun = new DecisionGroupUpdateName();
		String param = dgun.setId("11111").setName("222").toString();
		JSONObject response = TestEnv.httpClient().sendPut(TestEnv.getConfig().getAddress(), ComposerSvcURL.DECISIONGROUP_UPDATE,  param);
		System.out.println(response);
		
	}
	
	

}
