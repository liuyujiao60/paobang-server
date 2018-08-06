package com.paobang.info.viewobject;

public class InformationDetailVo {
	
	private String id;
	private String title;
	private InformationAuthorVo informationAuthorVo;
	private String content;
	private String[] tagArray;
	private long createTime;
	private InformationSpecialColumnVo subSpecialColumnVo;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public InformationAuthorVo getInformationAuthorVo() {
		return informationAuthorVo;
	}
	public void setInformationAuthorVo(InformationAuthorVo informationAuthorVo) {
		this.informationAuthorVo = informationAuthorVo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String[] getTagArray() {
		return tagArray;
	}
	public void setTagArray(String[] tagArray) {
		this.tagArray = tagArray;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public InformationSpecialColumnVo getSubSpecialColumnVo() {
		return subSpecialColumnVo;
	}
	public void setSubSpecialColumnVo(InformationSpecialColumnVo subSpecialColumnVo) {
		this.subSpecialColumnVo = subSpecialColumnVo;
	}
}
