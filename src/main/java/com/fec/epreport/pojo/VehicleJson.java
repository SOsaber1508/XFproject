package com.fec.epreport.pojo;

import java.io.Serializable;

//车源信息json表
public class VehicleJson implements Serializable {
	// 序列化实例化
	private static final long serialVersionUID = 1L;
	// 出发-省
	private String vehicle_start_province;
	// 出发-市
	private String vehicle_start_city;
	// 出发-区
	private String vehicle_start_area;
	// 出发-详细地址
	private String vehicle_start_address;
	// 终点-省
	private String vehicle_end_province;
	// 终点-市
	private String vehicle_end__city;
	// 终点-区
	private String vehicle_end__area;
	// 终点-详细地址
	private String vehicle_end__address;
	// 联系人
	private String vehicle_contacts;
	// 联系方式
	private String vehicle_contactinformation;
	// 车长
	private String vehicle_length;
	// 车型
	private String vehicle_type;
	// 发布时间
	private String vehicle_releasetime;
	// 微信id
	private String vehicle_wx_id;
	// 详细描述
	private String vehicle_detaileddescription;
	// 载重(吨)
	// private String vehicle_load;
	private String vehicle_number;
	// 载重(立方)
	private String vehicle_number_mi;

	public String getVehicle_start_province() {
		return vehicle_start_province;
	}

	public void setVehicle_start_province(String vehicle_start_province) {
		this.vehicle_start_province = vehicle_start_province;
	}

	public String getVehicle_start_city() {
		return vehicle_start_city;
	}

	public void setVehicle_start_city(String vehicle_start_city) {
		this.vehicle_start_city = vehicle_start_city;
	}

	public String getVehicle_start_area() {
		return vehicle_start_area;
	}

	public void setVehicle_start_area(String vehicle_start_area) {
		this.vehicle_start_area = vehicle_start_area;
	}

	public String getVehicle_start_address() {
		return vehicle_start_address;
	}

	public void setVehicle_start_address(String vehicle_start_address) {
		this.vehicle_start_address = vehicle_start_address;
	}

	public String getVehicle_end_province() {
		return vehicle_end_province;
	}

	public void setVehicle_end_province(String vehicle_end_province) {
		this.vehicle_end_province = vehicle_end_province;
	}

	public String getVehicle_end__city() {
		return vehicle_end__city;
	}

	public void setVehicle_end__city(String vehicle_end__city) {
		this.vehicle_end__city = vehicle_end__city;
	}

	public String getVehicle_end__area() {
		return vehicle_end__area;
	}

	public void setVehicle_end__area(String vehicle_end__area) {
		this.vehicle_end__area = vehicle_end__area;
	}

	public String getVehicle_end__address() {
		return vehicle_end__address;
	}

	public void setVehicle_end__address(String vehicle_end__address) {
		this.vehicle_end__address = vehicle_end__address;
	}

	public String getVehicle_contacts() {
		return vehicle_contacts;
	}

	public void setVehicle_contacts(String vehicle_contacts) {
		this.vehicle_contacts = vehicle_contacts;
	}

	public String getVehicle_contactinformation() {
		return vehicle_contactinformation;
	}

	public void setVehicle_contactinformation(String vehicle_contactinformation) {
		this.vehicle_contactinformation = vehicle_contactinformation;
	}

	public String getVehicle_length() {
		return vehicle_length;
	}

	public void setVehicle_length(String vehicle_length) {
		this.vehicle_length = vehicle_length;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public String getVehicle_releasetime() {
		return vehicle_releasetime;
	}

	public void setVehicle_releasetime(String vehicle_releasetime) {
		this.vehicle_releasetime = vehicle_releasetime;
	}

	public String getVehicle_wx_id() {
		return vehicle_wx_id;
	}

	public void setVehicle_wx_id(String vehicle_wx_id) {
		this.vehicle_wx_id = vehicle_wx_id;
	}

	public String getVehicle_detaileddescription() {
		return vehicle_detaileddescription;
	}

	public void setVehicle_detaileddescription(String vehicle_detaileddescription) {
		this.vehicle_detaileddescription = vehicle_detaileddescription;
	}

	public String getVehicle_number() {
		return vehicle_number;
	}

	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}

	public String getVehicle_number_mi() {
		return vehicle_number_mi;
	}

	public void setVehicle_number_mi(String vehicle_number_mi) {
		this.vehicle_number_mi = vehicle_number_mi;
	}

	@Override
	public String toString() {
		return "VehicleJson [vehicle_start_province=" + vehicle_start_province + ", vehicle_start_city="
				+ vehicle_start_city + ", vehicle_start_area=" + vehicle_start_area + ", vehicle_start_address="
				+ vehicle_start_address + ", vehicle_end_province=" + vehicle_end_province + ", vehicle_end__city="
				+ vehicle_end__city + ", vehicle_end__area=" + vehicle_end__area + ", vehicle_end__address="
				+ vehicle_end__address + ", vehicle_contacts=" + vehicle_contacts + ", vehicle_contactinformation="
				+ vehicle_contactinformation + ", vehicle_length=" + vehicle_length + ", vehicle_type=" + vehicle_type
				+ ", vehicle_releasetime=" + vehicle_releasetime + ", vehicle_wx_id=" + vehicle_wx_id
				+ ", vehicle_detaileddescription=" + vehicle_detaileddescription + ", vehicle_number=" + vehicle_number
				+ ", vehicle_number_mi=" + vehicle_number_mi + "]";
	}

	public VehicleJson(String vehicle_start_province, String vehicle_start_city, String vehicle_start_area,
			String vehicle_start_address, String vehicle_end_province, String vehicle_end__city,
			String vehicle_end__area, String vehicle_end__address, String vehicle_contacts,
			String vehicle_contactinformation, String vehicle_length, String vehicle_type, String vehicle_releasetime,
			String vehicle_wx_id, String vehicle_detaileddescription, String vehicle_number, String vehicle_number_mi) {
		super();
		this.vehicle_start_province = vehicle_start_province;
		this.vehicle_start_city = vehicle_start_city;
		this.vehicle_start_area = vehicle_start_area;
		this.vehicle_start_address = vehicle_start_address;
		this.vehicle_end_province = vehicle_end_province;
		this.vehicle_end__city = vehicle_end__city;
		this.vehicle_end__area = vehicle_end__area;
		this.vehicle_end__address = vehicle_end__address;
		this.vehicle_contacts = vehicle_contacts;
		this.vehicle_contactinformation = vehicle_contactinformation;
		this.vehicle_length = vehicle_length;
		this.vehicle_type = vehicle_type;
		this.vehicle_releasetime = vehicle_releasetime;
		this.vehicle_wx_id = vehicle_wx_id;
		this.vehicle_detaileddescription = vehicle_detaileddescription;
		this.vehicle_number = vehicle_number;
		this.vehicle_number_mi = vehicle_number_mi;
	}

	public VehicleJson() {
		super();
		// TODO Auto-generated constructor stub
	}

	// private Double vehicle_long;
	// private Double vehicle_lot;

}
