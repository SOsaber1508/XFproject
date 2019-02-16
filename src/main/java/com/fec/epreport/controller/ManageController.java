package com.fec.epreport.controller;


import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping(value = "/admin")
public class ManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(ManageController.class);

	//首页
	   @RequestMapping(value = "/welcome.htm", method = RequestMethod.GET)
	   public String welcome( )
	   {
		 return "manage/welcome";  
	   }
}
