package com.paobang.controller.information;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paobang.info.entity.Information;
import com.paobang.info.service.InformationService;
import com.paobang.info.viewobject.InformationItemVo;
import com.server.core.request.RequestEntity;
import com.server.core.request.VZyPage;

@Controller
@RequestMapping("/information")
public class InformationController {
	
	@Resource
	private InformationService informationService;
	
	@ResponseBody
	@RequestMapping("/insertInformation")
	public Object insertInformation(@RequestBody RequestEntity<Information> commonRequestEntity){
		
		Information information=informationService.addInformationByAdmin(commonRequestEntity.getData());
		
		return information;
	}
	
	@ResponseBody
	@RequestMapping("/getInformationListByStatusForPage")
	public Object getInformationListByStatusForPage(@RequestBody RequestEntity<Information> commonRequestEntity){
		List<InformationItemVo> resultList=informationService.getInformationListByStatusForPage(commonRequestEntity.getData().getStatus(),
				new VZyPage(commonRequestEntity.getPageIndex(),commonRequestEntity.getPageSize()));
		return resultList;
	}
	
	@ResponseBody
	@RequestMapping("/updateInformationStatusByAdmin")
	public Object updateInformationStatusByAdmin(@RequestBody RequestEntity<Information> commonRequestEntity){
		Information information=informationService.updateInformationStatusByAdmin(commonRequestEntity.getData().getId(),
				commonRequestEntity.getData().getStatus());
		return information;
	}

}
