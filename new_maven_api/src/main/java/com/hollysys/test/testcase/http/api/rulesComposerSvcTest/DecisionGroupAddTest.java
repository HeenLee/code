package com.hollysys.test.testcase.http.api.rulesComposerSvcTest;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.hollysys.test.base.TestEnv;
import com.hollysys.test.http.api.rules.composer.svc.DecisionGroupAdd;
import com.hollysys.test.http.api.url.ComposerSvcURL;

public class DecisionGroupAddTest {
	@Test
	public void testAdd() throws KeyManagementException, NoSuchAlgorithmException, IOException{
		DecisionGroupAdd decisionGroupAdd = new DecisionGroupAdd();
		String addParam = decisionGroupAdd.setName("111").setRulePackageId("111111").toString();
		JSONObject response = TestEnv.httpClient().sendPost(TestEnv.getConfig().getAddress(), ComposerSvcURL.DECISIONGROUP_ADD, addParam);
		String status = TestEnv.getString(response, "status");
		System.out.println(response);
		System.out.println(status);
	}

}
