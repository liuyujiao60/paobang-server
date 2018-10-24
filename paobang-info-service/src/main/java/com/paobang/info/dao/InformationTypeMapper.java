package com.paobang.info.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.paobang.info.contant.Contant;
import com.paobang.info.entity.InformationType;
import com.server.core.annotation.TargetDataSource;

@Mapper
@TargetDataSource(Contant.dbName)
public interface InformationTypeMapper {
	
	@Select("select * from information_type")
	public List<InformationType> getAllInformationTypeList();
	
	@Select("select * from information_type where id=#{id}")
	public InformationType getAllInformationTypeById(int id);

}
