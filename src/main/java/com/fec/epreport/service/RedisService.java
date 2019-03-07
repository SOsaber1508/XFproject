package com.fec.epreport.service;

import com.fec.epreport.entity.User;

import java.util.List;

public interface RedisService {
	// redis测试
	public List<User> getUserList(int redisID);
}
