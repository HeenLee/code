package com.bp.base;

import com.alibaba.fastjson.JSON;

public class GetRegisterVerifyCodeReq {
	private String mUserPhone;
	private String mVtype;
	private String mIMEI;
	public String getUserPhone() {
		return mUserPhone;
	}
	public void setUserPhone(String userPhone) {
		this.mUserPhone = userPhone;
	}
	public String getVtype() {
		return mVtype;
	}
	public void setVtype(String vType) {
		this.mVtype = vType;
	}
	public String getIMEI() {
		return mIMEI;
	}
	public void setIMEI(String IMEI) {
		this.mIMEI = IMEI;
	}
	public String toString(){
		return JSON.toJSONString(this);
	}
	
	
}
