package com.fec.epreport.controller;


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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class ManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(ManageController.class);
	@Autowired
	ManageService manageService;
	private int  pageSize=10;//每页显示记录数

	/**
	 * zcy
	 * 2019年2月18日09:55:59
	 * @return
	 */
	   @RequestMapping(value = "/welcome.htm", method = RequestMethod.GET)
	   public String welcome(HttpServletRequest req, Model model, String excelMsg, @RequestParam(defaultValue="1",required=true,value="pageNo") int pageNo) {
		   try {

			   List<Map<String,Object>> list = manageService.selectGoodsVehiceTime();
			   req.setAttribute("year",list);
			   Map<String,Object> map = manageService.selectUserNumber();
			   Map<String,Object> map1 = manageService.selectVehiceNumber();
			   Map<String,Object> map2 = manageService.selectDoodsNumber();
			   Map<String,Object> map3 = manageService.selectVehiceStateNumber();
			   Map<String,Object> map4 = manageService.selectDoodsStateNumber();
			   req.setAttribute("userNumber",map.get("user_number"));
			   req.setAttribute("vehiceNumber",map1.get("vehice_number"));
			   req.setAttribute("doodsNumber",map2.get("goods_number"));
			   req.setAttribute("vehiceStateNumber",map3.get("vehice_statenumber"));
			   req.setAttribute("doodsStateNumber",map4.get("goods_statenumber"));

				//分页插件
			   List<Users> list1 = PageHelper.startPage(pageNo, pageSize);
			   //拦截写入新的查询 暂定10条每页查
			   List<Users> list2 = manageService.selectAllusers();
			   PageInfo<Users> pageInfo=new PageInfo<>(list2);
			   model.addAttribute("userlist", pageInfo);
		   } catch (Exception e) {
			   logger.error(e.getLocalizedMessage(), e);
			   e.printStackTrace();
		   }
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
