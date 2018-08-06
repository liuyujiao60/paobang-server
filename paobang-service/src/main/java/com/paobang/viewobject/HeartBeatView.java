package com.paobang.viewobject;

public class HeartBeatView {
	
	private long currentTime;
	
	public HeartBeatView(){
		this.currentTime=System.currentTimeMillis();
	}

	public long getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(long currentTime) {
		this.currentTime = currentTime;
	}

}
