/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.fec.epreport.controller.interFace;

import java.net.URLEncoder;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fec.epreport.dao.JedisClient;
import com.fec.epreport.util.BaiduHttpUtil;
import com.fec.epreport.util.Base64Util;
import com.fec.epreport.util.FileUtil;
import com.fec.epreport.util.StringUtils;
import com.fec.epreport.util.baidu.TokenUtil;


/**
 * 身份证识别
 */
@Controller
@RequestMapping(value = "/baiduIDcard")
public class IdcardController {
	private static Logger logger = LoggerFactory.getLogger(IdcardController.class);

	@Autowired
	private JedisClient jedisClient;
	//静态变量redis百度云票据
	private static String BdRedis="Access_token";
	/**
	 * 重要提示代码中所需工具类 FileUtil,Base64Util,HttpUtil,GsonUtils请从
	 * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
	 * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
	 * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
	 * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3 下载
	 */
	@RequestMapping(value = "/ceshi.htm", method = RequestMethod.GET)
	public String baiduIDcard() {
		// 身份证识别url
		String idcardIdentificate = "https://aip.baidubce.com/rest/2.0/ocr/v1/idcard";
		// 本地图片路径
		String filePath = "d:/demo-card-5.png";
		try {
			byte[] imgData = FileUtil.readFileByBytes(filePath);
			String imgStr = Base64Util.encode(imgData);
			// 识别身份证正面id_card_side=front;识别身份证背面id_card_side=back;
			String params = "id_card_side=front&" + URLEncoder.encode("image", "UTF-8") + "="
					+ URLEncoder.encode(imgStr, "UTF-8");
			/**
			 * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
			 */
			//24.af8e6bb0b02c0baf5f6c4707b6e2fda5.2592000.1553765130.282335-15632473
			 String accessToken; 
			 //调百度云tokenUtil
			 accessToken = TokenUtil.IDcard();
				if (!StringUtils.isBlank(accessToken)) {
					jedisClient.del(BdRedis);
					jedisClient.set(BdRedis,accessToken);
					logger.info("redis删除+添加新的");
				}else {
					accessToken=jedisClient.get(BdRedis);
				}
			String result = BaiduHttpUtil.post(idcardIdentificate, accessToken, params);
			System.out.println(result);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		return null;
	}
	
}
