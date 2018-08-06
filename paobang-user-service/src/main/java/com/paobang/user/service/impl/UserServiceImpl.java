package com.paobang.user.service.impl;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.paobang.user.contant.RedisContant;
import com.paobang.user.dao.UserBasicInfoMapper;
import com.paobang.user.entity.UserBasicInfo;
import com.paobang.user.service.UserService;
import com.paobang.user.viewobject.UserBasicInfoVo;
import com.server.component.redis.impl.RedisComponent;
import com.server.core.common.IdGenarator;
import com.server.core.exception.DBExceptionEnums;
import com.server.core.exception.ServerException;
import com.server.core.util.UrlUtil;

@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	private RedisComponent redisComponent;
	
	@Resource
	private UserBasicInfoMapper userBasicInfoMapper;
	
	@Override
	public boolean accountExistCheck(UserBasicInfoVo userVo) {
		// TODO Auto-generated method stub
		Integer accountCount=userBasicInfoMapper.getUserBasicInfoCountByAccount(userVo.getAccount());
		return accountCount>0||StringUtils.isEmpty(userVo.getAccount())||userVo.getAccount().length()<8;
	}
	
	@Override
	public boolean mobileExistCheck(UserBasicInfoVo userVo) {
		// TODO Auto-generated method stub
		Integer mobileCount=userBasicInfoMapper.getUserBasicInfoCountByMobile(userVo.getMobile());
		return mobileCount>0||userVo.getMobile().length()!=11;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED, readOnly = false)
	public UserBasicInfoVo userRegist(UserBasicInfoVo userVo) {
		// TODO Auto-generated method stub
		if(this.accountExistCheck(userVo))
			throw new ServerException(DBExceptionEnums.ACCOUNT_IS_EXIST,null);
		if(this.mobileExistCheck(userVo))
			throw new ServerException(DBExceptionEnums.MOBILE_IS_EXIST,null);
		
		try{
			UserBasicInfo userBasicInfo=this.transUserBasicInfoVoToModel(userVo);
			userBasicInfo.setHeadImage(UrlUtil.removeUrlDomain(userBasicInfo.getHeadImage()));
			userBasicInfo.setId(IdGenarator.getStringId());
			userBasicInfo.setRegistTime(System.currentTimeMillis());
			userBasicInfoMapper.addUserBasicInfo(userBasicInfo);
			userVo.setUserId(userBasicInfo.getId());
			return userVo;
		}catch(Exception e){
			throw new ServerException(DBExceptionEnums.REGIST_ERROR,e);
		}
	}

	@Override
	public UserBasicInfoVo userLogin(UserBasicInfoVo userVo) {
		// TODO Auto-generated method stub
		UserBasicInfo userBasicInfo=userBasicInfoMapper.getUserBasicInfoByAccountAndPassword(userVo.getAccount(), userVo.getPassword());
		if(userBasicInfo==null)
			throw new ServerException(DBExceptionEnums.USER_NOT_EXIST,null);
		else{
			redisComponent.set(String.format(RedisContant.USER_BASIC_INFO, userBasicInfo.getId()), userBasicInfo,24*60*60);
			userBasicInfoMapper.updateUserLastLoginTime(userBasicInfo.getId(), System.currentTimeMillis());
			return this.transUserBasicInfoToVo(userBasicInfo);
		}
	}

	@Override
	public UserBasicInfoVo modifyUserBasicInfo(UserBasicInfoVo userVo) {
		// TODO Auto-generated method stub
		UserBasicInfo userBasicInfo=this.transUserBasicInfoVoToModel(userVo);
		Integer updateCount=userBasicInfoMapper.modifyUserBasicInfo(userBasicInfo);
		if(updateCount!=1)
			throw new ServerException(DBExceptionEnums.MODIFY_USER_ERROR,null);
		else{
			redisComponent.del(String.format(RedisContant.USER_BASIC_INFO, userVo.getUserId()));
			return userVo;
		}
	}
	
	public UserBasicInfoVo getUserBasicInfoVoById(String userId){
		UserBasicInfo userBasicInfo=redisComponent.get(String.format(RedisContant.USER_BASIC_INFO, userId),new UserBasicInfo());
		if(userBasicInfo==null)
			userBasicInfo=userBasicInfoMapper.getUserBasicInfoById(userId);
		return this.transUserBasicInfoToVo(userBasicInfo);
	}
	
	private UserBasicInfo transUserBasicInfoVoToModel(UserBasicInfoVo userBasicInfoVo){
		UserBasicInfo userBasicInfo=new UserBasicInfo();
		userBasicInfo.setId(userBasicInfoVo.getUserId());
		userBasicInfo.setAccount(userBasicInfoVo.getAccount());
		userBasicInfo.setPassword(userBasicInfoVo.getPassword());
		userBasicInfo.setMobile(userBasicInfoVo.getMobile());
		userBasicInfo.setNickname(userBasicInfoVo.getNickname());
		userBasicInfo.setHeadImage(userBasicInfoVo.getHeadImage());
		userBasicInfo.setBirthday(userBasicInfoVo.getBirthday());
		userBasicInfo.setRegionCode(userBasicInfoVo.getRegionCode());
		userBasicInfo.setSex(userBasicInfoVo.getSex());
		return userBasicInfo;
	}
	
	private UserBasicInfoVo transUserBasicInfoToVo(UserBasicInfo userBasicInfo){
		UserBasicInfoVo userBasicInfoVo=new UserBasicInfoVo();
		userBasicInfoVo.setUserId(userBasicInfo.getId());
		userBasicInfoVo.setNickname(userBasicInfo.getNickname());
		userBasicInfoVo.setHeadImage(userBasicInfo.getHeadImage());
		userBasicInfoVo.setSex(userBasicInfo.getSex());
		return userBasicInfoVo;
	}

}
