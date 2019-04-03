package com.fec.epreport.pojo;

import java.io.Serializable;

//货源信息
public class GoodsList implements Serializable {
	// 序列化实例化
	private static final long serialVersionUID = 1L;

	// 用户头像
	private String wx_headimgurl;
	// 出发地
	private String goods_start;
	// 目的地
	private String goods_end;
	// 车长
	private String goods_length;
	// 车型
	private String goods_vetype;
	// 车重
	private String goods_number;
	// 货物名称
	private String goods_name;
	// 装货时间
	private String goods_loadingtime;
	// 联系人
	private String goods_contacts;
	// 时间
	private String goods_time;
	// 联系电话
	private String goods_contactinformation;
	// 货物id
	private int goods_id;
	// 货物用户id
	private String goods_user_id;
	// 微信帐号
	private String wx_name;
	// 用户的微信id
	private String user_id;
	// 用户真实姓名
	private String wx_nickname;
	public String getWx_headimgurl() {
		return wx_headimgurl;
	}
	public void setWx_headimgurl(String wx_headimgurl) {
		this.wx_headimgurl = wx_headimgurl;
	}
	public String getGoods_start() {
		return goods_start;
	}
	public void setGoods_start(String goods_start) {
		this.goods_start = goods_start;
	}
	public String getGoods_end() {
		return goods_end;
	}
	public void setGoods_end(String goods_end) {
		this.goods_end = goods_end;
	}
	public String getGoods_length() {
		return goods_length;
	}
	public void setGoods_length(String goods_length) {
		this.goods_length = goods_length;
	}
	public String getGoods_vetype() {
		return goods_vetype;
	}
	public void setGoods_vetype(String goods_vetype) {
		this.goods_vetype = goods_vetype;
	}
	public String getGoods_number() {
		return goods_number;
	}
	public void setGoods_number(String goods_number) {
		this.goods_number = goods_number;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getGoods_loadingtime() {
		return goods_loadingtime;
	}
	public void setGoods_loadingtime(String goods_loadingtime) {
		this.goods_loadingtime = goods_loadingtime;
	}
	public String getGoods_contacts() {
		return goods_contacts;
	}
	public void setGoods_contacts(String goods_contacts) {
		this.goods_contacts = goods_contacts;
	}
	public String getGoods_time() {
		return goods_time;
	}
	public void setGoods_time(String goods_time) {
		this.goods_time = goods_time;
	}
	public String getGoods_contactinformation() {
		return goods_contactinformation;
	}
	public void setGoods_contactinformation(String goods_contactinformation) {
		this.goods_contactinformation = goods_contactinformation;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_user_id() {
		return goods_user_id;
	}
	public void setGoods_user_id(String goods_user_id) {
		this.goods_user_id = goods_user_id;
	}
	public String getWx_name() {
		return wx_name;
	}
	public void setWx_name(String wx_name) {
		this.wx_name = wx_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getWx_nickname() {
		return wx_nickname;
	}
	public void setWx_nickname(String wx_nickname) {
		this.wx_nickname = wx_nickname;
	}
	@Override
	public String toString() {
		return "GoodsList [wx_headimgurl=" + wx_headimgurl + ", goods_start=" + goods_start + ", goods_end=" + goods_end
				+ ", goods_length=" + goods_length + ", goods_vetype=" + goods_vetype + ", goods_number=" + goods_number
				+ ", goods_name=" + goods_name + ", goods_loadingtime=" + goods_loadingtime + ", goods_contacts="
				+ goods_contacts + ", goods_time=" + goods_time + ", goods_contactinformation="
				+ goods_contactinformation + ", goods_id=" + goods_id + ", goods_user_id=" + goods_user_id
				+ ", wx_name=" + wx_name + ", user_id=" + user_id + ", wx_nickname=" + wx_nickname + "]";
	}
	public GoodsList(String wx_headimgurl, String goods_start, String goods_end, String goods_length,
			String goods_vetype, String goods_number, String goods_name, String goods_loadingtime,
			String goods_contacts, String goods_time, String goods_contactinformation, int goods_id,
			String goods_user_id, String wx_name, String user_id, String wx_nickname) {
		super();
		this.wx_headimgurl = wx_headimgurl;
		this.goods_start = goods_start;
		this.goods_end = goods_end;
		this.goods_length = goods_length;
		this.goods_vetype = goods_vetype;
		this.goods_number = goods_number;
		this.goods_name = goods_name;
		this.goods_loadingtime = goods_loadingtime;
		this.goods_contacts = goods_contacts;
		this.goods_time = goods_time;
		this.goods_contactinformation = goods_contactinformation;
		this.goods_id = goods_id;
		this.goods_user_id = goods_user_id;
		this.wx_name = wx_name;
		this.user_id = user_id;
		this.wx_nickname = wx_nickname;
	}
	public GoodsList() {
		super();
		// TODO Auto-generated constructor stub
	}


}
