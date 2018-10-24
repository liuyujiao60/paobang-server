package com.paobang.info.viewobject;

public class InformationItemVo {
	
	private String id;
	private String shortTitle;
	private String title;
	private String coverImage;
	private String firstTag;
	private InformationTypeVo informationType;
	private InformationSpecialColumnVo informationColumn;
	private int status;
	private String createTime;
	
	public InformationItemVo(){}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getShortTitle() {
		return shortTitle;
	}
	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCoverImage() {
		return coverImage;
	}
	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}
	public InformationTypeVo getInformationType() {
		return informationType;
	}
	public void setInformationType(InformationTypeVo informationType) {
		this.informationType = informationType;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getFirstTag() {
		return firstTag;
	}

	public void setFirstTag(String firstTag) {
		this.firstTag = firstTag;
	}

	public InformationSpecialColumnVo getInformationColumn() {
		return informationColumn;
	}

	public void setInformationColumn(InformationSpecialColumnVo informationColumn) {
		this.informationColumn = informationColumn;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
