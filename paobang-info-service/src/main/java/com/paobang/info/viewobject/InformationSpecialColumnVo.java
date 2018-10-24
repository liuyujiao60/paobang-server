package com.paobang.info.viewobject;

import java.util.List;

import com.paobang.info.entity.InformationColumn;

public class InformationSpecialColumnVo {
	
	private int id;
	private String code;
	private String name;
	private String coverImage;
	private String icon;
	private InformationSpecialColumnVo parentSpecialColumnVo;
	private List<InformationSpecialColumnVo> childrenInformationColumnVoList;
	
	public InformationSpecialColumnVo(){}
	
	public InformationSpecialColumnVo(InformationColumn informationColumn){
		this.id=informationColumn.getId();
		this.code=informationColumn.getCode();
		this.name=informationColumn.getName();
		this.coverImage=informationColumn.getCoverImage();
		this.icon=informationColumn.getIcon();
		this.parentSpecialColumnVo=new InformationSpecialColumnVo();
		parentSpecialColumnVo.setId(informationColumn.getParentColumnId());
	}
	
	public InformationSpecialColumnVo(InformationColumn parentInformationColumn,InformationColumn informationColumn){
		this.id=informationColumn.getId();
		this.code=informationColumn.getCode();
		this.name=informationColumn.getName();
		this.coverImage=informationColumn.getCoverImage();
		this.icon=informationColumn.getIcon();
		this.parentSpecialColumnVo=new InformationSpecialColumnVo(parentInformationColumn);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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

	public List<InformationSpecialColumnVo> getChildrenInformationColumnVoList() {
		return childrenInformationColumnVoList;
	}

	public void setChildrenInformationColumnVoList(List<InformationSpecialColumnVo> childrenInformationColumnVoList) {
		this.childrenInformationColumnVoList = childrenInformationColumnVoList;
	}
}
