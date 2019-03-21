package com.fec.epreport.controller.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fec.epreport.pojo.WxUser;
import com.fec.epreport.service.InterFaceService;
import com.fec.epreport.util.commons.PureNetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/userinterface")
public class UsersController {
	private static Logger logger = LoggerFactory.getLogger(UsersController.class);

	@Autowired
	InterFaceService interFaceService;

	HttpServletRequest request;
	/**
	 * 微信授权接口
	 * request
	 * @param
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
			String sb = "{" + "    \"wx_id\": \"1001\"" + "}";
//			String sb = PureNetUtil.buffJson(request);
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
	public Map<String, Object> selectRelease() {
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		List<Map<String,Object>> listjsonObject = null;
		try {
			String sb = "{" + "    \"wx_id\": \"1001\"" + "}";
//			String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				jsonObject.put("code", "201");
				listjsonObject.add(jsonObject);
				return jsonObject;
			}
			JSONObject wxObject = JSONObject.parseObject(sb);
			listjsonObject = interFaceService.selectRelease(wxObject.getString("wx_id"));
		} catch (Exception e) {
			logger.error("错误提示：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		jsonObject.put("code", "200");
		jsonObject.put("list",listjsonObject);
		return jsonObject;
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
	public Map<String, Object> selectMyCollection() {
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		List<Map<String,Object>> listjsonObject = null;
		try {
			String sb = "{" + "    \"wx_id\": \"1003\"" + "}";
//			String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				jsonObject.put("code", "201");
				listjsonObject.add(jsonObject);
				return jsonObject;
			}
			JSONObject wxObject = JSONObject.parseObject(sb);
			listjsonObject = interFaceService.selectMyCollection(wxObject.getString("wx_id"));
		} catch (Exception e) {
			logger.error("错误提示：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		jsonObject.put("code", "200");
		jsonObject.put("list",listjsonObject);
		return jsonObject;
	}

	// 分享信息
	@ResponseBody
	@RequestMapping("/shareInformation.htm")
	public Map<String, Object> shareInformation() {
		Map<String, Object> jsonObject = new HashMap<String, Object>();

		try {
			String sb = "{" + "    \"wx_id\": \"1001\"" + "}";
//			String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				jsonObject.put("code", "201");
				return jsonObject;
			}
			JSONObject wxObject = JSONObject.parseObject(sb);
			jsonObject = interFaceService.shareInformation(wxObject.getString("wx_id"));
		} catch (Exception e) {
			logger.error("错误提示：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		jsonObject.put("code", "200");
		return jsonObject;
	}

	// 用户简介查询
	@ResponseBody
	@RequestMapping("/selectAUsersRelease.htm")
	public String selectAUsersRelease(Integer user_id) {
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		Map<String, Object> jsonObject1 = new HashMap<String, Object>();
		List<Map<String,Object>> listjsonObject = null;
		try {
			String sb = "{" + "    \"wx_id\": \"1001\"" + "}";
//			String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				jsonObject1.put("code", "201");
				listjsonObject.add(jsonObject1);
				return "";
			}
			JSONObject wxObject = JSONObject.parseObject(sb);
			jsonObject = interFaceService.shareInformation(wxObject.getString("wx_id"));
			if ("".equals(sb.toString())) {
				jsonObject1.put("code", "201");
				listjsonObject.add(jsonObject1);
				return "";
			}
			JSONObject wxObject1 = JSONObject.parseObject(sb);
			listjsonObject = interFaceService.selectRelease(wxObject.getString("wx_id"));
		} catch (Exception e) {
			logger.error("错误提示：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		listjsonObject.add(jsonObject);
		jsonObject1.put("code", "200");
		listjsonObject.add(jsonObject1);
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
