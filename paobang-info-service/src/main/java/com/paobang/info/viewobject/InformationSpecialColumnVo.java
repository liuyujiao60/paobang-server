package com.paobang.info.viewobject;

public class InformationSpecialColumnVo {
	
	private String id;
	private String code;
	private String name;
	private String coverImage;
	private String icon;
	private InformationSpecialColumnVo parentSpecialColumnVo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCoverImage() {
		return coverImage;
	}
	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public InformationSpecialColumnVo getParentSpecialColumnVo() {
		return parentSpecialColumnVo;
	}
	public void setParentSpecialColumnVo(InformationSpecialColumnVo parentSpecialColumnVo) {
		this.parentSpecialColumnVo = parentSpecialColumnVo;
	}
}
