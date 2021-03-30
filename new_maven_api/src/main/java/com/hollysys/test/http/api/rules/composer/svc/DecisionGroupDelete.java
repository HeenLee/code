package com.hollysys.test.http.api.rules.composer.svc;

import com.alibaba.fastjson.JSON;

public class DecisionGroupDelete 
{
	private String groupId;
	public String getGroupId() {
		return this.groupId;
	}
	public DecisionGroupDelete setGroupId(String groupId) {
		this.groupId = groupId;
		return this;
	}
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
	
	
	

}
