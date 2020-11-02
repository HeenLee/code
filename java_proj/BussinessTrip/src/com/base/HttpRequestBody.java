package com.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class HttpRequestBody {
	private static final Logger LOG = LoggerFactory.getLogger(HttpRequestBody.class);
	private JSONObject data;
	
	public JSONObject getData() {
		return data;
	}
	public void setData(JSONObject data) {
		this.data = data;
	}
	
	public String toString(){
		return JSON.toJSONString(this);
	}
	
	
	
}
