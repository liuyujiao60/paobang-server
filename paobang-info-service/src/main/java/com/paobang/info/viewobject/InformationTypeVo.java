package com.paobang.info.viewobject;

import com.paobang.info.entity.InformationType;

public class InformationTypeVo {
	
	private int id;
	private String name;
	private String icon;
	
	public InformationTypeVo(){}
	
	public InformationTypeVo(InformationType informationType){
		this.id=informationType.getId();
		this.name=informationType.getName();
		this.icon=informationType.getIcon();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}

}
