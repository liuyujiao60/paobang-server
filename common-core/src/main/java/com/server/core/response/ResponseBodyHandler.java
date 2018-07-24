package com.server.core.response;

import org.springframework.stereotype.Component;

import com.server.core.exception.DBExceptionEnums;

@Component
public class ResponseBodyHandler {
	
	public CommonResponseEntity response(Object object,String requestStamp){
		CommonResponseEntity responseEntity=new CommonResponseEntity();
		responseEntity.responseCode=DBExceptionEnums.REQUEST_SUCCESS.getCode();
		responseEntity.responseMessage=DBExceptionEnums.REQUEST_SUCCESS.getMessage();
		responseEntity.setResponseData(object);
		responseEntity.requestStamp=requestStamp;
		return responseEntity;
		
	}
	
	public CommonResponseEntity response(String exception,String requestStamp){
		CommonResponseEntity responseEntity=new CommonResponseEntity();
		responseEntity.responseCode=DBExceptionEnums.UNKNOWN_REQUEST_ERROR.getCode();
		responseEntity.responseMessage=exception;
		responseEntity.requestStamp=requestStamp;
		return responseEntity;
	}
	
	public CommonResponseEntity response(String code,String message,String requestStamp){
		CommonResponseEntity responseEntity=new CommonResponseEntity();
		responseEntity.responseCode=code;
		responseEntity.responseMessage=message;
		responseEntity.requestStamp=requestStamp;
		return responseEntity;
	}
}
