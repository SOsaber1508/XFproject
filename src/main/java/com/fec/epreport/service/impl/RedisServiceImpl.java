package com.fec.epreport.service.impl;

import com.fec.epreport.dao.JedisClient;
import com.fec.epreport.entity.User;
import com.fec.epreport.service.RedisService;
import com.fec.epreport.util.commons.JsonUtils;
import com.fec.epreport.util.commons.StringUtils;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("redisService")
public class RedisServiceImpl implements RedisService {
	private static Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

	@Autowired
	JedisClient jedisClient;
	@Override
	public List<User> getUserList(int redisID) {
		logger.info("开始了");
		try {
			// 从缓存中获取值
			String text = jedisClient.hget("cesi2", "6667");
			// String getData = jedisClient.hget(CONTENTCATEGORYID, redisID+"");
			if (!StringUtils.isBlank(text)) {
				logger.info("不为空进判断了");
				//return null;
			}
			// 向缓存中放入值
			JSONObject param1 = new JSONObject();
			param1.put("soap", "22222");
			String jsonData = JsonUtils.toJson(param1);
			jedisClient.hset("cesi2", "6667", jsonData);
			logger.info("结束");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		return null;
	}

}