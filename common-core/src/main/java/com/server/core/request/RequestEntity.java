package com.server.core.request;

import com.alibaba.fastjson.JSONObject;

public class RequestEntity<T> extends CommonRequestEntity{
	
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
