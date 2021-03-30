package com.hollysys.test.http.api.rules.composer.svc;

import com.alibaba.fastjson.JSON;

public class DecisionGroupGetById 
{
	private String groupId;

	public String getGroupId() {
		return groupId;
	}

	public DecisionGroupGetById setGroupId(String groupId) {
		this.groupId = groupId;
		return this;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
	
	
	

}
