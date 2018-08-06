package com.paobang.info.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.paobang.info.contant.InformationExceptionEnums;
import com.paobang.info.dao.InformationMapper;
import com.paobang.info.entity.Information;
import com.paobang.info.service.InformationAuthorService;
import com.paobang.info.service.InformationService;
import com.paobang.info.service.InformationTypeService;
import com.paobang.info.viewobject.InformationItemVo;
import com.paobang.info.viewobject.InformationTypeVo;
import com.server.core.common.IdGenarator;
import com.server.core.exception.ServerException;
import com.server.core.request.VZyPage;
import com.server.core.util.RelativeDateFormatUtil;

@Service
public class InformationServiceImpl implements InformationService{
	
	@Resource
	private InformationMapper informationMapper;
	@Resource
	private InformationAuthorService informationAuthorService;
	@Resource
	private InformationTypeService informationTypeService;

	@Override
	public Information addInformationByAdmin(Information information) {
		// TODO Auto-generated method stub
		if(information==null)
			throw new ServerException(InformationExceptionEnums.INFORMATION_PARAM_ERROR,null);
		if(StringUtils.isBlank(information.getAuthorName()))
			throw new ServerException(InformationExceptionEnums.INFORMATION_AUTHOR_EMPTY,null);
		information.setId(IdGenarator.getStringId());
		information.setCreateTime(System.currentTimeMillis());
		informationMapper.addInformation(information);
		return information;
	}

	@Override
	public List<InformationItemVo> getInformationListByStatusForPage(int status, VZyPage page) {
		// TODO Auto-generated method stub
		List<InformationItemVo> resultVoList=new ArrayList<InformationItemVo>();
		List<Information> informationList=new ArrayList<Information>();
		if(status==-1)
			informationList=informationMapper.getOfflineInformationForPage(page.getCurrent(), page.getPageSize());
		if(status==0)
			informationList=informationMapper.getStayOnlineInformationForPage(page.getCurrent(), page.getPageSize());
		if(status==1)
			informationList=informationMapper.getOnlineInformationForPage(page.getCurrent(), page.getPageSize());
		
		for(Information information:informationList){
			InformationItemVo informationItemVo=this.transInformationToInformationItemVo(information);
			resultVoList.add(informationItemVo);
		}
		
		return resultVoList;
	}

	@Override
	public List<InformationItemVo> getInformationListByStatusAndColumnIdForPage(String columnId, int status, VZyPage page) {
		// TODO Auto-generated method stub
		List<InformationItemVo> resultVoList=new ArrayList<InformationItemVo>();
		List<Information> informationList=new ArrayList<Information>();
		if(status==-1)
			informationList=informationMapper.getOfflineInformationByColumnIdForPage(columnId,page.getCurrent(), page.getPageSize());
		if(status==0)
			informationList=informationMapper.getStayOnlineInformationByColumnIdForPage(columnId,page.getCurrent(), page.getPageSize());
		if(status==1)
			informationList=informationMapper.getOnlineInformationByColumnIdForPage(columnId,page.getCurrent(), page.getPageSize());
		
		for(Information information:informationList){
			InformationItemVo informationItemVo=this.transInformationToInformationItemVo(information);
			resultVoList.add(informationItemVo);
		}
		
		return resultVoList;
	}

	@Override
	public List<InformationItemVo> getInformationListByStatusAndSubColumnIdForPage(String subColumnId, int status,
			VZyPage page) {
		// TODO Auto-generated method stub
		List<InformationItemVo> resultVoList=new ArrayList<InformationItemVo>();
		List<Information> informationList=new ArrayList<Information>();
		if(status==-1)
			informationList=informationMapper.getOfflineInformationBySubColumnIdForPage(subColumnId,page.getCurrent(), page.getPageSize());
		if(status==0)
			informationList=informationMapper.getStayOnlineInformationBySubColumnIdForPage(subColumnId,page.getCurrent(), page.getPageSize());
		if(status==1)
			informationList=informationMapper.getOnlineInformationBySubColumnIdForPage(subColumnId,page.getCurrent(), page.getPageSize());
		
		for(Information information:informationList){
			InformationItemVo informationItemVo=this.transInformationToInformationItemVo(information);
			resultVoList.add(informationItemVo);
		}
		
		return resultVoList;
	}

	@Override
	public Information updateInformationStatusByAdmin(String infoId, int status) {
		// TODO Auto-generated method stub
		int updateCount=informationMapper.updateInformationStatus(infoId, status);
		if(updateCount==0)
			throw new ServerException(InformationExceptionEnums.INFORMATION_NOT_EXIST,null);
		else
			return informationMapper.getInformationById(infoId);
	}
	
	private InformationItemVo transInformationToInformationItemVo(Information information){
		InformationItemVo informationItemVo=new InformationItemVo();
		informationItemVo.setId(information.getId());
		informationItemVo.setCoverImage(information.getCoverImage());
		informationItemVo.setShortTitle(information.getShortTitle());
		informationItemVo.setTitle(information.getTitle());
		informationItemVo.setFirstTag(StringUtils.isNotBlank(information.getTag())?information.getTag().split("|")[0]:null);
		informationItemVo.setCreateTime(RelativeDateFormatUtil.format(new Date(information.getCreateTime())));
		InformationTypeVo informationTypeVo=informationTypeService.getInformationTypeVoById(information.getInfoType());
		informationItemVo.setInformationType(informationTypeVo);
		return informationItemVo;
	}

}
