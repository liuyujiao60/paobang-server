package com.paobang.info.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paobang.info.dao.InformationTypeMapper;
import com.paobang.info.entity.InformationType;
import com.paobang.info.service.InformationTypeService;
import com.paobang.info.viewobject.InformationTypeVo;

@Service
public class InformationTypeServiceImpl implements InformationTypeService {
	@Resource
	private InformationTypeMapper informationTypeMapper;
	
	@Override
	public InformationTypeVo getInformationTypeVoById(int id) {
		// TODO Auto-generated method stub
		InformationType InformationType=informationTypeMapper.getAllInformationTypeById(id);
		return new InformationTypeVo(InformationType);
	}

}
