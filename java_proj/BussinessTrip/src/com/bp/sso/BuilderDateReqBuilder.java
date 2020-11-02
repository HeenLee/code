package com.bp.sso;

public class BuilderDateReqBuilder {
	private String mData;
	private String mZip;
	private String mKey;
	public String getData() {
		return mData;
		
	}
	public BuilderDateReqBuilder setData(String data) {
		this.mData = data;
		return this;
	}
	public String getZip() {
		return mZip;
	}
	public BuilderDateReqBuilder setZip(String zip) {
		this.mZip = zip;
		return this;
	}
	public String getKey() {
		return mKey;
	}
	public BuilderDateReqBuilder setKey(String key) {
		this.mKey = key;
		return this;
	}
	
	public BuildDataReq build(){
		BuildDataReq build = new BuildDataReq();
		build.setData(mData);
		build.setKey(mKey);
		build.setZip(mZip);
		return build;
	}
	

}
