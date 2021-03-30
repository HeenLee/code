package com.hollysys.test.http.api.rules.composer.svc;

import com.alibaba.fastjson.JSON;

public class DecisionGroupUpdateName
{
	private String id;
	private String name;
	
	public String getId() 
	{
		return id;
	}
	
	public DecisionGroupUpdateName setId(String id)
	{
		this.id = id;
		return this;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public DecisionGroupUpdateName setName(String name) 
	{
		this.name = name;
		return this;
	}

	@Override
	public String toString() 
	{
		return JSON.toJSONString(this);
	}
	
	
	
	

}
