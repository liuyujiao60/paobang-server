package com.study.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;

public class AccountRecordHandlerProxy implements InvocationHandler{
	
	private Object target;
	
	public Object bind(Object target){
		this.target=target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object result=null;
		result=method.invoke(this.target, args);
		return result;
	}
	
	public static void main(String[] args) {
		AccountRecordHandler accountRecordHandler=(AccountRecordHandler) new AccountRecordHandlerProxy()
				.bind(new AccountRecordHandlerImpl());
		
		AccountRecord record=accountRecordHandler.queryAccount("acdb");
		System.out.println(accountRecordHandler.getClass());
		System.out.println(3/2);
		System.out.println(16>>>3/2);
		System.out.println(Integer.toBinaryString(15<<1));
		System.out.println(15>>1);
		StringBuilder sb=new StringBuilder();
		new ConcurrentHashMap();
		record.display();
	}

}
