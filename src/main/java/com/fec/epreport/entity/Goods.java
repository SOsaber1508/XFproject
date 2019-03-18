package com.fec.epreport.entity;

import java.io.Serializable;

//货源信息
public class Goods implements Serializable {
    //序列化实例化
    private static final long serialVersionUID = 1L;
    private Integer goods_id;
    private String goods_vehicletype;
    private Double goods_length;
    private String goods_vetype;
    private String goods_type;
    private String goods_Detailedtype;
    private String goods_name;
    private Double goods_number;
    private String goods_time;
    private String goods_start;
    private String goods_end;
    private String goods_detailed;
    private String goods_contacts;
    private String goods_contactinformation;
    private Integer goods_user_id;
    private String goods_releasestatus;
    private String goods_loadingtime;
    private Integer goods_Identification;
    private Double goods_long;
    private Double goods_lot;

    public Goods() {
    }

    public Goods(Integer goods_id, String goods_vehicletype, Double goods_length, String goods_vetype, String goods_type, String goods_Detailedtype, String goods_name, Double goods_number, String goods_time, String goods_start, String goods_end, String goods_detailed, String goods_contacts, String goods_contactinformation, Integer goods_user_id, String goods_releasestatus, String goods_loadingtime, Integer goods_Identification, Double goods_long, Double goods_lot) {
        this.goods_id = goods_id;
        this.goods_vehicletype = goods_vehicletype;
        this.goods_length = goods_length;
        this.goods_vetype = goods_vetype;
        this.goods_type = goods_type;
        this.goods_Detailedtype = goods_Detailedtype;
        this.goods_name = goods_name;
        this.goods_number = goods_number;
        this.goods_time = goods_time;
        this.goods_start = goods_start;
        this.goods_end = goods_end;
        this.goods_detailed = goods_detailed;
        this.goods_contacts = goods_contacts;
        this.goods_contactinformation = goods_contactinformation;
        this.goods_user_id = goods_user_id;
        this.goods_releasestatus = goods_releasestatus;
        this.goods_loadingtime = goods_loadingtime;
        this.goods_Identification = goods_Identification;
        this.goods_long = goods_long;
        this.goods_lot = goods_lot;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_vehicletype() {
        return goods_vehicletype;
    }

    public void setGoods_vehicletype(String goods_vehicletype) {
        this.goods_vehicletype = goods_vehicletype;
    }

    public Double getGoods_length() {
        return goods_length;
    }

    public void setGoods_length(Double goods_length) {
        this.goods_length = goods_length;
    }

    public String getGoods_vetype() {
        return goods_vetype;
    }

    public void setGoods_vetype(String goods_vetype) {
        this.goods_vetype = goods_vetype;
    }

    public String getGoods_type() {
        return goods_type;
    }

    public void setGoods_type(String goods_type) {
        this.goods_type = goods_type;
    }

    public String getGoods_Detailedtype() {
        return goods_Detailedtype;
    }

    public void setGoods_Detailedtype(String goods_Detailedtype) {
        this.goods_Detailedtype = goods_Detailedtype;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Double getGoods_number() {
        return goods_number;
    }

    public void setGoods_number(Double goods_number) {
        this.goods_number = goods_number;
    }

    public String getGoods_time() {
        return goods_time;
    }

    public void setGoods_time(String goods_time) {
        this.goods_time = goods_time;
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

    public String getGoods_detailed() {
        return goods_detailed;
    }

    public void setGoods_detailed(String goods_detailed) {
        this.goods_detailed = goods_detailed;
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

    public Integer getGoods_user_id() {
        return goods_user_id;
    }

    public void setGoods_user_id(Integer goods_user_id) {
        this.goods_user_id = goods_user_id;
    }

    public String getGoods_releasestatus() {
        return goods_releasestatus;
    }

    public void setGoods_releasestatus(String goods_releasestatus) {
        this.goods_releasestatus = goods_releasestatus;
    }

    public String getGoods_loadingtime() {
        return goods_loadingtime;
    }

    public void setGoods_loadingtime(String goods_loadingtime) {
        this.goods_loadingtime = goods_loadingtime;
    }

    public Integer getGoods_Identification() {
        return goods_Identification;
    }

    public void setGoods_Identification(Integer goods_Identification) {
        this.goods_Identification = goods_Identification;
    }

    public Double getGoods_long() {
        return goods_long;
    }

    public void setGoods_long(Double goods_long) {
        this.goods_long = goods_long;
    }

    public Double getGoods_lot() {
        return goods_lot;
    }

    public void setGoods_lot(Double goods_lot) {
        this.goods_lot = goods_lot;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goods_id=" + goods_id +
                ", goods_vehicletype='" + goods_vehicletype + '\'' +
                ", goods_length=" + goods_length +
                ", goods_vetype='" + goods_vetype + '\'' +
                ", goods_type='" + goods_type + '\'' +
                ", goods_Detailedtype='" + goods_Detailedtype + '\'' +
                ", goods_name='" + goods_name + '\'' +
                ", goods_number=" + goods_number +
                ", goods_time='" + goods_time + '\'' +
                ", goods_start='" + goods_start + '\'' +
                ", goods_end='" + goods_end + '\'' +
                ", goods_detailed='" + goods_detailed + '\'' +
                ", goods_contacts='" + goods_contacts + '\'' +
                ", goods_contactinformation='" + goods_contactinformation + '\'' +
                ", goods_user_id=" + goods_user_id +
                ", goods_releasestatus='" + goods_releasestatus + '\'' +
                ", goods_loadingtime='" + goods_loadingtime + '\'' +
                ", goods_Identification=" + goods_Identification +
                ", goods_long=" + goods_long +
                ", goods_lot=" + goods_lot +
                '}';
    }
}
