package com.fec.epreport.entity;
//浏览
public class Browse {
    private Integer browse_id;
    private Integer browse_user_id;
    private Integer browse_user_ids;
    private String browse_time;

    public Browse() {
    }

    public Browse(Integer browse_id, Integer browse_user_id, Integer browse_user_ids, String browse_time) {
        this.browse_id = browse_id;
        this.browse_user_id = browse_user_id;
        this.browse_user_ids = browse_user_ids;
        this.browse_time = browse_time;
    }

    public Integer getBrowse_id() {
        return browse_id;
    }

    public void setBrowse_id(Integer browse_id) {
        this.browse_id = browse_id;
    }

    public Integer getBrowse_user_id() {
        return browse_user_id;
    }

    public void setBrowse_user_id(Integer browse_user_id) {
        this.browse_user_id = browse_user_id;
    }

    public Integer getBrowse_user_ids() {
        return browse_user_ids;
    }

    public void setBrowse_user_ids(Integer browse_user_ids) {
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
                ", browse_user_id=" + browse_user_id +
                ", browse_user_ids=" + browse_user_ids +
                ", browse_time='" + browse_time + '\'' +
                '}';
    }
}
