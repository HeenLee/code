package com.hollysys.test.http.api.rules.composer.svc;

import com.alibaba.fastjson.JSON;

public class DecisionGroupAdd 
{
	private String name;
	private String rulePackageId;
	public String getName() {
		return name;
	}
	public DecisionGroupAdd setName(String name) {
		this.name = name;
		return this;
	}
	public String getRulePackageId() {
		return rulePackageId;
	}
	public DecisionGroupAdd setRulePackageId(String rulePackageId) {
		this.rulePackageId = rulePackageId;
		return this;
	}
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
	
	
	

}
