package com.paobang.user.entity;

public class UserBasicInfo {
	private String id;
	private String account;
	private String password;
	private String nickname;
	private String mobile;
	private Integer sex;
	private String birthday;
	private String regionCode;
	private String headImage;
	private Long registTime;
	private Integer registType;
	private Long lastLoginTime;
	
	public Long getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public String getHeadImage() {
		return headImage;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	public Long getRegistTime() {
		return registTime;
	}
	public void setRegistTime(Long registTime) {
		this.registTime = registTime;
	}
	public Integer getRegistType() {
		return registType;
	}
	public void setRegistType(Integer registType) {
		this.registType = registType;
	}

}
