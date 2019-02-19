package com.fec.epreport.controller;


import com.alibaba.fastjson.JSON;
import com.fec.epreport.entity.User;
import com.fec.epreport.service.ManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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


	//管理登陆
	//根据用户名查询用户信息
	//不返回路径返回值
	//@ResponseBody
	@RequestMapping("/adminLand.htm")
	public void adminLand(String user_name, String user_password, HttpSession hs, HttpServletResponse resp) throws IOException {
		User user = manageService.selectByName(user_name);
		String str = (String) hs.getAttribute("md5RandomKey");
		String string="1";
		if(user!=null){
			String strpwd = str + user.getUser_password();
			String md5strpwd = DigestUtils.md5Hex(strpwd);

			if(md5strpwd.equals(user_password)){
				hs.setAttribute("username",user_name);
				string="2";
			}
		}
		String json = JSON.toJSONString(string);
		resp.getWriter().write(json);

	}

}
