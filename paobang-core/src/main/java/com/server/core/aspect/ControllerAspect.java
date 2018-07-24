package com.server.core.aspect;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.server.core.exception.ServerException;
import com.server.core.log.LoggerFactory;
import com.server.core.response.CommonResponseEntity;
import com.server.core.response.ResponseBodyHandler;
import com.server.core.util.DateUtil;

@Aspect
@Component
public class ControllerAspect {
	
	Logger logger=LoggerFactory.getRequestInfoLogger(ControllerAspect.class);
	
	@Resource
	private ResponseBodyHandler responseBodyHandler;
	
	@Pointcut("execution(public * com.server.controller..*.*(..))")
    public void controllerHandler() {
    }
	
	@Around("controllerHandler()")
    public Object controllerHandler(ProceedingJoinPoint thisJoinPoint){
		HttpServletRequest request =((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		CommonResponseEntity responseEntity=null;
		JSONObject logInfo=new JSONObject();
		{
			logInfo.put("dateTime", DateUtil.getStringDateByDate(new Date()));
			
			JSONObject header=new JSONObject();
			header.put("requestUUID", request.getHeader("requestUUID"));
			logInfo.put("header", header);
			
			if(thisJoinPoint.getArgs()!=null&&thisJoinPoint.getArgs().length>0){
				Object params = ((Object[]) thisJoinPoint.getArgs())[0];
				if(!(params instanceof MultipartFile))
					logInfo.put("params", params);
			}else{
				logInfo.put("params", new Object());
			}
	        
	        String url = request.getRequestURL().toString();
	        logInfo.put("url", url);
		}
		try {
			
			Object result = thisJoinPoint.proceed();
			responseEntity=responseBodyHandler.response(result, null);
				
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			if(e instanceof ServerException){
				if(((ServerException) e).getException()!=null)
					((ServerException) e).getException().printStackTrace();
				responseEntity=responseBodyHandler.response(((ServerException)e).getCode(),((ServerException)e).getMessage(), null);
			}else{
				responseEntity=responseBodyHandler.response(e.getMessage(), null);
				e.printStackTrace();
			}
		}
		logInfo.put("responseBody", responseEntity);
		logger.info(logInfo.toJSONString());
        return responseEntity;
    }
}
