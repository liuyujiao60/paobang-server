package com.paobang.info.service;

import java.util.List;

import com.paobang.info.entity.InformationColumn;
import com.paobang.info.viewobject.InformationSpecialColumnVo;

public interface InformationColumnService {
	
	public void addInformationColumn(InformationColumn informationColumn);
	
	public InformationSpecialColumnVo getInformationColumnById(int columnId);
	
	public List<InformationSpecialColumnVo> getInformationColumnList();
	
	public List<InformationSpecialColumnVo> getInformationColumnListByParentColumnId(int parentColumnId);
	
	public void deleteInformationColumnById(int columnId);
	
	public void deleteInformationColumnByParentColumnId(int parentColumnId);
	
	public List<InformationSpecialColumnVo> getAllInformationColumn();

}
