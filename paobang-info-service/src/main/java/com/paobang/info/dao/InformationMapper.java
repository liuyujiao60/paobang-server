package com.paobang.info.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.paobang.info.entity.Information;

@Mapper
public interface InformationMapper {
	
	final String itemColumnStr="id,infoType,coverImage,shortTitle,title,tag,createTime";
	
	final String insertColumnStr="id,infoType,coverImage,shortTitle,title,tag,columnId,subColumnId,authorId,authorName,content,createTime";
	
	@Insert("insert into information("+insertColumnStr+")"
			+ " values(#{information.id},#{information.infoType},#{information.coverImage},#{information.shortTitle},,#{information.title},"
			+ " #{information.tag},#{information.columnId},#{information.subColumnId},#{information.authorId},#{information.authorName},"
			+ " #{information.content},#{information.createTime})")
	public void addInformation(@Param("information")Information information);
	
	@Select("select "+itemColumnStr+" from information limit #{currentRow},#{pageSize}")
	public List<Information> getAllInformationForPage(@Param("currentRow")int currentRow,@Param("pageSize")int pageSize);
	
	@Select("select "+itemColumnStr+" from information "
			+ " where status=-1 limit #{currentRow},#{pageSize}")
	public List<Information> getOfflineInformationForPage(@Param("currentRow")int currentRow,@Param("pageSize")int pageSize);
	
	@Select("select "+itemColumnStr+" from information "
			+ " where status=0 limit #{currentRow},#{pageSize}")
	public List<Information> getStayOnlineInformationForPage(@Param("currentRow")int currentRow,@Param("pageSize")int pageSize);
	
	@Select("select "+itemColumnStr+" from information "
			+ " where status>0 order by status desc,createTime desc limit #{currentRow},#{pageSize}")
	public List<Information> getOnlineInformationForPage(@Param("currentRow")int currentRow,@Param("pageSize")int pageSize);
	
	@Select("select "+itemColumnStr+" from information"
			+ " where columnId=#{columnId} limit #{currentRow},#{pageSize}")
	public List<Information> getAllInformationByColumnIdForPage(@Param("columnId")String columnId,@Param("currentRow")int currentRow,@Param("pageSize")int pageSize);
	
	@Select("select "+itemColumnStr+" from information"
			+ " where status=-1 and columnId=#{columnId} limit #{currentRow},#{pageSize}")
	public List<Information> getOfflineInformationByColumnIdForPage(@Param("columnId")String columnId,@Param("currentRow")int currentRow,@Param("pageSize")int pageSize);
	
	@Select("select "+itemColumnStr+" from information"
			+ " where status=0 and columnId=#{columnId} limit #{currentRow},#{pageSize}")
	public List<Information> getStayOnlineInformationByColumnIdForPage(@Param("columnId")String columnId,@Param("currentRow")int currentRow,@Param("pageSize")int pageSize);
	
	@Select("select "+itemColumnStr+" from information"
			+ " where status>0 and columnId=#{columnId} order by status desc,createTime desc limit #{currentRow},#{pageSize}")
	public List<Information> getOnlineInformationByColumnIdForPage(@Param("columnId")String columnId,@Param("currentRow")int currentRow,@Param("pageSize")int pageSize);
	
	@Select("select "+itemColumnStr+" from information"
			+ " where subColumnId=#{subColumnId} limit #{currentRow},#{pageSize}")
	public List<Information> getAllInformationBySubColumnIdForPage(@Param("subColumnId")String subColumnId,@Param("currentRow")int currentRow,@Param("pageSize")int pageSize);
	
	@Select("select "+itemColumnStr+" from information"
			+ " where status=-1 and subColumnId=#{subColumnId} limit #{currentRow},#{pageSize}")
	public List<Information> getOfflineInformationBySubColumnIdForPage(@Param("subColumnId")String subColumnId,@Param("currentRow")int currentRow,@Param("pageSize")int pageSize);

	@Select("select "+itemColumnStr+" from information"
			+ " where status=0 subColumnId=#{subColumnId} limit #{currentRow},#{pageSize}")
	public List<Information> getStayOnlineInformationBySubColumnIdForPage(@Param("subColumnId")String subColumnId,@Param("currentRow")int currentRow,@Param("pageSize")int pageSize);

	@Select("select "+itemColumnStr+" from information"
			+ " where status>0 and subColumnId=#{subColumnId} order by status desc,createTime desc limit #{currentRow},#{pageSize}")
	public List<Information> getOnlineInformationBySubColumnIdForPage(@Param("subColumnId")String subColumnId,@Param("currentRow")int currentRow,@Param("pageSize")int pageSize);
	
	@Select("select * from information where id=#{id}")
	public Information getInformationById(@Param("id")String id);
	
	@Update("update information set status=#{status} where id=#{id}")
	public int updateInformationStatus(@Param("id")String id,@Param("status")int status);
}
