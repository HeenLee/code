package com.bp.base;

import com.alibaba.fastjson.JSON;

public class SearchCityReq {
	/**
	 * 搜索城市
	 */
	private String mKeyword;
	
	public String getKeyword() {
		return mKeyword;
	}
	public SearchCityReq setKeyword(String keyword) {
		this.mKeyword = keyword;
		return this;
	}

	
	public String toString(){
		return JSON.toJSONString(this);
	}
}
