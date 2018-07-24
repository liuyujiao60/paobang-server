package com.server.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.core.exception.DBExceptionEnums;
import com.server.core.exception.ServerException;
import com.server.viewobject.HeartBeatView;

@Controller
@RequestMapping("/testHealth")
public class TestHealthController {
	
	public static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(30);

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
