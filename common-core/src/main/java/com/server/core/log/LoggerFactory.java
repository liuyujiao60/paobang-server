package com.server.core.log;

import org.slf4j.Logger;

public class LoggerFactory {
	
	private static final String QUESTION_SPIDER = "questionSpider";
	
	private static final String REQUEST_INFO = "requestInfo";
	
	public static Logger getQuestionSpider(Class<?> clazz) {
        return org.slf4j.LoggerFactory.getLogger(QUESTION_SPIDER);
    }
	
	public static Logger getRequestInfoLogger(Class<?> clazz) {
        return org.slf4j.LoggerFactory.getLogger(REQUEST_INFO);
    }

}
