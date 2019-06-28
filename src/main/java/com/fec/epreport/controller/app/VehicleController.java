package com.fec.epreport.controller.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fec.epreport.pojo.VehicleJson;
import com.fec.epreport.pojo.XfAdvertiseHome;
import com.fec.epreport.pojo.XfBusinessCenter;
import com.fec.epreport.service.InterFaceService;
import com.fec.epreport.service.XfmanageService;
import com.fec.epreport.util.commons.DateUtil;
import com.fec.epreport.util.commons.PureNetUtil;
import com.fec.epreport.util.commons.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/vehicle")
public class VehicleController {
	private static Logger logger = LoggerFactory.getLogger(VehicleController.class);

	@Autowired
	InterFaceService interFaceService;
	@Autowired
	XfmanageService xfmanageService;// 配货管理后台+app接口

	@Resource
	HttpServletRequest request;

	private final static int pageSize = 5;// 每页显示多少条
	private final static int ONE = 1;

	// 车源详情查询
	@ResponseBody
	@RequestMapping("/selectVehicleDetails.htm")
	public Map<String, Object> selectVehicleDetails() {
		logger.info("come in   /vehicle /selectVehicleDetails.htm");
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		Map<String, Object> jsonObject1 = new HashMap<String, Object>();
		try {
//          String sb = "{" + "    \"vehicle_id\": \"3\",\"wx_id\": \"o_xR71EEsiiZ7zmG2XXqd_u8FUbE\",\"wx_ids\": \"o_xR71EEsiiZ7zmG2\"" + "}";
			String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				jsonObject.put("code", "201");
				return jsonObject;
			}
			JSONObject wxObject = JSONObject.parseObject(sb);
			Integer i = 0;
			List<Map<String, Object>> maps = interFaceService.selectliulanjilubiao(wxObject.getString("wx_id"));
			System.out.println(maps);
			for (Map<String, Object> map : maps) {
				if (map.get("browse_identification").equals("1")
						&& map.get("browse_data_id").equals(wxObject.getString("vehicle_id"))) {
					Integer integer = interFaceService.xiugailiulanjiluhuoche(map);
					i = 1;
				}
			}
			if (i == 0) {
				Integer integer = interFaceService.tianjialiulanjiluche(wxObject);
			}
			jsonObject1 = interFaceService.selectMyCollectionUser(wxObject);
			jsonObject = interFaceService.selectVehicleDetails(wxObject.getString("vehicle_id"));
			StringBuffer stringBuffer = new StringBuffer();
			// 追加字符串
			stringBuffer.append(jsonObject.get("vehicle_end_province")).append(jsonObject.get("vehicle_end_city"))
					.append(jsonObject.get("vehicle_end_area")).append(jsonObject.get("vehicle_end_address"));
			System.out.println(stringBuffer.toString());
			jsonObject.put("xiangxidizhi", stringBuffer.toString());
			if (jsonObject1 != null) {
				jsonObject.put("collection", "1");
			} else {
				jsonObject.put("collection", "2");
			}
			jsonObject.put("favorableRate", "暂无");

		} catch (Exception e) {
			logger.error("错误提示(selectVehicleDetails)：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		logger.info("leave   /vehicle /selectVehicleDetails.htm");
		jsonObject.put("code", "200");
		return jsonObject;
	}

	// 车源列表查询
	@SuppressWarnings("null")
	@ResponseBody
	@RequestMapping("/selectVehicles.htm")
	public Map<String, Object> selectVehicles(
			@RequestParam(defaultValue = "1", required = true, value = "pageNo") int pageNo,
			@RequestParam(defaultValue = "0", required = true, value = "share_shiro") String share_shiro,
			@RequestParam(required = false, value = "province") String province,
			@RequestParam(required = false, value = "city") String city) {
		logger.info("come in   /vehicle /selectVehicles.htm");
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		System.out.println("pageNo" + pageNo);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>();
		XfAdvertiseHome xfAdvertiseHome = null;
		try {
//            String sb = "{" +
//                    "    \"desc_time\": \"1\"," +
//                    "    \"vehicle_start_area\": \"济宁市\"," +
//                    "    \"vehicle_end_area\": \"嘉祥县\"," +
//                    "    \"vehicle_type\": \"高栏%平板%\"," +
//                    "    \"vehicle_length\": \"13.5米\"," +
//                    "    \"vehicle_weight\": \"20-30%40\"" +
//                    "}";
			String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				// listjsonObject = interFaceService.selectVehicles();
				guangShang(pageNo, province, city, jsonObject, xfAdvertiseHome);
				PageHelper.startPage(pageNo, pageSize);
				List<Map<String, Object>> resultList = interFaceService.selectVehicles();
				pageInfo = new PageInfo<Map<String, Object>>(resultList);
				if (share_shiro.equals("0")) {
					// System.out.println("setPages为1");
					pageInfo.setPages(ONE);
				}
			} else {
				JSONObject wxObject = JSONObject.parseObject(sb);
				// listjsonObject = interFaceService.selectVehiclesShaiXuan(wxObject);
				if (wxObject.getString("vehicle_weight").equals("不限%")) {
					wxObject.put("vehicle_weight", "不限");
				}
				if (wxObject.getString("vehicle_type").equals("不限%")) {
					wxObject.put("vehicle_type", "不限");
				}
				List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();

				if ((!wxObject.getString("vehicle_weight").equals("不限"))
						&& (!wxObject.getString("vehicle_weight").equals("不限%"))) {
					String string = wxObject.getString("vehicle_weight").substring(3,
							wxObject.getString("vehicle_weight").length());
					List<String> list = Arrays.asList(string.split("%"));
					for (String s : list) {
						List<String> list1 = Arrays.asList(s.split("-"));
						List<String> arrList = new ArrayList<>(list1);
						if (arrList.size() == 1) {
							arrList.add("0.66");
						}
						// System.out.println(arrList);
						Map<String, Object> map = new HashMap<>();
						map.put("min_number", Double.parseDouble(arrList.get(0)));
						map.put("max_number", Double.parseDouble(arrList.get(1)));
						maps.add(map);
					}
				}
//                wxObject.put("goods_number",maps);
				// System.out.println(maps);

				if (!wxObject.getString("vehicle_length").equals("不限")) {
					String str = wxObject.getString("vehicle_length").substring(0,
							wxObject.getString("vehicle_length").length() - 1);
					wxObject.put("vehicle_length", str);
				}
				String string1 = "不限";
				if ((!wxObject.getString("vehicle_type").equals("不限"))
						&& (!wxObject.getString("vehicle_type").equals("不限%"))) {
					string1 = wxObject.getString("vehicle_type").substring(3,
							wxObject.getString("vehicle_type").length());
				}
				// 广告或招商
				guangShang(pageNo, wxObject.getString("province"), wxObject.getString("city"), jsonObject,
						xfAdvertiseHome);
				PageHelper.startPage(pageNo, pageSize);
				List<String> list1 = Arrays.asList(string1.split("%"));
				List<Map<String, Object>> resultList = interFaceService.selectVehiclesShaiXuan(wxObject, maps, list1);
				pageInfo = new PageInfo<Map<String, Object>>(resultList);
				if (share_shiro.equals("0")) {
					System.out.println("setPages为1");
					pageInfo.setPages(ONE);
				}
				// System.out.println("pageInfo" + pageInfo);
			}

		} catch (Exception e) {
			logger.error("错误提示(selectVehicles)：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		logger.info("leave   / vehicle/selectVehicles.htm");
		jsonObject.put("code", "200");
		jsonObject.put("data", pageInfo);
//        jsonObject.put("data",listjsonObject);
		return jsonObject;
	}

	private void guangShang(int pageNo, String province, String city, Map<String, Object> jsonObject,
			XfAdvertiseHome xfAdvertiseHome) {
		Random random = new Random();
		int countSize = 0;
		if (!StringUtils.isBlank(province) && !StringUtils.isBlank(city)) {
			// 查询广告第一条 始终要是自己公司的
			if(pageNo==1) {
				xfAdvertiseHome=xfmanageService.selectXfGuangGao();
			}else {
				xfAdvertiseHome = xfmanageService.selectGuangGao(pageNo, province, city);	
			}
			 if (pageNo > 1 && xfAdvertiseHome == null) {
				int count = xfmanageService.selectCount(ONE, province, city);
				if (count > 0) {
					countSize = random.nextInt(count) + 1;
					xfAdvertiseHome = xfmanageService.selectGuangGao(countSize, province, city);
				}
			}
		}
		// 没有广告时返回招商
		if (xfAdvertiseHome == null || StringUtils.isBlank(xfAdvertiseHome.getId())) {
			// 查询招商
			XfBusinessCenter xfBusinessCenter = xfmanageService.selectZhaoShang();
			jsonObject.put("godata", xfBusinessCenter);
		} else {
			jsonObject.put("godata", xfAdvertiseHome);
		}
	}

	// 发布车源
	@ResponseBody
	@RequestMapping("/releaseCar.htm")
	public Map<String, Object> releaseCar() {
		logger.info("come in /vehicle/releaseCar.htm");
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		try {

			// String sb = "{\"vehicle_contactinformation\":
			// \"1366666666\",\"vehicle_contacts\": \"张三\",\"vehicle_detaileddescription\":
			// \"哈哈\",\"vehicle_end__address\": \"人民医院\",\"vehicle_end__area\":
			// \"长治县\",\"vehicle_end__city\": \"长治市\",\"vehicle_end_province\":
			// \"山西省\",\"vehicle_length\": \"不限\",\"vehicle_number\":
			// \"22\",\"vehicle_number_mi\": \"666\",\"vehicle_releasetime\":
			// \"\",\"vehicle_start_address\": \"天安门\",\"vehicle_start_area\":
			// \"嘉祥县\",\"vehicle_start_city\": \"济宁市\",\"vehicle_start_province\":
			// \"山东省\",\"vehicle_type\":
			// \"不限\",\"vehicle_wx_id\":\"o_xR71EEsiiZ7zmG2XXqd_u8FUbE\" }";
			String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				jsonObject.put("code", "201");
				return jsonObject;
			}
			System.out.println(sb);
			VehicleJson car = JSON.parseObject(sb, VehicleJson.class);

			StringBuffer stringBuffer = new StringBuffer();
			StringBuffer stringBuffer1 = new StringBuffer();

			// 追加字符串
			stringBuffer.append(car.getVehicle_start_city()).append(car.getVehicle_start_area());
			stringBuffer1.append(car.getVehicle_end__city()).append(car.getVehicle_end__area());
			System.out.println(stringBuffer);
			System.out.println(stringBuffer1);
			car.setVehicle_start(stringBuffer.toString());
			car.setVehicle_end(stringBuffer1.toString());
			System.out.println(car);

			// 修改发布时间
			car.setVehicle_releasetime(DateUtil.getTime());
			int i = interFaceService.releaseCar(car);
			if (i != 1) {
				logger.info("发布车源入库失败");
				jsonObject.put("code", "203");
				return jsonObject;
			}
		} catch (Exception e) {
			logger.error("错误提示(releaseCar)：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		logger.info("leave /vehicle/releaseCar.htm");
		jsonObject.put("code", "200");
		return jsonObject;
	}

}