package com.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class HttpResponseBody {
	private static final Logger LOG = LoggerFactory.getLogger(HttpResponseBody.class);
	/**
	 * 响应码
	 */
	private String mCode;
	
	/**
	 * 响应数据
	 */
	private String mData;
	
	/**
	 * 加密
	 */
	private int mEncrypt;
	
	/**
	 * 压缩
	 */
	private int mZip;

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

	public int getmEncrypt() {
		return mEncrypt;
	}

	public void setmEncrypt(int mEncrypt) {
		this.mEncrypt = mEncrypt;
	}

	public int getmZip() {
		return mZip;
	}

	public void setmZip(int mZip) {
		this.mZip = mZip;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this);
	}
	
	

}
