package com.fec.epreport.controller.interFace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.fec.epreport.dao.JedisClient;
import com.fec.epreport.util.commons.PureNetUtil;


/**
 * 接收json用测试接口
 * 
 * @author zcy
 *
 */
@Controller
@RequestMapping("/stationInterface")  
public class StationInterFaceConttroller {
	private static Logger logger = LoggerFactory.getLogger(StationInterFaceConttroller.class);
	@Autowired
	JedisClient jedisClient;
	
	private final static String REDIS_STATION = "Station_Redis";
	@ResponseBody
	@RequestMapping(value = "/stationInterfaceMation.htm", method = RequestMethod.GET)
	public Map<String, Object> getString(HttpServletRequest request) {
		logger.info("进入/station/stationInfomation.htm");
		Map<String, Object> jsonObject = new HashMap<String, Object>(); // 创建Json对象
		try {
//			String sb = PureNetUtil.buffJson(request);
//			if ("".equals(sb.toString())) {
//				jsonObject.put("code", "201");
//				return jsonObject;
//			}
	        List<Map<String,Object>> listjsonObject = new ArrayList<Map<String,Object>>();
	        Map<String, Object> map1 = new HashMap<String, Object>();
	        map1.put("1", "a");
	        map1.put("2", "b");
	        map1.put("3", "c");
	        listjsonObject.add(map1);

	        Map<String, Object> map2 = new HashMap<String, Object>();
	        map2.put("11", "aa");
	        map2.put("22", "bb");
	        map2.put("33", "cc");
	        listjsonObject.add(map2);
	        String hashmap =listjsonObject.toString();
	        String sda="station_name";
			//long bc = jedisClient.hset(REDIS_STATION, sda,hashmap);
			String b = jedisClient.hget(REDIS_STATION, sda);
			System.out.println("b"+b);
			//System.out.println("bc"+bc);
				//WxUser user = JSON.parseObject(sb, WxUser.class);
				//interFaceService.insertWxUser(user);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		logger.info("leave /station/stationInfomation.htm");
		jsonObject.put("code", "200");
		return jsonObject;
	}
}