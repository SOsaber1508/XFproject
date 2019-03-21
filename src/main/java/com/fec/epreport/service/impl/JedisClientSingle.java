package com.fec.epreport.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.fec.epreport.dao.JedisClient;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/*一般第一次访问的时候先从数据库读取数据，然后将数据写入到缓存，再次访问同一内容的时候就从缓存中读取，如果缓存中没有则从数据库中读取
	所以我们添加缓存逻辑的时候，从数据库中将内容读取出来之后，先set入缓存，然后再从缓存中添加读取行为，如果缓存为空则从数据库中进行读取
*/
public class JedisClientSingle implements JedisClient {

	@Autowired
	JedisPool jedisPool;

	// 读取数据
	@Override
	public String get(String key) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.get(key);
		jedis.close();
		return string;
	}

	// 写入数据
	@Override
	public String set(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.set(key, value);
		jedis.close();
		return string;
	}

	// 获取存储结构是hashMap类型的操作
	@Override
	public String hget(String hkey, String key) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.hget(hkey, key);
		jedis.close();
		return string;
	}

	// 存储hashMap
	@Override
	public long hset(String hkey, String key, String value) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hset(hkey, key, value);
		jedis.close();
		return result;
	}

	@Override
	public long incr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.incr(key);
		jedis.close();
		return result;
	}

	// 设罝缓存生存时间
	@Override
	public long expire(String key, int second) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.expire(key, second);
		jedis.close();
		return result;
	}

	@Override
	public long ttl(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.ttl(key);
		jedis.close();
		return result;
	}

	// 删除数据
	@Override
	public long del(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.del(key);
		jedis.close();
		return result;
	}

	@Override
	public long hdel(String hkey, String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hdel(hkey, key);
		jedis.close();
		return result;
	}

}