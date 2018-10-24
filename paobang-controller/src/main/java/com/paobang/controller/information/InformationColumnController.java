package com.paobang.controller.information;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paobang.info.entity.InformationColumn;
import com.paobang.info.service.InformationColumnService;
import com.paobang.info.viewobject.InformationSpecialColumnVo;
import com.server.core.request.RequestEntity;

@Controller
@RequestMapping("/informationColumn")
public class InformationColumnController {
	
	@Resource
	private InformationColumnService informationColumnService;
	
	@ResponseBody
	@RequestMapping("/addInformationColumn")
	public Object addInformationColumn(@RequestBody RequestEntity<InformationColumn> commonRequestEntity){
		informationColumnService.addInformationColumn(commonRequestEntity.getData());
		return null;
	}
	
	@ResponseBody
	@RequestMapping("/getAllInformationColumn")
	public Object getAllInformationColumn(@RequestBody RequestEntity<Object> commonRequestEntity){
		List<InformationSpecialColumnVo> resultList= informationColumnService.getAllInformationColumn();
		return resultList;
	}

}
