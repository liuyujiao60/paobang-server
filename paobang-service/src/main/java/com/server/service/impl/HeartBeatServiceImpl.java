package com.server.service.impl;

import javax.annotation.Resource;

import com.server.dao.HeartBeatDao;
import com.server.service.HeartBeatService;

public class HeartBeatServiceImpl implements HeartBeatService{
	
	@Resource
	private HeartBeatDao heartBeatDao;

}
