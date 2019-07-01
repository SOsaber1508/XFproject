package com.fec.epreport.dao;

import org.apache.ibatis.annotations.Param;

import com.fec.epreport.pojo.XfAdvertiseHome;
import com.fec.epreport.pojo.XfBusinessCenter;

public interface XfmanageDao {

	// 查询广告
	public XfAdvertiseHome selectGuangGao(@Param("pageNo") int pageNo, @Param("province") String province,
			@Param("city") String city);

	// 查询招商
	public XfBusinessCenter selectZhaoShang();

	// 查询广告条数
	public int selectCount(@Param("pageNo") int pageNo, @Param("province") String province, @Param("city") String city);

	//查询自己的广告
	public XfAdvertiseHome selectXfGuangGao();

	public int selectXfCount(@Param("pageNo") int pageNo, @Param("province") String province,
			@Param("city") String city);

}