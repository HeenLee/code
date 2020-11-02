package com.bp.base;

public class SearchCityReqBuilder {
	/**
	 * 搜索城市
	 */
	private String mKeyword;
	
	public String getKeyword() {
		return mKeyword;
	}
	public SearchCityReqBuilder setKeyword(String keyword) {
		this.mKeyword = keyword;
		return this;
	}

	
	public SearchCityReq build(){
		SearchCityReq scq = new SearchCityReq();
		scq.setKeyword(mKeyword);
		return scq;
	}
}
