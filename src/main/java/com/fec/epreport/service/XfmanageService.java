package com.fec.epreport.service;

import com.fec.epreport.pojo.XfAdvertiseHome;
import com.fec.epreport.pojo.XfBusinessCenter;

public interface XfmanageService {

	//查询广告
	public XfAdvertiseHome selectGuangGao(int pageNo);

	//查询招商
	public XfBusinessCenter selectZhaoShang();

}
