package com.hollysys.test.base.http;
/**
 * 预留
 */
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class HttpRequestBody {
	private JSONObject mBody;
	
	public JSONObject getBody() {
		return mBody;
	}
	public void setData(JSONObject body) {
		this.mBody = body;
	}
	
	public String toString(){
		return JSON.toJSONString(this);
	}
	
	
	
}
