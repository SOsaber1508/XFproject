package com.fec.epreport.pojo;

import java.io.Serializable;

//完善车源表
/**
 * @author Administrator
 *
 */
public class CarInformation implements Serializable {

	// 序列化实例化
	private static final long serialVersionUID = 1L;

	// 用户车辆长度
	private String user_conductor;
	// 用户车型
	private String user_vehicletype;
	// 用户车辆载重
	private String user_load;
	//微信id
	private String wx_id;

	public String getUser_conductor() {
		return user_conductor;
	}

	public void setUser_conductor(String user_conductor) {
		this.user_conductor = user_conductor;
	}

	public String getUser_vehicletype() {
		return user_vehicletype;
	}

	public void setUser_vehicletype(String user_vehicletype) {
		this.user_vehicletype = user_vehicletype;
	}

	public String getUser_load() {
		return user_load;
	}

	public void setUser_load(String user_load) {
		this.user_load = user_load;
	}

	public String getWx_id() {
		return wx_id;
	}

	public void setWx_id(String wx_id) {
		this.wx_id = wx_id;
	}

	public CarInformation(String user_conductor, String user_vehicletype, String user_load, String wx_id) {
		super();
		this.user_conductor = user_conductor;
		this.user_vehicletype = user_vehicletype;
		this.user_load = user_load;
		this.wx_id = wx_id;
	}

	public CarInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CarInformation [user_conductor=" + user_conductor + ", user_vehicletype=" + user_vehicletype
				+ ", user_load=" + user_load + ", wx_id=" + wx_id + "]";
	}

}