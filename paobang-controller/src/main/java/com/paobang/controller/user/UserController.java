package com.paobang.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paobang.user.service.UserService;
import com.paobang.user.viewobject.UserBasicInfoVo;
import com.server.core.exception.DBExceptionEnums;
import com.server.core.exception.ServerException;
import com.server.core.request.RequestEntity;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/accountExistCheck")
	public Object accountExistCheck(@RequestBody RequestEntity<UserBasicInfoVo> commonRequestEntity){
		boolean result=userService.accountExistCheck(commonRequestEntity.getData());
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/mobileExistCheck")
	public Object mobileExistCheck(@RequestBody RequestEntity<UserBasicInfoVo> commonRequestEntity){
		boolean result=userService.mobileExistCheck(commonRequestEntity.getData());
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/userRegist")
	public Object userRegist(@RequestBody RequestEntity<UserBasicInfoVo> commonRequestEntity){
		UserBasicInfoVo userBasicInfoVo=userService.userRegist(commonRequestEntity.getData());
		return userBasicInfoVo;
	}
	
	@ResponseBody
	@RequestMapping("/userLogin")
	public Object userLogin(@RequestBody RequestEntity<UserBasicInfoVo> commonRequestEntity){
		UserBasicInfoVo userBasicInfoVo=userService.userLogin(commonRequestEntity.getData());
		return userBasicInfoVo;
	}
	
	@ResponseBody
	@RequestMapping("/adminLogin")
	public Object adminLogin(@RequestBody RequestEntity<UserBasicInfoVo> commonRequestEntity){
		UserBasicInfoVo userBasicInfoVo=userService.userLogin(commonRequestEntity.getData());
		if(userBasicInfoVo.getRoleType()!=2)
			throw new ServerException(DBExceptionEnums.USER_NOT_EXIST,null);
		return userBasicInfoVo;
	}
}
