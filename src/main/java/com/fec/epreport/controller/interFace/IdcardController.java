/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.fec.epreport.controller.interFace;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fec.epreport.dao.JedisClient;
import com.fec.epreport.util.baidu.BaiduHttpUtil;
import com.fec.epreport.util.baidu.Base64Util;
import com.fec.epreport.util.baidu.TokenUtil;
import com.fec.epreport.util.commons.FileUtil;
import com.fec.epreport.util.commons.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 身份证识别
 */
@Controller
@RequestMapping(value = "/baiduIDcard")
public class IdcardController {
	private static Logger logger = LoggerFactory.getLogger(IdcardController.class);

	@Autowired
	private JedisClient jedisClient;
	// 静态变量redis百度云票据
	private static String BdRedis = "Access_token";

	/**
	 * 重要提示代码中所需工具类 FileUtil,Base64Util,HttpUtil,GsonUtils请从
	 * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
	 * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
	 * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
	 * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3 下载
	 */
	@ResponseBody
	@RequestMapping(value = "/ceshi.htm", method = RequestMethod.GET)
	public JSONObject baiduIDcard() {
		JSONObject json = new JSONObject();
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
			// 24.af8e6bb0b02c0baf5f6c4707b6e2fda5.2592000.1553765130.282335-15632473
			String accessToken;
			// 调百度云tokenUtil
			accessToken = TokenUtil.IDcard();
			if (!StringUtils.isBlank(accessToken)) {
				jedisClient.del(BdRedis);
				jedisClient.set(BdRedis, accessToken);
				logger.info("redis删除+添加新的");
			} else {
				accessToken = jedisClient.get(BdRedis);
				logger.info("票据没过期直接读redis里的");
			}
			// 结果
			JSONObject resultObject = JSONObject
					.fromObject(BaiduHttpUtil.post(idcardIdentificate, accessToken, params));
			System.out.println(resultObject);
			JSONObject param = new JSONObject();
			param = resultObject.getJSONObject("words_result");
			// getJSONObject("姓名");
			HashMap<String, String> resultmap = new HashMap<>();
			resultmap.put("Home", param.getJSONObject("住址").getString("words"));// 住址
			resultmap.put("Birthday", param.getJSONObject("出生").getString("words"));// 出生
			resultmap.put("IDcard", param.getJSONObject("公民身份号码").getString("words"));// 公民身份号码
			resultmap.put("Sex", param.getJSONObject("性别").getString("words"));// 性别
			resultmap.put("code", "200");// 性别
			System.out.println(resultmap);
			// net.sf.json.JSONObject 将Map转换为JSON方法
			json = JSONObject.fromObject(resultmap);
			
		} catch (Exception e) {
			json.put("code", "201");
			logger.error(e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * Base64对字符串和文件流的编码和解码：
	 * 
	 * @param arg
	 * @throws IOException
	 */
	public static void main(String arg[]) throws IOException {
		// 1.字符串的编码
		String base64 = Base64.getEncoder().encodeToString("asdsadadad".getBytes("utf-8"));
		// 可以将字符串转成Base64格式的串
		System.out.println(base64);
		// 2.字符串解码
		String str = new String(Base64.getDecoder().decode(
				"SmF2YTggQmFzZTY0IEphdmEgOCDmlrDnibnmgKcg5ZyoSmF2YSA45LitLEJhc2U2NOe8lueggeW3sue7j+aIkOS4ukphdmHnsbvlupPnmoTmoIflh4bjgIIgSmF2YSA4IOWGhee9ruS6hiBCYXNlNjQg57yW56CB55qE57yW56CB5Zmo5ZKM6Kej56CB5Zmo44CCIEJhc2U2NOW3peWFt+exu+aPkOS+m+S6huS4gOWll+mdmeaAgS4uLg=="),
				"UTF-8");
		// 对Base64的串实现解码
		System.out.println(str);

		// 3.文件实现Base64编码
		File file = new File("C:\\Users\\Loufree\\Desktop\\1.png");
		// 使用了非阻塞的java.nio工具包，以上是将1.png图片转成base64编码
		byte[] b = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
		String base64Str = Base64.getEncoder().encodeToString(b);
		// 对Base64的串实现解码
		System.out.println(base64Str);
		
		//4. Base64解码成文件
		String str1 = "ZG9ja2VyIGVjbGlwc2Xmj5Lku7YNCuWQjeensO+8mmRvY2tlci1uaWdodGx5DQrlnLDlnYDvvJpodHRwOi8vZG93bmxvYWQuZWNsaXBzZS5vcmcvbGludXh0b29scy91cGRhdGVzLWRvY2tlci1uaWdodGx5Lw==";
		Files.write(Paths.get("D:/create.txt"), Base64.getDecoder().decode(str), StandardOpenOption.CREATE);
		//使用了非阻塞的java.nio工具包，Base64解码成文件。
		System.out.println(str1);		
	}

}
