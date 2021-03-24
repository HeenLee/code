package com.hollysys.test.base.request;

import com.alibaba.fastjson.JSON;

public class HttpResponseBody {
	/**
	 * 响应码
	 */
	private String mCode;
	
	/**
	 * 响应数据
	 */
	private String mData;
	

	public String getmCode() {
		return mCode;
	}

	public void setmCode(String mCode) {
		this.mCode = mCode;
	}

	public String getmData() {
		return mData;
	}

	public void setmData(String mData) {
		this.mData = mData;
	}

	@Override
	public String toString(){
		return JSON.toJSONString(this);
	}
}
