package com.fec.epreport.controller.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fec.epreport.pojo.WxUser;
import com.fec.epreport.service.InterFaceService;
import com.fec.epreport.service.ManageService;
import com.fec.epreport.util.commons.PureNetUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/userinterface")
public class UsersController {
	private static Logger logger = LoggerFactory.getLogger(UsersController.class);

	@Autowired
	InterFaceService interFaceService;

	HttpServletRequest request;
	/**
	 * 微信授权接口
	 * 
	 * @param request
	 * @return jsonObject
	 */
	@ResponseBody
	@RequestMapping(value = "/shouquan.htm", method = RequestMethod.GET)
	public Map<String, Object> getString() {
		logger.info("进入/test1/test.htm");
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		try {

			//String sb = "";
			 String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				jsonObject.put("code", "201");
				return jsonObject;
			}
			// 拿一下wx_id
			JSONObject wxObject = JSONObject.parseObject(sb);
			// 查询微信是否授权该用户
			int count = interFaceService.selectShouQuan(wxObject.getString("wx_id"));
			if (count == 0) {
				WxUser user = JSON.parseObject(sb, WxUser.class);
				interFaceService.insertWxUser(user);
			}
			System.out.println("拿到接口的数据为：" + sb);
		} catch (Exception e) {
			jsonObject.put("code", "201");
			logger.error(e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		jsonObject.put("code", "200");
		return jsonObject;
	}

	// 查询个人信息
	@ResponseBody
	@RequestMapping(value ="/selectAUsers.htm", method = RequestMethod.GET)
	public Map<String, Object> selectAUsers() {
		Map<String, Object> jsonObject = new HashMap<String, Object>(); 
		try {
			//String sb = "{" + "    \"wx_id\": \"o_xR71EEsi2313iZ7zmG2XXqd_u8FUbE\"" + "}";
			String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				jsonObject.put("code", "201");
				return jsonObject;
			}
			JSONObject wxObject = JSONObject.parseObject(sb);
			jsonObject = interFaceService.selectAUsersss(wxObject.getString("wx_id"));
		} catch (Exception e) {
			logger.error("错误提示：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		return jsonObject;
	}

	// 历史发布查询
	@ResponseBody
	@RequestMapping("/selectRelease.htm")
	public String selectRelease() {
		try {

		} catch (Exception e) {
			logger.error("错误提示：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		return "";
	}

	// 完善车辆信息
	@ResponseBody
	@RequestMapping("/perfectVehicle.htm")
	public String perfectVehicle(Double user_conductor, String user_vehicletype, Double user_load) {
		try {
			HashMap<String, Object> hashMap = new HashMap<>();
			hashMap.put("user_conductor", user_conductor);
			hashMap.put("user_vehicletype", user_vehicletype);
			hashMap.put("user_load", user_load);
		} catch (Exception e) {
			logger.error("错误提示：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		return "";
	}

	// 查询我的收藏信息
	@ResponseBody
	@RequestMapping("/selectMyCollection.htm")
	public String selectMyCollection() {
		try {

		} catch (Exception e) {
			logger.error("错误提示：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		return "";
	}

	// 分享信息
	@ResponseBody
	@RequestMapping("/shareInformation.htm")
	public String shareInformation() {
		try {

		} catch (Exception e) {
			logger.error("错误提示：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		return "";
	}

	// 用户简介查询
	@ResponseBody
	@RequestMapping("/selectAUsersRelease.htm")
	public String selectAUsersRelease(Integer user_id) {
		try {

		} catch (Exception e) {
			logger.error("错误提示：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		return "";
	}

	// 身份认证
	@ResponseBody
	@RequestMapping("/identityAuthentication.htm")
	public String identityAuthentication(String wx_nickname, String user_idnumber, String user_phonenumber) {
		try {
			HashMap<String, Object> hashMap = new HashMap<>();
			hashMap.put("wx_nickname", wx_nickname);
			hashMap.put("user_idnumber", user_idnumber);
			hashMap.put("user_phonenumber", user_phonenumber);
		} catch (Exception e) {
			logger.error("错误提示：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		return "";
	}
}
