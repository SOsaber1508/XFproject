package com.fec.epreport.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.fec.epreport.dao.XfmanageDao;
import com.fec.epreport.pojo.XfAdvertiseHome;
import com.fec.epreport.service.XfmanageService;

@Service("xfmanageService")
public class XfmanageServiceImpl implements XfmanageService {

	private static final Logger log = Logger.getLogger(XfmanageServiceImpl.class);

	@Autowired
	XfmanageDao xfmanageDao;

	@Override
	public XfAdvertiseHome selectGuangGao(int pageNo) {
		XfAdvertiseHome xfAdvertiseHome = null;
		try {
			xfAdvertiseHome = xfmanageDao.selectGuangGao(pageNo-1);
		} catch (DataAccessException d) {
			log.info("查询广告接口错误：" + d.getLocalizedMessage());
		}
		return xfAdvertiseHome;
	}

}