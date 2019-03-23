package com.fec.epreport.pojo;

import java.io.Serializable;

//货源信息
public class GoodsJson implements Serializable {
	// 序列化实例化
	private static final long serialVersionUID = 1L;
	// 出发-省
	private String goods_start_province;
	// 出发-市
	private String goods_start_city;
	// 出发-区
	private String goods_start_area;
	// 出发-详细地址
	private String goods_start_address;
	// 终点-省
	private String goods_end_province;
	// 终点-市
	private String goods_end__city;
	// 终点-区
	private String goods_end__area;
	// 终点-详细地址
	private String goods_end__address;
	// 联系人
	private String goods_contacts;
	// 联系电话
	private String goods_contactinformation;
	// 货物类型
	private String goods_type;
	// 车型
	private String goods_vetype;
	// 用车类型
	private String goods_vehicletype;
	// 详细类型
	private String goods_Detailedtype;
	// 详细描述
	private String goods_detailed;
	// 车长
	private String goods_length;
	// 货物名称
	private String goods_name;
	// 货物数量(吨)
	private String goods_number;
	// 货物数量(立方米)
	private String goods_number_mi;
	// 发布时间
	private String goods_time;
	// 装货时间
	private String goods_loadingtime;
	// 微信id
	private String goods_wx_id;

	public String getGoods_start_province() {
		return goods_start_province;
	}

	public void setGoods_start_province(String goods_start_province) {
		this.goods_start_province = goods_start_province;
	}

	public String getGoods_start_city() {
		return goods_start_city;
	}

	public void setGoods_start_city(String goods_start_city) {
		this.goods_start_city = goods_start_city;
	}

	public String getGoods_start_area() {
		return goods_start_area;
	}

	public void setGoods_start_area(String goods_start_area) {
		this.goods_start_area = goods_start_area;
	}

	public String getGoods_start_address() {
		return goods_start_address;
	}

	public void setGoods_start_address(String goods_start_address) {
		this.goods_start_address = goods_start_address;
	}

	public String getGoods_end_province() {
		return goods_end_province;
	}

	public void setGoods_end_province(String goods_end_province) {
		this.goods_end_province = goods_end_province;
	}

	public String getGoods_end__city() {
		return goods_end__city;
	}

	public void setGoods_end__city(String goods_end__city) {
		this.goods_end__city = goods_end__city;
	}

	public String getGoods_end__area() {
		return goods_end__area;
	}

	public void setGoods_end__area(String goods_end__area) {
		this.goods_end__area = goods_end__area;
	}

	public String getGoods_end__address() {
		return goods_end__address;
	}

	public void setGoods_end__address(String goods_end__address) {
		this.goods_end__address = goods_end__address;
	}

	public String getGoods_contacts() {
		return goods_contacts;
	}

	public void setGoods_contacts(String goods_contacts) {
		this.goods_contacts = goods_contacts;
	}

	public String getGoods_contactinformation() {
		return goods_contactinformation;
	}

	public void setGoods_contactinformation(String goods_contactinformation) {
		this.goods_contactinformation = goods_contactinformation;
	}

	public String getGoods_type() {
		return goods_type;
	}

	public void setGoods_type(String goods_type) {
		this.goods_type = goods_type;
	}

	public String getGoods_vetype() {
		return goods_vetype;
	}

	public void setGoods_vetype(String goods_vetype) {
		this.goods_vetype = goods_vetype;
	}

	public String getGoods_vehicletype() {
		return goods_vehicletype;
	}

	public void setGoods_vehicletype(String goods_vehicletype) {
		this.goods_vehicletype = goods_vehicletype;
	}

	public String getGoods_Detailedtype() {
		return goods_Detailedtype;
	}

	public void setGoods_Detailedtype(String goods_Detailedtype) {
		this.goods_Detailedtype = goods_Detailedtype;
	}

	public String getGoods_detailed() {
		return goods_detailed;
	}

