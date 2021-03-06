package com.fec.epreport.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.fec.epreport.dao.XfmanageDao;
import com.fec.epreport.pojo.XfAdvertiseHome;
import com.fec.epreport.pojo.XfBusinessCenter;
import com.fec.epreport.service.XfmanageService;

@Service("xfmanageService")
public class XfmanageServiceImpl implements XfmanageService {

	private static final Logger log = Logger.getLogger(XfmanageServiceImpl.class);

	@Autowired
	XfmanageDao xfmanageDao;

	@Override
	public XfAdvertiseHome selectGuangGao(int pageNo, String province, String city) {
		XfAdvertiseHome xfAdvertiseHome = null;
		try {
			xfAdvertiseHome = xfmanageDao.selectGuangGao(pageNo - 1, province, city);
		} catch (DataAccessException d) {
			log.info("查询广告接口错误：" + d.getLocalizedMessage());
		}
		return xfAdvertiseHome;
	}

	@Override
	public XfBusinessCenter selectZhaoShang() {
		XfBusinessCenter xfBusinessCenter = null;
		try {
			xfBusinessCenter = xfmanageDao.selectZhaoShang();
		} catch (DataAccessException d) {
			log.info("查询招商接口错误：" + d.getLocalizedMessage());
		}
		return xfBusinessCenter;
	}

	@Override
	public int selectCount(int pageNo, String province, String city) {
		int count = 0;
		try {
			count = xfmanageDao.selectCount(pageNo- 1, province, city);
		} catch (DataAccessException d) {
			log.info("查询广告条数错误：" + d.getLocalizedMessage());
		}
		return count;
	}

	@Override
	public XfAdvertiseHome selectXfGuangGao() {
		XfAdvertiseHome xfAdvertiseHome = null;
		try {
			xfAdvertiseHome = xfmanageDao.selectXfGuangGao();
		} catch (DataAccessException d) {
			log.info("查询广告接口错误：" + d.getLocalizedMessage());
		}
		return xfAdvertiseHome;
	}

	@Override
	public int selectXfCount(int pageNo, String province, String city) {
		int count1 = 0;
		try {
			count1 = xfmanageDao.selectXfCount(pageNo- 1, province, city);
		} catch (DataAccessException d) {
			log.info("查询广告条数错误：" + d.getLocalizedMessage());
		}
		return count1;
	}

}
