package com.hollysys.test.testcase.http.api.rulesComposerSvcTest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.hollysys.test.base.TestEnv;
import com.hollysys.test.http.api.rules.composer.svc.DecisionGroupDelete;
import com.hollysys.test.http.api.url.ComposerSvcURL;

public class DecisionGroupDeleteTest {
	@Test
	public void testDel() throws KeyManagementException, NoSuchAlgorithmException, IOException, URISyntaxException{
		DecisionGroupDelete decisionGroupDel = new DecisionGroupDelete();
		String delParam = decisionGroupDel.setGroupId("2222").toString();
		JSONObject response = TestEnv.httpClient().sendDelete(TestEnv.getConfig().getAddress(), ComposerSvcURL.DECISIONGROUP_DELETE, delParam);
		String status = TestEnv.getString(response, "status");
		System.out.println(response);
		System.out.println(status);
	}

}
