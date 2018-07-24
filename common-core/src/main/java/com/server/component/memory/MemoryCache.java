package com.server.component.memory;

import com.alibaba.fastjson.JSONObject;

public class MemoryCache {
	
	private static JSONObject memoryCache=new JSONObject();

	public static void putObject(String key,Object obj,Integer expireSeconds){
		memoryCache.put(key, obj);
		if(expireSeconds!=null&&expireSeconds>0)
			memoryCache.put(key+"_outTime", System.currentTimeMillis()+expireSeconds*1000);
	}
	
	public static Object getObject(String key){
		if(memoryCache.containsKey(key)){
			long expireTime=memoryCache.getLong(key+"_outTime");
			if(expireTime<System.currentTimeMillis()){
				return null;
			}else{
				return memoryCache.get(key);
			}
		}
		return null;
	}
}
