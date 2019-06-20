package com.fec.epreport.controller.cooperationIn;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fec.epreport.util.commons.PureNetUtil;


/**
 * 接收json用测试接口
 * 
 * @author zcy
 *
 */
@Controller
@RequestMapping("/station")  
public class StationConttroller {
	private static Logger logger = LoggerFactory.getLogger(StationConttroller.class);
	
	@ResponseBody
	@RequestMapping(value = "/stationInfomation.htm", method = RequestMethod.POST)
	public Map<String, Object> getString(HttpServletRequest request) {
		logger.info("进入/station/stationInfomation.htm");
		Map<String, Object> jsonObject = new HashMap<String, Object>(); // 创建Json对象
		try {
			String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				jsonObject.put("code", "201");
				return jsonObject;
			}
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