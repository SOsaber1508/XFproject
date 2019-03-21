package com.fec.epreport.entity;

import java.io.Serializable;

//用户表
public class Users implements Serializable {
    //序列化实例化
    private static final long serialVersionUID = 1L;
    private String user_id;
    private String wx_headimgurl;
    private String wx_name;
    private String wx_password;
    private String wx_nickname;
    private String wx_city;
    private String wx_province;
    private String wx_country;
    private String wx_openid;
    private String user_idnumber;
    private String user_phonenumber;
    private String user_authentication;
    private String user_establish;
    private String user_modify;
    private Integer user_sex;
    private String user_birth;
    private String user_address;
    private Integer user_share;
    private String user_sharetime;
    private Double user_conductor;
    private String user_vehicletype;
    private Double user_load;
    private Integer user_perfect;

    public Users() {
    }

    public Users(String user_id, String wx_headimgurl, String wx_name, String wx_password, String wx_nickname, String wx_city, String wx_province, String wx_country, String wx_openid, String user_idnumber, String user_phonenumber, String user_authentication, String user_establish, String user_modify, Integer user_sex, String user_birth, String user_address, Integer user_share, String user_sharetime, Double user_conductor, String user_vehicletype, Double user_load, Integer user_perfect) {
        this.user_id = user_id;
        this.wx_headimgurl = wx_headimgurl;
        this.wx_name = wx_name;
        this.wx_password = wx_password;
        this.wx_nickname = wx_nickname;
        this.wx_city = wx_city;
        this.wx_province = wx_province;
        this.wx_country = wx_country;
        this.wx_openid = wx_openid;
        this.user_idnumber = user_idnumber;
        this.user_phonenumber = user_phonenumber;
        this.user_authentication = user_authentication;
        this.user_establish = user_establish;
        this.user_modify = user_modify;
        this.user_sex = user_sex;
        this.user_birth = user_birth;
        this.user_address = user_address;
        this.user_share = user_share;
        this.user_sharetime = user_sharetime;
        this.user_conductor = user_conductor;
        this.user_vehicletype = user_vehicletype;
        this.user_load = user_load;
        this.user_perfect = user_perfect;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getWx_headimgurl() {
        return wx_headimgurl;
    }

    public void setWx_headimgurl(String wx_headimgurl) {
        this.wx_headimgurl = wx_headimgurl;
    }

    public String getWx_name() {
        return wx_name;
    }

    public void setWx_name(String wx_name) {
        this.wx_name = wx_name;
    }

    public String getWx_password() {
        return wx_password;
    }

    public void setWx_password(String wx_password) {
        this.wx_password = wx_password;
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

    public String getWx_openid() {
        return wx_openid;
    }

    public void setWx_openid(String wx_openid) {
        this.wx_openid = wx_openid;
    }

    public String getUser_idnumber() {
        return user_idnumber;
    }

    public void setUser_idnumber(String user_idnumber) {
        this.user_idnumber = user_idnumber;
    }

    public String getUser_phonenumber() {
        return user_phonenumber;
    }

    public void setUser_phonenumber(String user_phonenumber) {
        this.user_phonenumber = user_phonenumber;
    }

    public String getUser_authentication() {
        return user_authentication;
    }

    public void setUser_authentication(String user_authentication) {
        this.user_authentication = user_authentication;
    }

    public String getUser_establish() {
        return user_establish;
    }

    public void setUser_establish(String user_establish) {
        this.user_establish = user_establish;
    }

    public String getUser_modify() {
        return user_modify;
    }

    public void setUser_modify(String user_modify) {
        this.user_modify = user_modify;
    }

    public Integer getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(Integer user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_birth() {
        return user_birth;
    }

    public void setUser_birth(String user_birth) {
        this.user_birth = user_birth;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public Integer getUser_share() {
        return user_share;
    }

    public void setUser_share(Integer user_share) {
        this.user_share = user_share;
    }

    public String getUser_sharetime() {
        return user_sharetime;
    }

    public void setUser_sharetime(String user_sharetime) {
        this.user_sharetime = user_sharetime;
    }

    public Double getUser_conductor() {
        return user_conductor;
    }

    public void setUser_conductor(Double user_conductor) {
        this.user_conductor = user_conductor;
    }

    public String getUser_vehicletype() {
        return user_vehicletype;
    }

    public void setUser_vehicletype(String user_vehicletype) {
        this.user_vehicletype = user_vehicletype;
    }

    public Double getUser_load() {
        return user_load;
    }

    public void setUser_load(Double user_load) {
        this.user_load = user_load;
    }

    public Integer getUser_perfect() {
        return user_perfect;
    }

    public void setUser_perfect(Integer user_perfect) {
        this.user_perfect = user_perfect;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id='" + user_id + '\'' +
                ", wx_headimgurl='" + wx_headimgurl + '\'' +
                ", wx_name='" + wx_name + '\'' +
                ", wx_password='" + wx_password + '\'' +
                ", wx_nickname='" + wx_nickname + '\'' +
                ", wx_city='" + wx_city + '\'' +
                ", wx_province='" + wx_province + '\'' +
                ", wx_country='" + wx_country + '\'' +
                ", wx_openid='" + wx_openid + '\'' +
                ", user_idnumber='" + user_idnumber + '\'' +
                ", user_phonenumber='" + user_phonenumber + '\'' +
                ", user_authentication='" + user_authentication + '\'' +
                ", user_establish='" + user_establish + '\'' +
                ", user_modify='" + user_modify + '\'' +
                ", user_sex=" + user_sex +
                ", user_birth='" + user_birth + '\'' +
                ", user_address='" + user_address + '\'' +
                ", user_share=" + user_share +
                ", user_sharetime='" + user_sharetime + '\'' +
                ", user_conductor=" + user_conductor +
                ", user_vehicletype='" + user_vehicletype + '\'' +
                ", user_load=" + user_load +
                ", user_perfect=" + user_perfect +
                '}';
    }
}