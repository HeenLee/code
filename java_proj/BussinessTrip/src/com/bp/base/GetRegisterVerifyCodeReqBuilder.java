package com.bp.base;

public class GetRegisterVerifyCodeReqBuilder {
	private String mUserPhone;
	private String mVtype;
	private String mIMEI;
	public String getUserPhone() {
		return mUserPhone;
	}
	public GetRegisterVerifyCodeReqBuilder setUserPhone(String userPhone) {
		this.mUserPhone = userPhone;
		return this;
	}
	public String getVtype() {
		return mVtype;
	}
	public GetRegisterVerifyCodeReqBuilder setVtype(String vType) {
		this.mVtype = vType;
		return this;
	}
	public String getIMEI() {
		return mIMEI;
	}
	public GetRegisterVerifyCodeReqBuilder setIMEI(String IMEI) {
		this.mIMEI = IMEI;
		return this;
	}
	
	public GetRegisterVerifyCodeReq build(){
		GetRegisterVerifyCodeReq gev = new GetRegisterVerifyCodeReq();
		gev.setIMEI(mIMEI);
		gev.setUserPhone(mUserPhone);
		gev.setVtype(mVtype);
		return gev;
	}
	
	
	
}
