package com.fec.epreport.entity;

import java.io.Serializable;

//车源信息
public class Vehicle implements Serializable {
    //序列化实例化
    private static final long serialVersionUID = 1L;
    private Integer vehicle_id;
    private String vehicle_start;
    private String vehicle_end;
    private String vehicle_contacts;
    private String vehicle_contactinformation;
    private Double vehicle_length;
    private String vehicle_type;
    private String vehicle_releasetime;
    private String vehicle_user_id;
    private String vehicle_detaileddescription;
    private Double vehicle_load;
    private String vehicle_state;
    private Integer vehicle_Identification;
    private Double vehicle_long;
    private Double vehicle_lot;

    public Vehicle() {
    }

    public Vehicle(Integer vehicle_id, String vehicle_start, String vehicle_end, String vehicle_contacts, String vehicle_contactinformation, Double vehicle_length, String vehicle_type, String vehicle_releasetime, String vehicle_user_id, String vehicle_detaileddescription, Double vehicle_load, String vehicle_state, Integer vehicle_Identification, Double vehicle_long, Double vehicle_lot) {
        this.vehicle_id = vehicle_id;
        this.vehicle_start = vehicle_start;
        this.vehicle_end = vehicle_end;
        this.vehicle_contacts = vehicle_contacts;
        this.vehicle_contactinformation = vehicle_contactinformation;
        this.vehicle_length = vehicle_length;
        this.vehicle_type = vehicle_type;
        this.vehicle_releasetime = vehicle_releasetime;
        this.vehicle_user_id = vehicle_user_id;
        this.vehicle_detaileddescription = vehicle_detaileddescription;
        this.vehicle_load = vehicle_load;
        this.vehicle_state = vehicle_state;
        this.vehicle_Identification = vehicle_Identification;
        this.vehicle_long = vehicle_long;
        this.vehicle_lot = vehicle_lot;
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

    public Double getVehicle_length() {
        return vehicle_length;
    }

    public void setVehicle_length(Double vehicle_length) {
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

    public String getVehicle_user_id() {
        return vehicle_user_id;
    }

    public void setVehicle_user_id(String vehicle_user_id) {
        this.vehicle_user_id = vehicle_user_id;
    }

    public String getVehicle_detaileddescription() {
        return vehicle_detaileddescription;
    }

    public void setVehicle_detaileddescription(String vehicle_detaileddescription) {
        this.vehicle_detaileddescription = vehicle_detaileddescription;
    }

    public Double getVehicle_load() {
        return vehicle_load;
    }

    public void setVehicle_load(Double vehicle_load) {
        this.vehicle_load = vehicle_load;
    }

    public String getVehicle_state() {
        return vehicle_state;
    }

    public void setVehicle_state(String vehicle_state) {
        this.vehicle_state = vehicle_state;
    }

    public Integer getVehicle_Identification() {
        return vehicle_Identification;
    }

    public void setVehicle_Identification(Integer vehicle_Identification) {
        this.vehicle_Identification = vehicle_Identification;
    }

    public Double getVehicle_long() {
        return vehicle_long;
    }

    public void setVehicle_long(Double vehicle_long) {
        this.vehicle_long = vehicle_long;
    }

    public Double getVehicle_lot() {
        return vehicle_lot;
    }

    public void setVehicle_lot(Double vehicle_lot) {
        this.vehicle_lot = vehicle_lot;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicle_id=" + vehicle_id +
                ", vehicle_start='" + vehicle_start + '\'' +
                ", vehicle_end='" + vehicle_end + '\'' +
                ", vehicle_contacts='" + vehicle_contacts + '\'' +
                ", vehicle_contactinformation='" + vehicle_contactinformation + '\'' +
                ", vehicle_length=" + vehicle_length +
                ", vehicle_type='" + vehicle_type + '\'' +
                ", vehicle_releasetime='" + vehicle_releasetime + '\'' +
                ", vehicle_user_id='" + vehicle_user_id + '\'' +
                ", vehicle_detaileddescription='" + vehicle_detaileddescription + '\'' +
                ", vehicle_load=" + vehicle_load +
                ", vehicle_state='" + vehicle_state + '\'' +
                ", vehicle_Identification=" + vehicle_Identification +
                ", vehicle_long=" + vehicle_long +
                ", vehicle_lot=" + vehicle_lot +
                '}';
    }
}
