package com.bp.sso;

import com.alibaba.fastjson.JSON;

public class BuildDataReq {
	private String mData;
	private String mKey;
	private String mZip;
	public String getData() {
		return mData;
	}
	public void setData(String data) {
		this.mData = data;
	}
	public String getKey() {
		return mKey;
	}
	public void setKey(String key) {
		this.mKey = key;
	}
	public String getZip() {
		return mZip;
	}
	public void setZip(String zip) {
		this.mZip = zip;
	}
	
	public String toString(){
		return JSON.toJSONString(this);
	}
	

}
