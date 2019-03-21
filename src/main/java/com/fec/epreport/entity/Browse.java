package com.fec.epreport.entity;

import java.io.Serializable;

//浏览
public class Browse implements Serializable {
    //序列化实例化
    private static final long serialVersionUID = 1L;
    private Integer browse_id;
    private String browse_user_id;
    private String browse_user_ids;
    private String browse_time;

    public Browse() {
    }

    public Browse(Integer browse_id, String browse_user_id, String browse_user_ids, String browse_time) {
        this.browse_id = browse_id;
        this.browse_user_id = browse_user_id;
        this.browse_user_ids = browse_user_ids;
        this.browse_time = browse_time;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getBrowse_id() {
        return browse_id;
    }

    public void setBrowse_id(Integer browse_id) {
        this.browse_id = browse_id;
    }

    public String getBrowse_user_id() {
        return browse_user_id;
    }

    public void setBrowse_user_id(String browse_user_id) {
        this.browse_user_id = browse_user_id;
    }

    public String getBrowse_user_ids() {
        return browse_user_ids;
    }

    public void setBrowse_user_ids(String browse_user_ids) {
        this.browse_user_ids = browse_user_ids;
    }

    public String getBrowse_time() {
        return browse_time;
    }

    public void setBrowse_time(String browse_time) {
        this.browse_time = browse_time;
    }

    @Override
    public String toString() {
        return "Browse{" +
                "browse_id=" + browse_id +
                ", browse_user_id='" + browse_user_id + '\'' +
                ", browse_user_ids='" + browse_user_ids + '\'' +
                ", browse_time='" + browse_time + '\'' +
                '}';
    }
}
