package com.paobang.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paobang.service.HeartBeatService;
import com.server.core.exception.DBExceptionEnums;
import com.server.core.exception.ServerException;

@Controller
@RequestMapping("/testHealth")
public class TestHealthController {
	
	public static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(30);
	
	@Resource
	private HeartBeatService heartBeatService;

	@ResponseBody
	@RequestMapping("/heartbeat")
	public Object heartBeat(){
		try{
			
		}catch(Exception e){
			throw new ServerException(DBExceptionEnums.UNKNOWN_REQUEST_ERROR,e);
		}
		return null;
	}
}
