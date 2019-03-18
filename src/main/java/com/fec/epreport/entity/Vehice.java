package com.fec.epreport.entity;

import java.io.Serializable;

//车源信息
public class Vehice implements Serializable {
    //序列化实例化
    private static final long serialVersionUID = 1L;
    private Integer vehicle_id;
    private String vehicle_start;
    private String vehicle_end;
    private String vehice_contacts;
    private String vehice_contactinformation;
    private Double vehice_length;
    private String vehice_type;
    private String vehice_releasetime;
    private Integer vehice_user_id;
    private String vehice_detaileddescription;
    private Double vehice_load;
    private String vehice_state;
    private Integer vehice_Identification;
    private Double vehice_long;
    private Double vehice_lot;

    public Vehice() {
    }

    public Vehice(Integer vehicle_id, String vehicle_start, String vehicle_end, String vehice_contacts, String vehice_contactinformation, Double vehice_length, String vehice_type, String vehice_releasetime, Integer vehice_user_id, String vehice_detaileddescription, Double vehice_load, String vehice_state, Integer vehice_Identification, Double vehice_long, Double vehice_lot) {
        this.vehicle_id = vehicle_id;
        this.vehicle_start = vehicle_start;
        this.vehicle_end = vehicle_end;
        this.vehice_contacts = vehice_contacts;
        this.vehice_contactinformation = vehice_contactinformation;
        this.vehice_length = vehice_length;
        this.vehice_type = vehice_type;
        this.vehice_releasetime = vehice_releasetime;
        this.vehice_user_id = vehice_user_id;
        this.vehice_detaileddescription = vehice_detaileddescription;
        this.vehice_load = vehice_load;
        this.vehice_state = vehice_state;
        this.vehice_Identification = vehice_Identification;
        this.vehice_long = vehice_long;
        this.vehice_lot = vehice_lot;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(Integer vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getVehicle_start() {
        return vehicle_start;
    }

    public void setVehicle_start(String vehicle_start) {
        this.vehicle_start = vehicle_start;
    }

    public String getVehicle_end() {
        return vehicle_end;
    }

    public void setVehicle_end(String vehicle_end) {
        this.vehicle_end = vehicle_end;
    }

    public String getVehice_contacts() {
        return vehice_contacts;
    }

    public void setVehice_contacts(String vehice_contacts) {
        this.vehice_contacts = vehice_contacts;
    }

    public String getVehice_contactinformation() {
        return vehice_contactinformation;
    }

    public void setVehice_contactinformation(String vehice_contactinformation) {
        this.vehice_contactinformation = vehice_contactinformation;
    }

    public Double getVehice_length() {
        return vehice_length;
    }

    public void setVehice_length(Double vehice_length) {
        this.vehice_length = vehice_length;
    }

    public String getVehice_type() {
        return vehice_type;
    }

    public void setVehice_type(String vehice_type) {
        this.vehice_type = vehice_type;
    }

    public String getVehice_releasetime() {
        return vehice_releasetime;
    }

    public void setVehice_releasetime(String vehice_releasetime) {
        this.vehice_releasetime = vehice_releasetime;
    }

    public Integer getVehice_user_id() {
        return vehice_user_id;
    }

    public void setVehice_user_id(Integer vehice_user_id) {
        this.vehice_user_id = vehice_user_id;
    }

    public String getVehice_detaileddescription() {
        return vehice_detaileddescription;
    }

    public void setVehice_detaileddescription(String vehice_detaileddescription) {
        this.vehice_detaileddescription = vehice_detaileddescription;
    }

    public Double getVehice_load() {
        return vehice_load;
    }

    public void setVehice_load(Double vehice_load) {
        this.vehice_load = vehice_load;
    }

    public String getVehice_state() {
        return vehice_state;
    }

    public void setVehice_state(String vehice_state) {
        this.vehice_state = vehice_state;
    }

    public Integer getVehice_Identification() {
        return vehice_Identification;
    }

    public void setVehice_Identification(Integer vehice_Identification) {
        this.vehice_Identification = vehice_Identification;
    }

    public Double getVehice_long() {
        return vehice_long;
    }

    public void setVehice_long(Double vehice_long) {
        this.vehice_long = vehice_long;
    }

    public Double getVehice_lot() {
        return vehice_lot;
    }

    public void setVehice_lot(Double vehice_lot) {
        this.vehice_lot = vehice_lot;
    }

    @Override
    public String toString() {
        return "Vehice{" +
                "vehicle_id=" + vehicle_id +
                ", vehicle_start='" + vehicle_start + '\'' +
                ", vehicle_end='" + vehicle_end + '\'' +
                ", vehice_contacts='" + vehice_contacts + '\'' +
                ", vehice_contactinformation='" + vehice_contactinformation + '\'' +
                ", vehice_length=" + vehice_length +
                ", vehice_type='" + vehice_type + '\'' +
                ", vehice_releasetime='" + vehice_releasetime + '\'' +
                ", vehice_user_id=" + vehice_user_id +
                ", vehice_detaileddescription='" + vehice_detaileddescription + '\'' +
                ", vehice_load=" + vehice_load +
                ", vehice_state='" + vehice_state + '\'' +
                ", vehice_Identification=" + vehice_Identification +
                ", vehice_long=" + vehice_long +
                ", vehice_lot=" + vehice_lot +
                '}';
    }
}
