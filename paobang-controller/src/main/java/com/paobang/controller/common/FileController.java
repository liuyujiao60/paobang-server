package com.paobang.controller.common;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.server.component.ueditor.ActionEnter;
import com.server.core.common.OSSUtil;
import com.server.core.exception.DBExceptionEnums;
import com.server.core.exception.ServerException;
import com.server.core.util.DateUtil;

@Controller
@RequestMapping("/file")
public class FileController {
	
	@ResponseBody
	@RequestMapping("/uploadFile")
	public Object uploadFile(@RequestParam("file") MultipartFile file){
		try {    
        	String date=DateUtil.getStringDayByDate(new Date());
        	String fileName=UUID.randomUUID().toString()+"."+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        	String fileUrl=OSSUtil.putObject("xiangduke", date+"/"+fileName, file.getInputStream());
//        	String md5Code=DigestUtils.md5Hex(file.getInputStream());
//        	System.out.println(md5Code);
        	JSONObject result=new JSONObject();
        	result.put("url",fileUrl);
            return result;
        } catch (Exception e) {    
            throw new ServerException(DBExceptionEnums.FILE_UPLOAD_ERROR,null);
        }
	}
	
	@ResponseBody
	@RequestMapping("/ueditor")
	public Object uploadFile(HttpServletRequest request){
		String result=new ActionEnter(request, request.getSession().getServletContext().getRealPath("/")).exec();
		return result;
	}
}
