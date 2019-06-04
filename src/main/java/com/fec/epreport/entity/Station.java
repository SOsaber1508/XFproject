package com.fec.epreport.entity;

import java.io.Serializable;

//附近
/**
 * 
 * @author zcy
 *
 */
public class Station implements Serializable {
	//序列化实例化
    private static final long serialVersionUID = 1L;
	private String id;
	private String type;    //类型
	private String phone_number;//联系方式
	private String start_time;//营业开始时间
	private String end_time;//营业结束时间
	private String activity_name; //活动
	private String station_name;//站名
	private String other;//其他
	private String business_name;//主营业务
	private String province;//省
	private String city;//市
	private String area;///区
	private String address;//详细地址
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getActivity_name() {
		return activity_name;
	}
	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Station [id=" + id + ", type=" + type + ", phone_number=" + phone_number + ", start_time=" + start_time
				+ ", end_time=" + end_time + ", activity_name=" + activity_name + ", station_name=" + station_name
				+ ", other=" + other + ", business_name=" + business_name + ", province=" + province + ", city=" + city
				+ ", area=" + area + ", address=" + address + ", getId()=" + getId() + ", getType()=" + getType()
				+ ", getPhone_number()=" + getPhone_number() + ", getStart_time()=" + getStart_time()
				+ ", getEnd_time()=" + getEnd_time() + ", getActivity_name()=" + getActivity_name()
				+ ", getStation_name()=" + getStation_name() + ", getOther()=" + getOther() + ", getBusiness_name()="
				+ getBusiness_name() + ", getProvince()=" + getProvince() + ", getCity()=" + getCity() + ", getArea()="
				+ getArea() + ", getAddress()=" + getAddress() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	public Station() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Station(String id, String type, String phone_number, String start_time, String end_time,
			String activity_name, String station_name, String other, String business_name, String province, String city,
			String area, String address) {
		super();
		this.id = id;
		this.type = type;
		this.phone_number = phone_number;
		this.start_time = start_time;
		this.end_time = end_time;
		this.activity_name = activity_name;
		this.station_name = station_name;
		this.other = other;
		this.business_name = business_name;
		this.province = province;
		this.city = city;
		this.area = area;
		this.address = address;
	}
	
	
}
