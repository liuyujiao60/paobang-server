package com.study.designpattern.proxy;

import java.util.Random;

public class AccountRecordHandlerImpl implements AccountRecordHandler{

	@Override
	public AccountRecord queryAccount(String userId) {
		// TODO Auto-generated method stub
		return new AccountRecord(userId,new Random().nextLong());
	}

}
