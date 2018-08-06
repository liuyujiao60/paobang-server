package com.paobang.user.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.paobang.user.entity.UserBasicInfo;

@Mapper
public interface UserBasicInfoMapper {
	
	@Insert("insert into user_basic_info(id,account,password,nickname,mobile,sex,birthday,regionCode,headImage,registTime,registType) "
			+ "values(#{userBasicInfo.id},#{userBasicInfo.account},#{userBasicInfo.password},#{userBasicInfo.nickname},#{userBasicInfo.mobile},"
			+ "#{userBasicInfo.sex},#{userBasicInfo.birthday},#{userBasicInfo.regionCode},#{userBasicInfo.headImage},#{userBasicInfo.registTime},"
			+ "#{userBasicInfo.registType})")
	public void addUserBasicInfo(@Param("userBasicInfo")UserBasicInfo userBasicInfo);
	
	@Select("select count(1) from user_basic_info where account=#{account}")
	public Integer getUserBasicInfoCountByAccount(@Param("account")String account);
	
	@Select("select count(1) from user_basic_info where mobile=#{mobile}")
	public Integer getUserBasicInfoCountByMobile(@Param("mobile")String mobile);
	
	@Select("select * from user_basic_info where (account=#{account} or mobile=#{account}) and password=#{password}")
	public UserBasicInfo getUserBasicInfoByAccountAndPassword(@Param("account")String account,@Param("password")String password);

	@Update("update user_basic_info set nickname=#{userBasicInfo.nickname},sex=#{userBasicInfo.sex},mobile=#{userBasicInfo.mobile},"
			+ "birthday=#{userBasicInfo.birthday},regionCode=#{userBasicInfo.regionCode},headImage=#{userBasicInfo.headImage} "
			+ " where id=#{userBasicInfo.id}")
	public Integer modifyUserBasicInfo(@Param("userBasicInfo")UserBasicInfo userBasicInfo);
	
	@Select("select * from user_basic_info where id=#{id}")
	public UserBasicInfo getUserBasicInfoById(@Param("id")String id);
	
	@Update("update user_basic_info set lastLoginTime=#{lastLoginTime} where id=#{id}")
	public Integer updateUserLastLoginTime(@Param("id")String id,@Param("lastLoginTime")long lastLoginTime);
}
