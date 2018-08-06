package com.paobang.info.service;

import java.util.List;

import com.paobang.info.entity.Information;
import com.paobang.info.viewobject.InformationItemVo;
import com.server.core.request.VZyPage;

public interface InformationService {
	
	public Information addInformationByAdmin(Information information);
	
	public List<InformationItemVo> getInformationListByStatusForPage(int status,VZyPage page);
	
	public List<InformationItemVo> getInformationListByStatusAndColumnIdForPage(String columnId,int status,VZyPage page);

	public List<InformationItemVo> getInformationListByStatusAndSubColumnIdForPage(String subColumnId,int status,VZyPage page);
	
	public Information updateInformationStatusByAdmin(String infoId,int status);
}
