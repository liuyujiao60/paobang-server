package com.server.core.util;

public class UrlUtil {
	
	public static String removeUrlDomain(String url){
		url=url.replace("http://", "");
		return url.substring(url.indexOf("/"));
	}

}
