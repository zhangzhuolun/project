package com.nq.sch_oa.function.controller.organization;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nq.sch_oa.function.controller.organization.OrganizationController;
import com.nq.sch_oa.function.service.organization.OrganizationService;

/**
 * 组织管理
 * 
 * @author 张卓伦
 * @date 2015年5月9日
 * @version 1.0
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController {
	
	private static final Logger logger = Logger.getLogger(OrganizationController.class);
	private static final int pageSize = 10;
	
	@Resource(name = "organizationServiceImpl")
	private OrganizationService	service;
	
	public final ObjectMapper mapper = new ObjectMapper(); 
	
	@RequestMapping("/list")
	public String organizationList(String error,Model model) {
		logger.info("---->>>OrganizationController.organizationList");
		try {
			List<?> result = service.getListData(0,pageSize);
			long total = service.getListCount();
			model.addAttribute("result", mapper.writeValueAsString(result));
			model.addAttribute("pageNo", 1);
			model.addAttribute("pageTotal", (int) Math.ceil((double) total/(double) pageSize));
			model.addAttribute("pageSize", pageSize);
			model.addAttribute("recordTotal", total);
			model.addAttribute("total", total);
		}catch (Exception e) {
			logger.error(e);
		} 
		logger.info("----<<<OrganizationController.organizationList");
		return "organization/index";
	}
}
