package com.study.designpattern.proxy;

public class AccountRecord {
	
	private String userId;
	private Long money;
	
	public AccountRecord(String userId,Long money){
		this.userId=userId;
		this.money=money;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getMoney() {
		return money;
	}

	public void setMoney(Long money) {
		this.money = money;
	}
	
	public void display(){
		System.out.println(this.userId+" : "+this.money);
	}

}
