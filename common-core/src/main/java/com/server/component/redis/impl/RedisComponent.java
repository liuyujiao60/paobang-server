package com.server.component.redis.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.server.component.redis.RedisSuper;
import com.server.core.common.SerializeUtil;

import redis.clients.jedis.Jedis;

@Component
public class RedisComponent extends RedisSuper {
	
	private final static String nxxx="XX";
	
	private final static String expx="EX";
	
	public <T> void set(String key,T t,Integer expireTime){
		this.set(key, SerializeUtil.serializeObject(t), expireTime);
	}
	
	public void set(String key,String value,Integer expireTime){
		Jedis jedis=this.getResource(key);
		if(value!=null){
			if(expireTime!=null&&expireTime>0)
				jedis.set(key, value, nxxx, expx, expireTime);
			else
				jedis.set(key, value);
		}
	}
	
	public String get(String key){
		Jedis jedis=this.getResource(key);
		return jedis.get(key);
	}
	
	public <T> T get(String key,T t){
		String value=this.get(key);
		if(StringUtils.isNotEmpty(value))
			return (T) SerializeUtil.deserializeObject(value, t);
		else
			return null;
	}
	
	public void del(String key){
		Jedis jedis=this.getResource(key);
		jedis.del(key);
	}
}
