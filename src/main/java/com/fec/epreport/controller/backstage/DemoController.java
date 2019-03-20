package com.fec.epreport.controller.backstage;

import com.fec.epreport.entity.Users;
import com.fec.epreport.service.ManageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/demo")
public class DemoController {
	private static Logger logger = LoggerFactory.getLogger(DemoController.class);
	private int  pageSize=10;//每页显示记录数
	@Autowired
	ManageService manageService;
	@ResponseBody
	@RequestMapping("/demo.htm")
	public PageInfo<Users> selectallManage(Model model, String excelMsg, @RequestParam(defaultValue="1",required=true,value="pageNo") int pageNo) {
		PageInfo<Users> pageInfo=null;
		try {
			//分页插件
			PageHelper.startPage(pageNo, pageSize);
			//拦截写入新的查询 暂定10条每页查
			List<Users> list = manageService.selectAllusers();
			pageInfo=new PageInfo<>(list);
//			model.addAttribute("downlist", pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询失败：失败原因+"+e.getLocalizedMessage());
		}
		logger.debug("leave/admin/download_center.htm");
		return pageInfo;
	}
}
