package com.fec.epreport.dao;

import com.fec.epreport.pojo.XfAdvertiseHome;
import com.fec.epreport.pojo.XfBusinessCenter;

public interface XfmanageDao {

	//查询广告
	public XfAdvertiseHome selectGuangGao(int pageNo);
	//查询招商
	public XfBusinessCenter selectZhaoShang();

}