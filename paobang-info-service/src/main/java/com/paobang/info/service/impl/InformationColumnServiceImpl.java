package com.paobang.info.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paobang.info.contant.InformationExceptionEnums;
import com.paobang.info.dao.InformationColumnMapper;
import com.paobang.info.entity.InformationColumn;
import com.paobang.info.service.InformationColumnService;
import com.paobang.info.viewobject.InformationSpecialColumnVo;
import com.server.core.exception.ServerException;

@Service
public class InformationColumnServiceImpl implements InformationColumnService{
	
	@Resource
	private InformationColumnMapper informationColumnMapper;

	@Override
	public void addInformationColumn(InformationColumn informationColumn) {
		// TODO Auto-generated method stub
		informationColumn.setCreateTime(System.currentTimeMillis());
		informationColumn.setLastUpdateTime(System.currentTimeMillis());
		informationColumnMapper.insertInformationColumn(informationColumn);
	}

	@Override
	public List<InformationSpecialColumnVo> getInformationColumnList() {
		// TODO Auto-generated method stub
		List<InformationSpecialColumnVo> resultList=new ArrayList<InformationSpecialColumnVo>();
		List<InformationColumn> informationColumnList=informationColumnMapper.getInformationColumnList();
		for(InformationColumn informationColumn:informationColumnList){
			resultList.add(new InformationSpecialColumnVo(informationColumn));
		}
		return resultList;
	}

	@Override
	public List<InformationSpecialColumnVo> getInformationColumnListByParentColumnId(int parentColumnId) {
		// TODO Auto-generated method stub
		InformationColumn parentInformationColumn=informationColumnMapper.getInformationColumnById(parentColumnId);
		if(parentInformationColumn==null)
			throw new ServerException(InformationExceptionEnums.INFORMATION_COLUMN_NOT_EXIST,null);
		List<InformationSpecialColumnVo> resultList=new ArrayList<InformationSpecialColumnVo>();
		List<InformationColumn> informationColumnList=informationColumnMapper.getInformationColumnList();
		for(InformationColumn informationColumn:informationColumnList){
			resultList.add(new InformationSpecialColumnVo(parentInformationColumn,informationColumn));
		}
		return resultList;
	}

	@Override
	public void deleteInformationColumnById(int columnId) {
		// TODO Auto-generated method stub
		int deleteCount=informationColumnMapper.deleteInformationColumnById(columnId);
		if(deleteCount==0)
			throw new ServerException(InformationExceptionEnums.INFORMATION_COLUMN_NOT_EXIST,null);
	}

	@Override
	public void deleteInformationColumnByParentColumnId(int parentColumnId) {
		// TODO Auto-generated method stub
		int deleteCount=informationColumnMapper.deleteInformationColumnByParentColumnId(parentColumnId);
		if(deleteCount==0)
			throw new ServerException(InformationExceptionEnums.INFORMATION_COLUMN_NOT_EXIST,null);
	}

	@Override
	public List<InformationSpecialColumnVo> getAllInformationColumn() {
		// TODO Auto-generated method stub
		List<InformationSpecialColumnVo> resultList=this.getInformationColumnList();
		for(InformationSpecialColumnVo informationSpecialColumnVo:resultList){
			List<InformationSpecialColumnVo> childrenInformationColumnVoList=this.getAllChildInformationColumnList(informationSpecialColumnVo.getId());
			informationSpecialColumnVo.setChildrenInformationColumnVoList(childrenInformationColumnVoList);
		}
		return resultList;
	}
	
	private List<InformationSpecialColumnVo> getAllChildInformationColumnList(int parentColumnId){
		InformationColumn parentInformationColumn=informationColumnMapper.getInformationColumnById(parentColumnId);
		if(parentInformationColumn==null)
			throw new ServerException(InformationExceptionEnums.INFORMATION_COLUMN_NOT_EXIST,null);
		List<InformationSpecialColumnVo> resultList=new ArrayList<InformationSpecialColumnVo>();
		List<InformationColumn> informationColumnList=informationColumnMapper.getInformationColumnListByParentId(parentColumnId);
		if(informationColumnList!=null){
			for(InformationColumn informationColumn:informationColumnList){
				InformationSpecialColumnVo tempInformationSpecialColumnVo=new InformationSpecialColumnVo(parentInformationColumn,informationColumn);
				List<InformationSpecialColumnVo> childrenInformationColumnVoList=this.getAllChildInformationColumnList(tempInformationSpecialColumnVo.getId());
				tempInformationSpecialColumnVo.setChildrenInformationColumnVoList(childrenInformationColumnVoList);
				resultList.add(tempInformationSpecialColumnVo);
			}
		}
		return resultList;
	}

	@Override
	public InformationSpecialColumnVo getInformationColumnById(int columnId) {
		// TODO Auto-generated method stub
		InformationColumn informationColumn=informationColumnMapper.getInformationColumnById(columnId);
		if(informationColumn==null)
			throw new ServerException(InformationExceptionEnums.INFORMATION_COLUMN_NOT_EXIST,null);
		return new InformationSpecialColumnVo(informationColumn);
	}

}
