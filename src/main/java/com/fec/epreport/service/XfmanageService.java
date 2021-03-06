package com.fec.epreport.service;

import com.fec.epreport.pojo.XfAdvertiseHome;
import com.fec.epreport.pojo.XfBusinessCenter;

public interface XfmanageService {

	// 查询广告
	public XfAdvertiseHome selectGuangGao(int pageNo, String province, String city);

	// 查询招商
	public XfBusinessCenter selectZhaoShang();

	// 拿一下条数
	public int selectCount(int pageNo, String province, String city);

	//查system的广告
	public XfAdvertiseHome selectXfGuangGao();

	//查system的条数
	public int selectXfCount(int one, String province, String city);

}
