package com.paobang.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paobang.dao.HeartBeatDao;
import com.paobang.service.HeartBeatService;

@Service
public class HeartBeatServiceImpl implements HeartBeatService{
	
	@Resource
	private HeartBeatDao heartBeatDao;

}
