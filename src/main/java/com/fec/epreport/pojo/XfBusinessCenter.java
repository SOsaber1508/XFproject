/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.fec.epreport.pojo;

import java.io.Serializable;

/**
 * 招商表Entity
 * 
 * @author zcy
 * @version 2019-06-24
 */
public class XfBusinessCenter implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;	//主键
	private String pic; // 招商图片
	private String designId; // 招商关联素材id
	private Integer delFlag; // 删除标志位0未删除1已删除
	//private String title;
	//private String company;
	private XfDesignResources design;// 关联的素材

	
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getCompany() {
//		return company;
//	}
//
//	public void setCompany(String company) {
//		this.company = company;
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getDesignId() {
		return designId;
	}

	public void setDesignId(String designId) {
		this.designId = designId;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public XfDesignResources getDesign() {
		return design;
	}

	public void setDesign(XfDesignResources design) {
		this.design = design;
	}

	public XfBusinessCenter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public XfBusinessCenter(String id, String pic, String designId, Integer delFlag, XfDesignResources design) {
		super();
		this.id = id;
		this.pic = pic;
		this.designId = designId;
		this.delFlag = delFlag;
		this.design = design;
	}

	@Override
	public String toString() {
		return "XfBusinessCenter [id=" + id + ", pic=" + pic + ", designId=" + designId + ", delFlag=" + delFlag
				+ ", design=" + design + "]";
	}

}