package com.fec.epreport.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping(value = "/demo")
public class DemoController {
	private static Logger logger = LoggerFactory.getLogger(DemoController.class);
	private int  pageSize=10;//每页显示记录数
	
	
	@RequestMapping({ "/demo.htm" })
	public String selectallManage(Model model,String MSG,@RequestParam(defaultValue="1",required=true,value="pageNo") int pageNo) 
	{
		try {
			//分页插件
			PageHelper.startPage(pageNo, pageSize);
			//拦截写入新的查询 暂定10条每页查
			//downloadManage =downloadService.selectall();
			//PageInfo<DownloadManage> asdasdad=new PageInfo<DownloadManage>(downloadManage);
			//model.addAttribute("downlist", pageInfo);
			//model.addAttribute("asdadasdsasd", asdasdad);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询失败：失败原因+"+e.getLocalizedMessage());
		}
		logger.debug("leave /admin/download_center.htm");
		return "download_manage";
}
}
