package com.fec.epreport.entity;

import java.io.Serializable;

//我的消息
public class News implements Serializable {
    //序列化实例化
    private static final long serialVersionUID = 1L;
    private Integer news_id;
    private Integer news_user_id;
    private Integer news_user_ids;
    private String news_information;
    private String news_time;

    public News() {
    }

    public News(Integer news_id, Integer news_user_id, Integer news_user_ids, String news_information, String news_time) {
        this.news_id = news_id;
        this.news_user_id = news_user_id;
        this.news_user_ids = news_user_ids;
        this.news_information = news_information;
        this.news_time = news_time;
    }

    public Integer getNews_id() {
        return news_id;
    }

    public void setNews_id(Integer news_id) {
        this.news_id = news_id;
    }

    public Integer getNews_user_id() {
        return news_user_id;
    }

    public void setNews_user_id(Integer news_user_id) {
        this.news_user_id = news_user_id;
    }

    public Integer getNews_user_ids() {
        return news_user_ids;
    }

    public void setNews_user_ids(Integer news_user_ids) {
        this.news_user_ids = news_user_ids;
    }

    public String getNews_information() {
        return news_information;
    }

    public void setNews_information(String news_information) {
        this.news_information = news_information;
    }

    public String getNews_time() {
        return news_time;
    }

    public void setNews_time(String news_time) {
        this.news_time = news_time;
    }

    @Override
    public String toString() {
        return "News{" +
                "news_id=" + news_id +
                ", news_user_id=" + news_user_id +
                ", news_user_ids=" + news_user_ids +
                ", news_information='" + news_information + '\'' +
                ", news_time='" + news_time + '\'' +
                '}';
    }
}
