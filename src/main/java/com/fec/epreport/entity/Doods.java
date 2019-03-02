package com.fec.epreport.entity;
//货源信息
public class Doods {
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
    private Integer doods_user_id;
    private String doods_releasestatus;

    public Doods() {
    }

    public Doods(Integer goods_id, String goods_vehicletype, Double goods_length, String goods_vetype, String goods_type, String goods_Detailedtype, String goods_name, Double goods_number, String goods_time, String goods_start, String goods_end, String goods_detailed, String goods_contacts, String goods_contactinformation, Integer doods_user_id, String doods_releasestatus) {
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
        this.doods_user_id = doods_user_id;
        this.doods_releasestatus = doods_releasestatus;
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

    public Integer getDoods_user_id() {
        return doods_user_id;
    }

    public void setDoods_user_id(Integer doods_user_id) {
        this.doods_user_id = doods_user_id;
    }

    public String getDoods_releasestatus() {
        return doods_releasestatus;
    }

    public void setDoods_releasestatus(String doods_releasestatus) {
        this.doods_releasestatus = doods_releasestatus;
    }

    @Override
    public String toString() {
        return "Doods{" +
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
                ", doods_user_id=" + doods_user_id +
                ", doods_releasestatus='" + doods_releasestatus + '\'' +
                '}';
    }
}
