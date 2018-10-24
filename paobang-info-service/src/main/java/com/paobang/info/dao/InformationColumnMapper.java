package com.paobang.info.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.paobang.info.contant.Contant;
import com.paobang.info.entity.InformationColumn;
import com.server.core.annotation.TargetDataSource;

@Mapper
@TargetDataSource(Contant.dbName)
public interface InformationColumnMapper {
	
	final String totalColumnStr="id,code,name,coverImage,parentColumnId,type,tags,ordinal,createTime,lastUpdateTime,icon";
	
	final String insertColumnStr="code,name,coverImage,parentColumnId,type,tags,ordinal,createTime,lastUpdateTime,icon";
	
	@Select("select "+totalColumnStr+" from information_column where id=#{id}")
	public InformationColumn getInformationColumnById(@Param("id")int id);
	
	@Select("select "+totalColumnStr+" from information_column where parentColumnId=-1")
	public List<InformationColumn> getInformationColumnList();
	
	@Select("select "+totalColumnStr+" from information_column where parentColumnId=#{parentColumnId}")
	public List<InformationColumn> getInformationColumnListByParentId(@Param("parentColumnId")int parentColumnId);
	
	@Insert("insert into information_column("+insertColumnStr+") values(#{informationColumn.code},#{informationColumn.name},"
			+ "#{informationColumn.coverImage},#{informationColumn.parentColumnId},#{informationColumn.type},#{informationColumn.tags},"
			+ "#{informationColumn.ordinal},#{informationColumn.createTime},#{informationColumn.lastUpdateTime},#{informationColumn.icon})")
	public void insertInformationColumn(@Param("informationColumn")InformationColumn informationColumn);
	
	@Delete("delete from information_column where id=#{id}")
	public int deleteInformationColumnById(@Param("id")int id);
	
	@Delete("delete from information_column where parentColumnId=#{parentColumnId}")
	public int deleteInformationColumnByParentColumnId(@Param("parentColumnId")int parentColumnId);

}
