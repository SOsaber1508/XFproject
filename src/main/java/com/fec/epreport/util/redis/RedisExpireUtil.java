package com.fec.epreport.util.redis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * 获取缓存失效时间工具类
 * 
 * @author zcy
 *
 */
public class RedisExpireUtil {
	/**
	 * 根据分钟来获取缓存失效时间（秒）
	 * 
	 * @param minutes
	 *            分钟
	 * @return 秒
	 */
	public static int getExpireTimeByMinutes(int minutes) {
		if (minutes <= 0) {
			minutes = 30;
		}
		int res = minutes * 60;
		return res;
	}

	/**
	 * 根据小时来获取缓存失效时间（秒）
	 * 
	 * @param hours
	 *            小时
	 * @return 秒
	 */
	public static int getExpireTimeByHours(int hours) {
		if (hours <= 0) {
			hours = 1;
		}
		int res = hours * 3600;
		return res;
	}

	/**
	 * 根据天来获取缓存失效时间（秒）
	 * 
	 * @param days
	 *            天
	 * @return 秒
	 */
	public static int getExpireTimeByDays(int days) {
		if (days <= 0) {
			days = 1;
		}
		int res = days * 86400;
		return res;
	}

	/**
	 * 根据自定义时间来获取缓存失效时间（秒）
	 * 
	 * @param date
	 *            自定义时间（格式：yyyymmddhh24miss）
	 * @return 秒
	 */
	public static int getExpireTimeByCustomDate(String date) {
		// 默认10分钟
		int getTime = 600;
		// date为空或者非数字直接返回默认10分钟
		if (StringUtils.isBlank(date) || !StringUtils.isNumeric(date)) {
			return getTime;
		}
		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
			Date da = sf.parse(date);
			getTime = (int) ((da.getTime() - System.currentTimeMillis()) / 1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// date时间小于当前时间直接返回默认10分钟
		if (getTime <= 0) {
			getTime = 600;
		}
		return getTime;
	}

	/**
	 * 当天有效 获取缓存当天有效,缓存失效时间 设置有效时间至次日00：05：00
	 * 
	 * @return 秒
	 */
	public static long getTodayExpireTime() {
		try {
			// 获取当前日期
			Date date = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			// 获取下一天日期
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, 1);
			String nextDate_2 = sf.format(cal.getTime()).toString();
			date = sdf.parse((nextDate_2 + " 00:05:00"));
			int getTime = (int) ((date.getTime() - System.currentTimeMillis()) / 1000);
			return getTime;
		} catch (Exception e) {
			e.printStackTrace();
			// 如果异常 默认返回有效期24小时
			return 24 * 60 * 60;
		}

	}

	/**
	 * 当月有效 失效时间至月底
	 * 
	 * @return 秒
	 */
	public static long getMonthExpireTime() {
		try {
			// 获取当前日期
			Date date = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, 1);
			String preMonth = sf.format(cal.getTime());
			date = sdf.parse(preMonth + "/01 00:05:00");
			int getTime = (int) ((date.getTime() - System.currentTimeMillis()) / 1000);
			return getTime;
		} catch (Exception e) {
			e.printStackTrace();
			// 如果异常 默认返回有效期30天
			return 30 * 24 * 60 * 60;
		}
	}

	/**
	 * 当年有效 永久有效(方法中实现使用1年有效时长)
	 * 
	 * @return
	 */
	public static int getYearExpireTime() {
		try {
			Calendar cal = Calendar.getInstance();
			Date dateTime = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			cal.add(Calendar.YEAR, 1);
			String year = sf.format(cal.getTime());
			dateTime = sdf.parse(year + "/01/01 00:05:00");
			int getTime = (int) ((dateTime.getTime() - System.currentTimeMillis()) / 1000);
			return getTime;
		} catch (Exception e) {
			e.printStackTrace();
			// 如果异常 默认返回有效期300天
			return 300 * 24 * 60 * 60;
		}
	}

	public static void main(String[] args) {
		System.out.println("分钟" + RedisExpireUtil.getExpireTimeByMinutes(12));
		System.out.println("小时" + RedisExpireUtil.getExpireTimeByHours(2) / 3600);
		System.out.println("天" + RedisExpireUtil.getExpireTimeByDays(2) / 3600);
		System.out.println("自定义时间" + RedisExpireUtil.getExpireTimeByCustomDate("20180627181212") / 3600);
		System.out.println("today" + RedisExpireUtil.getTodayExpireTime() / 3600);
		System.out.println("month" + RedisExpireUtil.getMonthExpireTime() / 3600 / 24);
		System.out.println("year" + RedisExpireUtil.getYearExpireTime() / 3600 / 24);
	}
}