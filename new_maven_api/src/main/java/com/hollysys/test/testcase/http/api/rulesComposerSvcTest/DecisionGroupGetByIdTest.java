package com.hollysys.test.testcase.http.api.rulesComposerSvcTest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.hollysys.test.base.TestEnv;
import com.hollysys.test.http.api.rules.composer.svc.DecisionGroupGetById;
import com.hollysys.test.http.api.url.ComposerSvcURL;

public class DecisionGroupGetByIdTest {
	@Test
	public void testGet() throws NoSuchAlgorithmException, KeyStoreException, ClientProtocolException, IOException, URISyntaxException{
		DecisionGroupGetById getById = new DecisionGroupGetById();
		String getByIdParam = getById.setGroupId("111").toString();
		JSONObject getByIdResponse = TestEnv.httpClient().sendGet(TestEnv.getConfig().getAddress(), ComposerSvcURL.DECISIONGROUP_GETBYID , getByIdParam);
		System.out.println(getByIdResponse);
	}

}
