package com.fec.epreport.controller;


import com.fec.epreport.service.ManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;

@Controller
@RequestMapping(value = "/admin")
public class ManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(ManageController.class);
	@Autowired
	ManageService manageService;

	/**
	 * zcy
	 * 2019年2月18日09:55:59
	 * @return
	 */
	   @RequestMapping(value = "/welcome.htm", method = RequestMethod.GET)
	   public String welcome( )
	   {
		 return "manage/welcome";  
	   }
	   /**
		 * zcy
		 * 2019年2月18日09:55:59
		 * @return
		 */
	   @RequestMapping(value = "/components.htm", method = RequestMethod.GET)
	   public String components( )
	   {
		 return "manage/components";  
	   }
	   /**
		 * zcy
		 * 2019年2月18日09:55:59
		 * @return
		 */
	   @RequestMapping(value = "/forms.htm", method = RequestMethod.GET)
	   public String forms( )
	   {
		 return "manage/forms";  
	   }
	   /**
		 * zcy
		 * 2019年2月18日09:55:59
		 * @return
		 */
	   @RequestMapping(value = "/icons.htm", method = RequestMethod.GET)
	   public String icons( )
	   {
		 return "manage/icons";  
	   }
	   /**
		 * zcy
		 * 2019年2月18日09:55:59
		 * @return
		 */
	   @RequestMapping(value = "/notifications.htm", method = RequestMethod.GET)
	   public String notifications( )
	   {
		 return "manage/notifications";  
	   }
	   /**
		 * zcy
		 * 2019年2月18日09:55:59
		 * @return
		 */
	   @RequestMapping(value = "/tables.htm", method = RequestMethod.GET)
	   public String tables( )
	   {
		 return "manage/tables";  
	   }
	   /**
			 * zcy
			 * 2019年2月18日09:55:59
			 * @return
			 */
		   @RequestMapping(value = "/typography.htm", method = RequestMethod.GET)
		   public String typography( )
		   {
			 return "manage/typography";  
		   }


}
