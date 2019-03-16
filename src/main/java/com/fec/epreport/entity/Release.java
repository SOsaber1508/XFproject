package com.fec.epreport.entity;

import java.io.Serializable;

//发布消息
public class Release implements Serializable {
    //序列化实例化
    private static final long serialVersionUID = 1L;
    private Integer release_id;
    private Integer release_user_id;
    private Integer release_goods_id;
    private String release_time;
    private Double release_long;
    private Double release_lot;
    private Integer release_judgeid;


    public Release() {
    }

    public Release(Integer release_id, Integer release_user_id, Integer release_goods_id, String release_time, Double release_long, Double release_lot, Integer release_judgeid) {
        this.release_id = release_id;
        this.release_user_id = release_user_id;
        this.release_goods_id = release_goods_id;
        this.release_time = release_time;
        this.release_long = release_long;
        this.release_lot = release_lot;
        this.release_judgeid = release_judgeid;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getRelease_id() {
        return release_id;
    }

    public void setRelease_id(Integer release_id) {
        this.release_id = release_id;
    }

    public Integer getRelease_user_id() {
        return release_user_id;
    }

    public void setRelease_user_id(Integer release_user_id) {
        this.release_user_id = release_user_id;
    }

    public Integer getRelease_goods_id() {
        return release_goods_id;
    }

    public void setRelease_goods_id(Integer release_goods_id) {
        this.release_goods_id = release_goods_id;
    }

    public String getRelease_time() {
        return release_time;
    }

    public void setRelease_time(String release_time) {
        this.release_time = release_time;
    }

    public Double getRelease_long() {
        return release_long;
    }

    public void setRelease_long(Double release_long) {
        this.release_long = release_long;
    }

    public Double getRelease_lot() {
        return release_lot;
    }

    public void setRelease_lot(Double release_lot) {
        this.release_lot = release_lot;
    }

    public Integer getRelease_judgeid() {
        return release_judgeid;
    }

    public void setRelease_judgeid(Integer release_judgeid) {
        this.release_judgeid = release_judgeid;
    }

    @Override
    public String toString() {
        return "Release{" +
                "release_id=" + release_id +
                ", release_user_id=" + release_user_id +
                ", release_goods_id=" + release_goods_id +
                ", release_time='" + release_time + '\'' +
                ", release_long=" + release_long +
                ", release_lot=" + release_lot +
                ", release_judgeid=" + release_judgeid +
                '}';
    }
}