package com.fec.epreport.dao;

/*一般第一次访问的时候先从数据库读取数据，然后将数据写入到缓存，
 * 再次访问同一内容的时候就从缓存中读取，如果缓存中没有则从数据库中读取
 *所以我们添加缓存逻辑的时候，从数据库中将内容读取出来之后，先set入缓存，然后再从缓存中添加读取行为，如果缓存为空则从数据库中进行读取
*/
public interface JedisClient {
	String get(String key);// 读取数据-根据key查询

	String set(String key, String value);// 写入数据-key-value

	String hget(String hkey, String key);// 获取存储结构是hashMap类型的操作

	long hset(String hkey, String key, String value); // 和上面的相反是存储

	long incr(String key);// value加一

	long expire(String key, int second);// 设罝缓存生存时间-根据key设置生存时间(s)

	long ttl(String key);// 键的剩余时间-查看某个key的剩余生存时间,单位【秒】.永久生存或者不存在的都返回-1

	long del(String key); // 删除数据-根据key

	long hdel(String hkey, String key);// 删除hashMap类型-根据hkey,key
}
