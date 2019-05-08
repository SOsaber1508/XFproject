package com.fec.epreport.controller.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fec.epreport.dao.JedisClient;
import com.fec.epreport.pojo.CarInformation;
import com.fec.epreport.pojo.ShareShiro;
import com.fec.epreport.pojo.WxUser;
import com.fec.epreport.service.InterFaceService;
import com.fec.epreport.util.commons.PureNetUtil;
import com.fec.epreport.util.commons.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/userinterface")
public class UsersController {
	private static Logger logger = LoggerFactory.getLogger(UsersController.class);

	@Autowired
	InterFaceService interFaceService;

	@Resource
	HttpServletRequest request;

	@Autowired
	JedisClient jedisClient;

	// 用户分享权限
	private static String USER_SHARE_SHIRO = "UserShare_shiro";
	private final static int REDISSECOND = 259200;
	private final static String FINAL_SHIRO_ZERO = "0";
	private final static String FINAL_SHIRO_ONE = "1";
	private final static String FINAL_SHIRO_TWO = "2";
	private final static int USER_SHARE_NUM = 10;

	/**
	 * 微信授权接口
	 * zcy
	 * request
	 * @param
	 * @return jsonObject
	 */
	@ResponseBody
	@RequestMapping(value = "/shouquan.htm", method = RequestMethod.POST)
	public Map<String, Object> getString() {
		logger.info("进入/userinterface/shouquan.htm");
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		try {
			// 测试数据
			// String sb = "{" + " \"wx_id\": \"o_xR71EEsi2313iZ7zmG2XXqd_u8FUbE\"" + "}";
			String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				jsonObject.put("code", "201");
				return jsonObject;
			}
			// 拿一下wx_id
			JSONObject wxObject = JSONObject.parseObject(sb);
			// 查询微信是否授权过该用户
			int count = interFaceService.selectShouQuan(wxObject.getString("wx_id"));
			if (count == 0) {
				WxUser user = JSON.parseObject(sb, WxUser.class);
				//sql入库
				interFaceService.insertWxUser(user);
				//redis入库
				jedisClient.set(USER_SHARE_SHIRO + ":" + wxObject.getString("wx_id"), FINAL_SHIRO_ZERO);
			}
			String user_authentication = interFaceService.selectidentityAuthentication(wxObject.getString("wx_id"));
			jsonObject.put("user_authentication", user_authentication);
			System.out.println("拿到接口的数据为：" + sb);
		} catch (Exception e) {
			jsonObject.put("code", "201");
			logger.error("错误提示(shouquan)：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		logger.info("leave/userinterface/shouquan.htm");
		jsonObject.put("code", "200");
		return jsonObject;
	}

	/**
	 * xie
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/selectAUserziliao.htm")
	//个人中心资料查询
	public Map<String, Object> selectAUserziliao() {
		logger.info("进入/userinterface/selectAUserziliao.htm");
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		try {

//			String sb = "{" + "    \"wx_id\": \"o_xR71EEsiiZ7zmG2XXqd_u8FUbE\"" + "}";
			String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				jsonObject.put("code", "201");
				return jsonObject;
			}
			JSONObject wxObject = JSONObject.parseObject(sb);
			jsonObject = interFaceService.selectAUserziliao(wxObject.getString("wx_id"));

		} catch (Exception e) {
			logger.error("错误提示(selectAUserziliao)：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		logger.info("leave   /userinterface /selectAUserziliao.htm");
		jsonObject.put("code", "200");
		return jsonObject;
	}
	
	// 用户简介查询
		@ResponseBody
		@RequestMapping(value = "/selectAUsersRelease.htm",method = {RequestMethod.POST,RequestMethod.GET})
		public Map<String, Object> selectAUsersRelease() {
			logger.info("come in   /userinterface /selectAUsersRelease.htm");
			Map<String, Object> jsonObject = new HashMap<String, Object>();
			Map<String, Object> jsonObject1 = new HashMap<String, Object>();
			Map<String, Object> jsonObject2 = new HashMap<String, Object>();
			List<Map<String,Object>> listjsonObject = new ArrayList<Map<String,Object>>();
			try {
//				String sb = "{" + "    \"wx_id\": \"o_xR71EEsiiZ7zmG2XXqd_u8FUbE\"" + "}";
				String sb = PureNetUtil.buffJson(request);
				if ("".equals(sb.toString())) {
					jsonObject.put("code", "201");
					return jsonObject;
				}
				JSONObject wxObject = JSONObject.parseObject(sb);
				//查用户信息。
				jsonObject1 = interFaceService.selectAUsers(wxObject.getString("wx_id"));
				//查历史发布记录
				listjsonObject = interFaceService.selectAUsersRelease(wxObject.getString("wx_id"));
				//查历史发布记录数量
				jsonObject2 =  interFaceService.selectAUsersReleaseNumber(wxObject.getString("wx_id"));
				//String number = (String) jsonObject2.get("number");
				String number =jsonObject2.get("number").toString();
				jsonObject.put("number",number);


			} catch (Exception e) {
				logger.error("错误提示(selectAUsersRelease)：" + e.getLocalizedMessage(), e);
				e.printStackTrace();
			}
			logger.info("leave   /userinterface /selectAUsersRelease.htm");
			jsonObject.put("code", "200");
			jsonObject.put("wx", jsonObject1);
			jsonObject.put("data", listjsonObject);


			return jsonObject;
		}
	
	
	// 查询个人资料
	@ResponseBody
	@RequestMapping(value = "/selectAUsers.htm", method = RequestMethod.POST)
	public Map<String, Object> selectAUsers() {
		logger.info("进入/userinterface/selectAUsers.htm");
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		Map<String, Object> resultjsonObject = new HashMap<String, Object>();
		try {
			// 测试数据
			// String sb = "{" + " \"wx_id\": \"o_xR71EEsi2313iZ7zmG2XXqd_u8FUbE\"" + "}";
			String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				jsonObject.put("code", "201");
				return jsonObject;
			}
			JSONObject wxObject = JSONObject.parseObject(sb);
			jsonObject = interFaceService.selectAUsersss(wxObject.getString("wx_id"));
			resultjsonObject.put("data", jsonObject);
			logger.info("查询个人资料jsonObject" + jsonObject);
		} catch (Exception e) {
			logger.error("错误提示(selectAUsers)：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		logger.info("leave/userinterface/selectAUsers.htm");
		resultjsonObject.put("code", "200");
		return resultjsonObject;
	}

	// 历史发布查询
		@ResponseBody
		@RequestMapping(value="/selectRelease.htm",method = {RequestMethod.POST,RequestMethod.GET})
		public Map<String, Object> selectRelease() {
			logger.info("come in   /userinterface /selectRelease.htm");

			Map<String, Object> jsonObject = new HashMap<String, Object>();
			List<Map<String,Object>> listjsonObject = new ArrayList<Map<String,Object>>();
			try {
//				String sb = "{" + "    \"wx_id\": \"o_xR71EEsiiZ7zmG2XXqd_u8FUbE\"" + "}";
				String sb = PureNetUtil.buffJson(request);
				//StringUtils.isBlank(sb.toString()){
				//}
				if ("".equals(sb.toString())) {
					jsonObject.put("code", "201");
					return jsonObject;
				}
				JSONObject wxObject = JSONObject.parseObject(sb);
				listjsonObject = interFaceService.selectRelease(wxObject.getString("wx_id"));
				jsonObject.put("data",listjsonObject);

			} catch (Exception e) {
				logger.error("错误提示(selectRelease)：" + e.getLocalizedMessage(), e);
				e.printStackTrace();
			}
			logger.info("leave   /userinterface /selectRelease.htm");
			jsonObject.put("code", "200");
			return jsonObject;
		}

	// 完善车辆信息
	@ResponseBody
	@RequestMapping(value = "/perfectVehicle.htm", method = RequestMethod.POST)
	public Map<String, Object> perfectVehicle() {
		logger.info("come in /userinterface/perfectVehicle.htm");
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		try {
			String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				jsonObject.put("code", "201");
				return jsonObject;
			}
			JSONObject wxObject = JSONObject.parseObject(sb);
			// 查询是否完善过车辆信息
			String user_perfect = interFaceService.selectPerfectVehicle(wxObject.getString("wx_id"));
			jsonObject.put("user_perfect", user_perfect);
			if (user_perfect.equals("0")) {
				logger.info("已完善过该车辆信息");
				jsonObject.put("code", "202");
				return jsonObject;
			} else {
				CarInformation car = JSON.parseObject(sb, CarInformation.class);
				int i = interFaceService.perfectVehicle(car);
				if (i != 1) {
					logger.info("完善信息入库失败");
					jsonObject.put("code", "203");
					return jsonObject;
				}
			}
		} catch (Exception e) {
			logger.error("错误提示(perfectVehicle)：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		logger.info("leave/userinterface/perfectVehicle.htm");
		jsonObject.put("code", "200");
		return jsonObject;
	}

	// 查询我的收藏信息
		@ResponseBody
		@RequestMapping(value = "/selectMyCollection.htm",method = {RequestMethod.POST,RequestMethod.GET})
		public Map<String, Object> selectMyCollection() {
			logger.info("come in   /userinterface /selectMyCollection.htm");
			Map<String, Object> jsonObject = new HashMap<String, Object>();
			List<Map<String,Object>> listjsonObject = new ArrayList<Map<String,Object>>();
			try {
//				String sb = "{" + "    \"wx_id\": \"o_xR71EEsiiZ7zmG2XXqd_u8FUbE\"" + "}";
				String sb = PureNetUtil.buffJson(request);
				if ("".equals(sb.toString())) {
					jsonObject.put("code", "201");
					return jsonObject;
				}
				JSONObject wxObject = JSONObject.parseObject(sb);
				listjsonObject = interFaceService.selectMyCollection(wxObject.getString("wx_id"));
				for (Map<String, Object> l:listjsonObject) {
					l.put("favorableRate","暂无");
				}

			} catch (Exception e) {
				logger.error("错误提示(selectMyCollection)：" + e.getLocalizedMessage(), e);
				e.printStackTrace();
			}
			logger.info("leave   /userinterface /selectMyCollection.htm");
			jsonObject.put("code", "200");
			jsonObject.put("data",listjsonObject);
			return jsonObject;
		}

	// http://2f410t4715.qicp.vip:25889/epreport/FileDemo/imageFile.htm
	// http://2f410t4715.qicp.vip:25889/epreport/userinterface/shareInformation.htm
	// 查询分享信息接口
	@ResponseBody
	@RequestMapping("/shareInformation.htm")
	public Map<String, Object> shareInformation() {
		logger.info("come in /userinterface/shareInformation.htm");
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		try {
			//String sb = "{" + " \"wx_id\": \"o_xR71EEsi2313iZ7zmG2XXqd_u8FUbE\"" + "}";
			 String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				logger.info("查询分享信息接口 没有接收到数据");
				jsonObject.put("code", "201");
				return jsonObject;
			}
			JSONObject wxObject = JSONObject.parseObject(sb);
			// 查询分享接口权限
			String user_share_shiro = jedisClient.get(USER_SHARE_SHIRO + ":" + wxObject.getString("wx_id"));
			if (StringUtils.isBlank(user_share_shiro)) {
				System.out.println("走mysql查询赋值redis缓存");
				user_share_shiro = interFaceService.shareInformation(wxObject.getString("wx_id"));
				jedisClient.set(USER_SHARE_SHIRO + ":" + wxObject.getString("wx_id"), user_share_shiro);
				// if (user_share_shiro.equals(FINAL_SHIRO_ONE)) {
				// 设置session的过期时间 时间单位是秒
				// jedisClient.expire(USER_SHARE_SHIRO + ":" + wxObject.getString("wx_id"),
				// REDISSECOND);
				// }
			}
			jsonObject.put("user_share_shiro", user_share_shiro);
			if(user_share_shiro.equals(FINAL_SHIRO_ZERO)) {
				ShareShiro shareShiro = interFaceService.selectshareShiro(wxObject.getString("wx_id"));
				jsonObject.put("user_share", shareShiro.getUser_share());
				jsonObject.put("user_share_num",USER_SHARE_NUM);
			}else {
				jsonObject.put("user_share",null);
				jsonObject.put("user_share_num",null);
			}
		} catch (Exception e) {
			logger.error("错误提示(shareInformation)：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		logger.info("leave/userinterface/shareInformation.htm");
		jsonObject.put("code", "200");
		
		return jsonObject;
	}
	//http://2f410t4715.qicp.vip:25889/epreport/userinterface/shareShiro.htm
	// 分享接口回调
	@ResponseBody
	@RequestMapping("/shareShiro.htm")
	public Map<String, Object> shareShiro() {
		logger.info("come in /userinterface/shareShiro.htm");
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		try {
			//String sb = "{" + " \"wx_id\": \"o_xR71EEsi2313iZ7zmG2XXqd_u8FUbE\"" + "}";
			 String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				logger.info("分享接口回调 没有接收到数据");
				jsonObject.put("code", "201");
				return jsonObject;
			}
			JSONObject wxObject = JSONObject.parseObject(sb);
			// 查询分享接口权限
			String user_share_shiro = jedisClient.get(USER_SHARE_SHIRO + ":" + wxObject.getString("wx_id"));
			int resultcount = interFaceService.CountshareShiro(wxObject.getString("wx_id"));
			// 分享次数新增成功
			if (resultcount == 1) {
				//如果是永久权限
				if (!StringUtils.isBlank(user_share_shiro) && user_share_shiro.equals(FINAL_SHIRO_TWO)) {
					jsonObject.put("code", "200");
					return jsonObject;
				}
				ShareShiro shareShiro = interFaceService.selectshareShiro(wxObject.getString("wx_id"));
				// redis查询出 为空或为0
				if (StringUtils.isBlank(user_share_shiro) || user_share_shiro.equals(FINAL_SHIRO_ZERO)) {
					if (shareShiro.getUser_share() > 9 && !shareShiro.getUser_share_shiro().equals(FINAL_SHIRO_TWO)) {
						// 改成永久权限
						logger.info("修改成永久权限");
						int count = interFaceService.shareShiro(wxObject.getString("wx_id"), FINAL_SHIRO_TWO);
						if (count == 1) {
							jedisClient.set(USER_SHARE_SHIRO + ":" + wxObject.getString("wx_id"), FINAL_SHIRO_TWO);
						} else {
							jsonObject.put("code", "203");// 后台修改分享接口永久权限出错
							return jsonObject;
						}
					} else {
						// 分享次数增加
						jedisClient.set(USER_SHARE_SHIRO + ":" + wxObject.getString("wx_id"), FINAL_SHIRO_ONE);
						jedisClient.expire(USER_SHARE_SHIRO + ":" + wxObject.getString("wx_id"), REDISSECOND);
					}
				} // reid 查询出为1
				else if (user_share_shiro.equals(FINAL_SHIRO_ONE) && shareShiro.getUser_share() < 9) {
					logger.info("临时权限更新");
					// 分享次数增加
					jedisClient.set(USER_SHARE_SHIRO + ":" + wxObject.getString("wx_id"), FINAL_SHIRO_ONE);
					jedisClient.expire(USER_SHARE_SHIRO + ":" + wxObject.getString("wx_id"), REDISSECOND);
				} // reid 查询出为2
				else if(user_share_shiro.equals(FINAL_SHIRO_ONE) && shareShiro.getUser_share() > 9){
					logger.info("进这里来代表是永久权限");
					int count = interFaceService.shareShiro(wxObject.getString("wx_id"), FINAL_SHIRO_TWO);
					if (count == 1) {
						jedisClient.set(USER_SHARE_SHIRO + ":" + wxObject.getString("wx_id"), FINAL_SHIRO_TWO);
					} else {
						jsonObject.put("code", "203");// 后台修改分享接口永久权限出错
						return jsonObject;
					}
				}
				jsonObject.put("code", "200");
			} else {
				jsonObject.put("code", "203");// 后台增加次数出错
				return jsonObject;
			}

		} catch (Exception e) {
			logger.error("错误提示(shareShiro)：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		logger.info("leave/userinterface/shareShiro.htm");
		jsonObject.put("code", "200");
		return jsonObject;
	}

	// 查询是否完善过车辆信息
	@ResponseBody
	@RequestMapping(value = "/selectPerfectVehicle.htm", method = RequestMethod.POST)
	public Map<String, Object> selectPerfectVehicle(Integer user_id) {
		logger.info("come in /userinterface/selectPerfectVehicle.htm");
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		try {
			String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				logger.info("查询是否完善过车辆信息接口 没有接收到数据");
				jsonObject.put("code", "201");
				return jsonObject;
			}
			JSONObject wxObject = JSONObject.parseObject(sb);
			// 查询是否完善过车辆信息
			String user_perfect = interFaceService.selectPerfectVehicle(wxObject.getString("wx_id"));
			jsonObject.put("user_perfect", user_perfect);
		} catch (Exception e) {
			logger.error("错误提示(selectPerfectVehicle)：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		logger.info("leave/userinterface/selectPerfectVehicle.htm");
		jsonObject.put("code", "200");
		return jsonObject;
	}

	// 总的:查询是否完善车辆信息+查询是否身份认证
	@ResponseBody
	@RequestMapping(value = "/selectShiro.htm", method = RequestMethod.POST)
	public Map<String, Object> selectShiro() {
		logger.info("进入/userinterface/selectShiro.htm");
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		try {
			// 测试数据
			// String sb = "{" + " \"wx_id\": \"o_xR71EEsi2313iZ7zmG2XXqd_u8FUbE\"" + "}";
			String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				jsonObject.put("code", "201");
				return jsonObject;
			}
			JSONObject wxObject = JSONObject.parseObject(sb);
			jsonObject = interFaceService.selectShiro(wxObject.getString("wx_id"));
			logger.info("查询个人信息jsonObject" + jsonObject);
		} catch (Exception e) {
			logger.error("错误提示(selectAUsers)：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		logger.info("leave/userinterface/selectAUsers.htm");
		jsonObject.put("code", "200");
		return jsonObject;
	}

//  重新发布接口
	@ResponseBody
	@RequestMapping("/chongxinfabu.htm")
	public Map<String, Object> chongxinfabu(Integer id, String Identification) {
		logger.info("come in   /userinterface /chongxinfabu.htm");
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		Map<String, Object> jsonObject1 = new HashMap<String, Object>();
		try {
//			String sb = "{" + "    \"id\": \"1\",\"Identification\": \"2\"" + "}";
			String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				jsonObject.put("code", "201");
				return jsonObject;
			}
			JSONObject wxObject = JSONObject.parseObject(sb);
			jsonObject1 = interFaceService.chongxinfabuchaxun(wxObject);
			long hous = getHous(jsonObject1);
			System.out.println(hous);
			if (hous>=3){
				Integer integer = interFaceService.chongxinfabuxiugai(wxObject);
				if (integer==1){
					jsonObject.put("code", "200");
					return jsonObject;
				}
				if (integer!=1){
					jsonObject.put("code", "201");
					return jsonObject;
				}
			}else {
				jsonObject.put("code", "202");
				return jsonObject;
			}

		} catch (Exception e) {
			logger.error("错误提示(chongxinfabu)：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		logger.info("leave   /userinterface /chongxinfabu.htm");
		jsonObject.put("code", "200");
		return jsonObject;
	}
	//返回時間
	private long getHous(Map<String, Object> jsonObject1) {
		long hous= 0;
		try {
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
			Date nows=new Date();
			Date date=dateFormat.parse((String) jsonObject1.get("times"));
			hous = (nows.getTime()-date.getTime())/(60*60*1000);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return hous;
	}
	
//  修改发布接口（查询该发布信息）
	@ResponseBody
	@RequestMapping("/xiugaifabu.htm")
	public Map<String, Object> xiugaifabu(Integer id, String Identification) {
		logger.info("come in   /userinterface /xiugaifabu.htm");
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		try {
//			String sb = "{" + "    \"id\": \"4\",\"Identification\": \"1\"" + "}";
			String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				jsonObject.put("code", "201");
				return jsonObject;
			}
			JSONObject wxObject = JSONObject.parseObject(sb);
			jsonObject = interFaceService.xiugaifabu(wxObject);

		} catch (Exception e) {
			logger.error("错误提示(xiugaifabu)：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		logger.info("leave   /userinterface /xiugaifabu.htm");
		jsonObject.put("code", "200");
		return jsonObject;
	}
	
//  修改发布接口（修改该发布信息）
	@ResponseBody
	@RequestMapping("/xiugaifabutijiao.htm")
	public Map<String, Object> xiugaifabutijiao() {
		logger.info("come in   /userinterface /xiugaifabutijiao.htm");
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		try {
//			String sb = "{\"identification\":\"1\",\"vehicle_contactinformation\":\"13660678928\",\"vehicle_contacts\":\"李四\"," +
//					"\"vehicle_detaileddescription\":\"哈哈\",\"vehicle_end__address\":\"人民医院\",\"vehicle_end__area\":\"嘉祥县\"," +
//					"\"vehicle_end__city\":\"济宁市\",\"vehicle_end_province\":\"山东省\",\"vehicle_id\":1,\"vehicle_length\":\"不限\"," +
//					"\"vehicle_number\":\"22\",\"vehicle_number_mi\":\"666\",\"vehicle_releasetime\":\"\"," +
//					"\"vehicle_start_address\":\"天安门\",\"vehicle_start_area\":\"嘉祥县\",\"vehicle_start_city\":\"济宁市\"," +
//					"\"vehicle_start_province\":\"山东省\",\"vehicle_type\":\"不限\",\"vehicle_wx_id\":\"o_xR71EEsiiZ7zmG2XXqd_u8FUbE\"}";
//			String sb = "{\"goods_Detailedtype\":\"其他\",\"goods_contactinformation\":\"1366666\",\"goods_contacts\":\"张三\"," +
//					"\"goods_detailed\":\"哈哈哈哈糍粑\",\"goods_end_address\":\"呵呵\",\"goods_end_area\":\"白河县\"," +
//					"\"goods_end_city\":\"安康市\",\"goods_end_province\":\"陕西省\",\"goods_id\":14,\"goods_length\":\"不限\"," +
//					"\"goods_loadingtime\":\"2019-03-22 21:49\",\"goods_name\":\"矿石\",\"goods_number\":\"66.6\"," +
//					"\"goods_number_mi\":\"33\",\"goods_start_address\":\"哈哈\",\"goods_start_area\":\"嘉祥县\"," +
//					"\"goods_start_city\":\"济宁市\",\"goods_start_province\":\"山东省\",\"goods_time\":\"\"," +
//					"\"goods_type\":\"普货\",\"goods_user_id\":\"o_xR71EEsiiZ7zmG2XXqd_u8FUbE\",\"goods_vehicletype\":\"不限\"," +
//					"\"goods_vetype\":\"不限\",\"identification\":\"2\"}";
			String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				jsonObject.put("code", "201");
				return jsonObject;
			}
			JSONObject wxObject = JSONObject.parseObject(sb);
			if (wxObject.getString("identification").equals("1")){
				System.out.println("车");
				StringBuffer stringBuffer = new StringBuffer();
				StringBuffer stringBuffer1 = new StringBuffer();

				//追加字符串
				stringBuffer.append(wxObject.getString("vehicle_start_city")).append(wxObject.getString("vehicle_start_area"));
				stringBuffer1.append(wxObject.getString("vehicle_end__city")).append(wxObject.getString("vehicle_end__area"));
				System.out.println(stringBuffer);
				System.out.println(stringBuffer1);
				wxObject.put("vehicle_start",stringBuffer.toString());
				wxObject.put("vehicle_end",stringBuffer1.toString());
				System.out.println(wxObject);
			}
			if (wxObject.getString("identification").equals("2")){
				System.out.println("货");
				StringBuffer stringBuffer = new StringBuffer();
				StringBuffer stringBuffer1 = new StringBuffer();

				//追加字符串
				stringBuffer.append(wxObject.getString("goods_start_city")).append(wxObject.getString("goods_start_area"));
				stringBuffer1.append(wxObject.getString("goods_end_city")).append(wxObject.getString("goods_end_area"));
				System.out.println(stringBuffer);
				System.out.println(stringBuffer1);
				wxObject.put("goods_start",stringBuffer.toString());
				wxObject.put("goods_end",stringBuffer1.toString());
				System.out.println(wxObject.getString("goods_start"));
				System.out.println(wxObject.getString("goods_end"));
			}
//			VehicleJson car = JSON.parseObject(sb, VehicleJson.class);
			// 修改
//			car.setVehicle_releasetime(DateUtil.getTime());
			int i = interFaceService.xiugaifabutijiao(wxObject);
			if (i != 1) {
				jsonObject.put("code", "203");
				return jsonObject;
			}
			System.out.println("i" + i);

		} catch (Exception e) {
			logger.error("错误提示(xiugaifabutijiao)：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		logger.info("leave   /userinterface /xiugaifabutijiao.htm");
		jsonObject.put("code", "200");
		return jsonObject;
	}
	
	//关于我们接口
		@ResponseBody
		@RequestMapping("/guanyuwomen.htm")
		public Map<String, Object> guanyuwomen() {
			logger.info("come in   /userinterface /guanyuwomen.htm");
			Map<String, Object> jsonObject = new HashMap<String, Object>();
			try {
				jsonObject =  interFaceService.guanyuwomen();

			} catch (Exception e) {
				logger.error("错误提示(guanyuwomen)：" + e.getLocalizedMessage(), e);
				e.printStackTrace();
			}
			logger.info("leave   /userinterface /guanyuwomen.htm");
			jsonObject.put("code", "200");
			return jsonObject;
		}
		
		
		// 查询我的浏览记录
		@ResponseBody
		@RequestMapping(value = "/selectliulanjilu.htm",method = {RequestMethod.POST,RequestMethod.GET})
		public Map<String, Object> selectliulanjilu() {
			logger.info("come in   /userinterface /selectliulanjilu.htm");
			Map<String, Object> jsonObject = new HashMap<String, Object>();
			Map<String, Object> jsonObject1 = new HashMap<String, Object>();
			List<Map<String,Object>> listjsonObject = new ArrayList<Map<String,Object>>();
			List<Map<String,Object>> listjsonObject1 = new ArrayList<Map<String,Object>>();
			try {
//				String sb = "{" + "    \"wx_id\": \"o_xR71EEsiiZ7zmG2XXqd_u8FUbE\"" + "}";
				String sb = PureNetUtil.buffJson(request);
				if ("".equals(sb.toString())) {
					jsonObject.put("code", "201");
					return jsonObject;
				}
				JSONObject wxObject = JSONObject.parseObject(sb);
				listjsonObject1 = interFaceService.selectliulanjilubiao(wxObject.getString("wx_id"));
				for (Map<String,Object> map:listjsonObject1) {
					listjsonObject.add(interFaceService.selectliulanjilu(map));
				}

			} catch (Exception e) {
				logger.error("错误提示(selectliulanjilu)：" + e.getLocalizedMessage(), e);
				e.printStackTrace();
			}
			logger.info("leave   /userinterface /selectliulanjilu.htm");
			jsonObject.put("code", "200");
			jsonObject.put("data",listjsonObject);
			return jsonObject;
		}
		// 点击收藏取消用户
		@ResponseBody
		@RequestMapping(value = "/dianjishoucanguser.htm",method = {RequestMethod.POST,RequestMethod.GET})
		public Map<String, Object> dianjishoucanguser() {
			logger.info("come in   /userinterface /dianjishoucanguser.htm");
			Map<String, Object> jsonObject = new HashMap<String, Object>();

			try {
//				String sb = "{" + "    \"wx_id\": \"o_xR71EEsiiZ7zmG2XXqd_u8FUbE\",\"wx_ids\": \"o_xR71EEsiiZ7zmG2XXqd_u8FUbE\",\"collection\": \"2\"" + "}";
				String sb = PureNetUtil.buffJson(request);
				System.out.println("request++++++++++++++++++"+request);
				if ("".equals(sb.toString())) {
					jsonObject.put("code", "201");
					return jsonObject;
				}
				JSONObject wxObject = JSONObject.parseObject(sb);
				Integer integer = interFaceService.dianjishoucanguser(wxObject);
				System.out.println("integer+++++++"+integer);
				if (integer==1){
					jsonObject.put("code", "200");
					return jsonObject;
				}

			} catch (Exception e) {
				logger.error("错误提示(dianjishoucanguser)：" + e.getLocalizedMessage(), e);
				e.printStackTrace();
			}
			logger.info("leave   /userinterface /dianjishoucanguser.htm");
			jsonObject.put("code", "201");
			return jsonObject;
		}
		//版本下载查询
		@ResponseBody
		@RequestMapping("/selectBanBenXiaZai.htm")
		public Map<String, Object> selectBanBenXiaZai() {
			logger.info("come in   /userinterface/selectBanBenXiaZai.htm");
			Map<String, Object> jsonObject = new HashMap<String, Object>();
			try {
				jsonObject =  interFaceService.selectBanBenXiaZai();

			} catch (Exception e) {
				logger.error("错误提示(selectBanBenXiaZai)：" + e.getLocalizedMessage(), e);
				e.printStackTrace();
			}
			logger.info("leave   /userinterface /selectBanBenXiaZai.htm");
			jsonObject.put("code", "200");
			return jsonObject;
		}
}