	public void setGoods_detailed(String goods_detailed) {
		this.goods_detailed = goods_detailed;
	}

	public String getGoods_length() {
		return goods_length;
	}

	public void setGoods_length(String goods_length) {
		this.goods_length = goods_length;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_number() {
		return goods_number;
	}

	public void setGoods_number(String goods_number) {
		this.goods_number = goods_number;
	}

	public String getGoods_number_mi() {
		return goods_number_mi;
	}

	public void setGoods_number_mi(String goods_number_mi) {
		this.goods_number_mi = goods_number_mi;
	}

	public String getGoods_time() {
		return goods_time;
	}

	public void setGoods_time(String goods_time) {
		this.goods_time = goods_time;
	}

	public String getGoods_loadingtime() {
		return goods_loadingtime;
	}

	public void setGoods_loadingtime(String goods_loadingtime) {
		this.goods_loadingtime = goods_loadingtime;
	}

	public String getGoods_wx_id() {
		return goods_wx_id;
	}

	public void setGoods_wx_id(String goods_wx_id) {
		this.goods_wx_id = goods_wx_id;
	}

	@Override
	public String toString() {
		return "GoodsJson [goods_start_province=" + goods_start_province + ", goods_start_city=" + goods_start_city
				+ ", goods_start_area=" + goods_start_area + ", goods_start_address=" + goods_start_address
				+ ", goods_end_province=" + goods_end_province + ", goods_end__city=" + goods_end__city
				+ ", goods_end__area=" + goods_end__area + ", goods_end__address=" + goods_end__address
				+ ", goods_contacts=" + goods_contacts + ", goods_contactinformation=" + goods_contactinformation
				+ ", goods_type=" + goods_type + ", goods_vetype=" + goods_vetype + ", goods_vehicletype="
				+ goods_vehicletype + ", goods_Detailedtype=" + goods_Detailedtype + ", goods_detailed="
				+ goods_detailed + ", goods_length=" + goods_length + ", goods_name=" + goods_name + ", goods_number="
				+ goods_number + ", goods_number_mi=" + goods_number_mi + ", goods_time=" + goods_time
				+ ", goods_loadingtime=" + goods_loadingtime + ", goods_wx_id=" + goods_wx_id + "]";
	}

	public GoodsJson(String goods_start_province, String goods_start_city, String goods_start_area,
			String goods_start_address, String goods_end_province, String goods_end__city, String goods_end__area,
			String goods_end__address, String goods_contacts, String goods_contactinformation, String goods_type,
			String goods_vetype, String goods_vehicletype, String goods_Detailedtype, String goods_detailed,
			String goods_length, String goods_name, String goods_number, String goods_number_mi, String goods_time,
			String goods_loadingtime, String goods_wx_id) {
		super();
		this.goods_start_province = goods_start_province;
		this.goods_start_city = goods_start_city;
		this.goods_start_area = goods_start_area;
		this.goods_start_address = goods_start_address;
		this.goods_end_province = goods_end_province;
		this.goods_end__city = goods_end__city;
		this.goods_end__area = goods_end__area;
		this.goods_end__address = goods_end__address;
		this.goods_contacts = goods_contacts;
		this.goods_contactinformation = goods_contactinformation;
		this.goods_type = goods_type;
		this.goods_vetype = goods_vetype;
		this.goods_vehicletype = goods_vehicletype;
		this.goods_Detailedtype = goods_Detailedtype;
		this.goods_detailed = goods_detailed;
		this.goods_length = goods_length;
		this.goods_name = goods_name;
		this.goods_number = goods_number;
		this.goods_number_mi = goods_number_mi;
		this.goods_time = goods_time;
		this.goods_loadingtime = goods_loadingtime;
		this.goods_wx_id = goods_wx_id;
	}

	public GoodsJson() {
		super();
		// TODO Auto-generated constructor stub
	}

	// private Double goods_long;
	// private Double goods_lot;

}
