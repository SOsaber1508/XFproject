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

    public Release() {
    }

    public Release(Integer release_id, Integer release_user_id, Integer release_goods_id, String release_time) {
        this.release_id = release_id;
        this.release_user_id = release_user_id;
        this.release_goods_id = release_goods_id;
        this.release_time = release_time;
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

    @Override
    public String toString() {
        return "Release{" +
                "release_id=" + release_id +
                ", release_user_id=" + release_user_id +
                ", release_goods_id=" + release_goods_id +
                ", release_time='" + release_time + '\'' +
                '}';
    }
}
