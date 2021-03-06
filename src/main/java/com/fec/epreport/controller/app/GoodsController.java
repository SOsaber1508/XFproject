package com.fec.epreport.controller.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fec.epreport.pojo.GoodsJson;
import com.fec.epreport.pojo.GoodsList;
import com.fec.epreport.pojo.XfAdvertiseHome;
import com.fec.epreport.pojo.XfBusinessCenter;
import com.fec.epreport.service.InterFaceService;
import com.fec.epreport.service.ManageService;
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
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/goods")
public class GoodsController {
	private static Logger logger = LoggerFactory.getLogger(GoodsController.class);
	@Autowired
	InterFaceService interFaceService;// app接口service
	@Autowired
	XfmanageService xfmanageService;// 配货管理后台+app接口
	@Autowired
	ManageService manageService;
	@Resource
	HttpServletRequest request;
	private final static int pageSize = 5;// 每页显示多少条

	private final static int ONE = 1;

	// 货源详情查询 http://2q4v154598.zicp.vip/epreport/goods/selectSourceDetails.htm
	@ResponseBody
	@RequestMapping(value = "/selectSourceDetails.htm")
	public Map<String, Object> selectSourceDetails(Integer goods_id, Integer user_id) {
		logger.info("come in   /goods /selectSourceDetails.htm");
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		Map<String, Object> jsonObject1 = new HashMap<String, Object>();
		try {
//          String sb = "{" + "    \"goods_id\": \"1\",\"wx_id\": \"o_xR71EEsiiZ7zmG2XXqd_u8FUbE\",\"wx_ids\": \"o_xR71EEsiiZ7zmG2XXqd_u8FUbE\"" + "}";
			String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				jsonObject.put("code", "201");
				return jsonObject;
			}
			JSONObject wxObject = JSONObject.parseObject(sb);
			List<Map<String, Object>> maps = interFaceService.selectliulanjilubiao(wxObject.getString("wx_id"));
			Integer i = 0;
			for (Map<String, Object> map : maps) {
				if (map.get("browse_identification").equals("2")
						&& map.get("browse_data_id").equals(wxObject.getString("goods_id"))) {
					Integer integer = interFaceService.xiugailiulanjiluhuoche(map);
					i = 1;
				}
			}
			if (i == 0) {
				Integer integer = interFaceService.tianjialiulanjiluhuo(wxObject);
			}
			jsonObject1 = interFaceService.selectMyCollectionUser(wxObject);
			jsonObject = interFaceService.selectSourceDetails(wxObject.getString("goods_id"));
			StringBuffer stringBuffer = new StringBuffer();
			// 追加字符串
			stringBuffer.append(jsonObject.get("goods_end_province")).append(jsonObject.get("goods_end_city"))
					.append(jsonObject.get("goods_end_area")).append(jsonObject.get("goods_end_address"));
			System.out.println(stringBuffer.toString());
			jsonObject.put("xiangxidizhi", stringBuffer.toString());
			if (jsonObject1 != null) {
				jsonObject.put("collection", "1");
			} else {
				jsonObject.put("collection", "2");
			}
			jsonObject.put("favorableRate", "暂无");

		} catch (Exception e) {
			logger.error("错误提示(selectSourceDetails)：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		logger.info("leave   /goods /selectSourceDetails.htm");
		jsonObject.put("code", "200");
		return jsonObject;
	}

	// 货源列表查询 http://2q4v154598.zicp.vip/epreport/goods/selectGoods.htm
	@SuppressWarnings({ "null", "unchecked" })
	@ResponseBody
	@RequestMapping(value = "/selectGoods.htm", method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String, Object> selectGoods(
			@RequestParam(defaultValue = "1", required = true, value = "pageNo") int pageNo,
			@RequestParam(defaultValue = "0", required = false, value = "share_shiro") String share_shiro,
			@RequestParam(required = false, value = "province") String province,
			@RequestParam(required = false, value = "city") String city) {
		logger.info("come in /goods/selectGoods.htm");
		System.out.println("pageNo" + pageNo);
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		PageInfo<GoodsList> pageInfo = new PageInfo<>();
		XfAdvertiseHome xfAdvertiseHome =null;
		try {
//			String sb = "{" + "    \"city\": \"济宁市\"," + "    \"desc_time\": \"0\"," + "    \"goods_end_area\": \"不限\","
//					+ "    \"goods_length\": \"不限\"," + "    \"goods_loadingtime\": \"不限\","
//					+ "    \"goods_start_area\": \"济宁市\"," + "    \"goods_type\": \"其他\","
//					+ "    \"goods_vehicletype\": \"不限\"," + "    \"goods_vetype\": \"不限\","
//					+ "    \"goods_wight\": \"不限\"," + "    \"province\": \"山东省\"" + "}";
			 String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				// 广告或招商
				guangShang(pageNo, province, city, jsonObject, xfAdvertiseHome);
				PageHelper.startPage(pageNo, pageSize);
				List<GoodsList> resultList = interFaceService.selectGoods();
				pageInfo = new PageInfo<GoodsList>(resultList);
				if (share_shiro.equals("0")) {
					// System.out.println("setPages为1");
					pageInfo.setPages(ONE);
					//pageInfo.getList().addAll((Collection<? extends GoodsList>) xfAdvertiseHome);
				}
			} else {
				JSONObject wxObject = JSONObject.parseObject(sb);
				if (wxObject.getString("goods_wight").equals("不限%")) {
					wxObject.put("goods_wight", "不限");
				}
				if (wxObject.getString("goods_loadingtime").equals("不限%")) {
					wxObject.put("goods_loadingtime", "不限");
				}
				if (wxObject.getString("goods_vetype").equals("不限%")) {
					wxObject.put("goods_vetype", "不限");
				}
				// listjsonObject = interFaceService.selectGoodsShaiXuan(wxObject);
				List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
				if ((!wxObject.getString("goods_wight").equals("不限"))
						&& (!wxObject.getString("goods_wight").equals("不限%"))) {
					String string = wxObject.getString("goods_wight").substring(3,
							wxObject.getString("goods_wight").length());
					List<String> list = Arrays.asList(string.split("%"));
					for (String s : list) {
						List<String> list1 = Arrays.asList(s.split("-"));
						List<String> arrList = new ArrayList<>(list1);
						if (arrList.size() == 1) {
							arrList.add("0.66");
						}
						System.out.println(arrList);
						Map<String, Object> map = new HashMap<>();
						map.put("min_number", Double.parseDouble(arrList.get(0)));
						map.put("max_number", Double.parseDouble(arrList.get(1)));
						maps.add(map);
					}
				}
//                wxObject.put("goods_number",maps);
				String string = "不限";
				if ((!wxObject.getString("goods_loadingtime").equals("不限"))
						&& (!wxObject.getString("goods_loadingtime").equals("不限%"))) {
					string = wxObject.getString("goods_loadingtime").substring(3,
							wxObject.getString("goods_loadingtime").length());
				}
				List<String> list1 = Arrays.asList(string.split("%"));
				if (!wxObject.getString("goods_length").equals("不限")) {
					String str = wxObject.getString("goods_length").substring(0,
							wxObject.getString("goods_length").length() - 1);
					wxObject.put("goods_length", str);
				}
				String string1 = "不限";
				if ((!wxObject.getString("goods_vetype").equals("不限"))
						&& (!wxObject.getString("goods_vetype").equals("不限%"))) {
					string1 = wxObject.getString("goods_vetype").substring(3,
							wxObject.getString("goods_vetype").length());
				}
				// 广告或招商
				guangShang(pageNo, wxObject.getString("province"), wxObject.getString("city"), jsonObject,
						xfAdvertiseHome);
				PageHelper.startPage(pageNo, pageSize);
				List<String> list2 = Arrays.asList(string1.split("%"));
				List<GoodsList> resultList = interFaceService.selectGoodsShaiXuan(wxObject, maps, list1, list2);
				// System.out.println(resultList);
				// List<GoodsList>resultList =
				// interFaceService.selectGoodsShaiXuan2(wxObject,min_number,max_number);
				pageInfo = new PageInfo<GoodsList>(resultList);
				if (share_shiro.equals("0")) {
					System.out.println("setPages为1");
					pageInfo.setPages(ONE);
				}

			}
		} catch (Exception e) {
			logger.error("错误提示(selectGoods)：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		jsonObject.put("data", pageInfo);
		jsonObject.put("code", "200");
		logger.info("leave   /goods /selectGoods.htm");
		return jsonObject;
	}

	private void guangShang(int pageNo, String province, String city, Map<String, Object> jsonObject,
			XfAdvertiseHome xfAdvertiseHome) {
		Random random = new Random();
		int countSize = 0;
		int count=0;
		int count1=0;
		if (!StringUtils.isBlank(province) && !StringUtils.isBlank(city)) {
			count = xfmanageService.selectCount(ONE, province, city);
			count1=xfmanageService.selectXfCount(ONE, province, city);
			// 查询广告第一条 始终要是自己公司的
			if(pageNo==1) {
				xfAdvertiseHome=xfmanageService.selectXfGuangGao();
			}
			else if(count1>0){
				xfAdvertiseHome = xfmanageService.selectGuangGao(pageNo-1, province, city);	
			}else if(count1==0) {
				xfAdvertiseHome = xfmanageService.selectGuangGao(pageNo, province, city);	
			}
			 if (pageNo > 1 && xfAdvertiseHome == null&& pageNo>count) {
				if (count > 0) {
					countSize = random.nextInt(count) + 1;
					xfAdvertiseHome = xfmanageService.selectGuangGao(countSize, province, city);
				}
			 }if (pageNo == 1 && xfAdvertiseHome == null) {
				if (count > 0) {
					xfAdvertiseHome = xfmanageService.selectGuangGao(pageNo, province, city);
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

	// 发布货源
	@ResponseBody
	@RequestMapping("/releaseSource.htm")
	public Map<String, Object> releaseSource() {
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		logger.info("come in   /goods /releaseSource.htm");
		try {
//			// 测试数据
//			String sb = "{" + "    \"goods_Detailedtype\": \"金属钢材\"," + "    \"goods_contactinformation\": \"1366666\","
//					+ "    \"goods_contacts\": \"张三\"," + "    \"goods_detailed\": \"哈哈哈哈糍粑\","
//					+ "    \"goods_end__address\": \"呵呵\"," + "    \"goods_end__area\": \"白河县\","
//					+ "    \"goods_end__city\": \"安康市\"," + "    \"goods_end_province\": \"陕西省\","
//					+ "    \"goods_length\": \"不限\"," + "    \"goods_loadingtime\": \"2019-03-22 21:49\","
//					+ "    \"goods_name\": \"矿石\"," + "    \"goods_number\": \"66.6\","
//					+ "    \"goods_number_mi\": \"33\"," + "    \"goods_start_address\": \"哈哈\","
//					+ "    \"goods_start_area\": \"嘉祥县\"," + "    \"goods_start_city\": \"济宁市\","
//					+ "    \"goods_start_province\": \"山东省\"," + "    \"goods_time\": \"\","
//					+ "    \"goods_type\": \"重货\"," + "    \"goods_vehicletype\": \"整车\","
//					+ "    \"goods_vetype\": \"不限 危险品 \"," + "    \"goods_wx_id\": \"o_xR71EEsiiZ7zmG2XXqd_u8FUbE\""
//					+ "}";
			String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				jsonObject.put("code", "201");
				return jsonObject;
			}

			GoodsJson car = JSON.parseObject(sb, GoodsJson.class);

			StringBuffer stringBuffer = new StringBuffer();
			StringBuffer stringBuffer1 = new StringBuffer();

			// 追加字符串
			stringBuffer.append(car.getGoods_start_city()).append(car.getGoods_start_area());
			stringBuffer1.append(car.getGoods_end__city()).append(car.getGoods_end__area());
			System.out.println(stringBuffer);
			System.out.println(stringBuffer1);
			car.setGoods_start(stringBuffer.toString());
			car.setGoods_end(stringBuffer1.toString());
			System.out.println(car.getGoods_start());
			System.out.println(car.getGoods_end());

			// 修改
			car.setGoods_time(DateUtil.getTime());
			int i = interFaceService.releaseSource(car);
			if (i != 1) {
				jsonObject.put("code", "203");
				return jsonObject;
			}
			// System.out.println("i" + i);
		} catch (Exception e) {
			logger.error("错误提示(releaseSource)：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		logger.info("leave   /goods /releaseSource.htm");
		jsonObject.put("code", "200");
		return jsonObject;
	}

}