package com.fec.epreport.pojo;

import java.io.Serializable;

//用户表
/**
 * @author Administrator
 *
 */
public class WxUser implements Serializable {


	// 序列化实例化
	private static final long serialVersionUID = 1L;

	private String wx_sex;
	private String wx_city;
	private String wx_province;
	private String wx_country;
	private String wx_headimgurl;
	private String wx_id;
	private String wx_nickname;
	private String wx_openid;
	
	public WxUser(String wx_sex, String wx_city, String wx_province, String wx_country, String wx_headimgurl,
			String wx_id, String wx_nickname, String wx_openid) {
		super();
		this.wx_sex = wx_sex;
		this.wx_city = wx_city;
		this.wx_province = wx_province;
		this.wx_country = wx_country;
		this.wx_headimgurl = wx_headimgurl;
		this.wx_id = wx_id;
		this.wx_nickname = wx_nickname;
		this.wx_openid = wx_openid;
	}


	public WxUser() {
		super();
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getWx_headimgurl() {
		return wx_headimgurl;
	}

	public void setWx_headimgurl(String wx_headimgurl) {
		this.wx_headimgurl = wx_headimgurl;
	}

	public String getWx_nickname() {
		return wx_nickname;
	}

	public void setWx_nickname(String wx_nickname) {
		this.wx_nickname = wx_nickname;
	}

	public String getWx_city() {
		return wx_city;
	}

	public void setWx_city(String wx_city) {
		this.wx_city = wx_city;
	}

	public String getWx_province() {
		return wx_province;
	}

	public void setWx_province(String wx_province) {
		this.wx_province = wx_province;
	}

	public String getWx_country() {
		return wx_country;
	}

	public void setWx_country(String wx_country) {
		this.wx_country = wx_country;
	}

	public String getWx_sex() {
		return wx_sex;
	}

	public void setWx_sex(String wx_sex) {
		this.wx_sex = wx_sex;
	}

	public String getWx_id() {
		return wx_id;
	}

	public void setWx_id(String wx_id) {
		this.wx_id = wx_id;
	}

	public String getWx_openid() {
		return wx_openid;
	}

	public void setWx_openid(String wx_openid) {
		this.wx_openid = wx_openid;
	}

	@Override
	public String toString() {
		return "WxUser [wx_sex=" + wx_sex + ", wx_city=" + wx_city + ", wx_province=" + wx_province + ", wx_country="
				+ wx_country + ", wx_headimgurl=" + wx_headimgurl + ", wx_id=" + wx_id + ", wx_nickname=" + wx_nickname
				+ ", wx_openid=" + wx_openid + "]";
	}

}