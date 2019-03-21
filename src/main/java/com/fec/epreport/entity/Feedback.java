package com.fec.epreport.entity;

import java.io.Serializable;

//意见反馈
public class Feedback implements Serializable {
    //序列化实例化
    private static final long serialVersionUID = 1L;
    private Integer feedback_id;
    private String feedback_user_id;
    private String feedback_type;
    private String feedback_content;
    private String feedback_photoa;
    private String feedback_photob;
    private String feedback_photoc;

    public Feedback() {
    }

    public Feedback(Integer feedback_id, String feedback_user_id, String feedback_type, String feedback_content, String feedback_photoa, String feedback_photob, String feedback_photoc) {
        this.feedback_id = feedback_id;
        this.feedback_user_id = feedback_user_id;
        this.feedback_type = feedback_type;
        this.feedback_content = feedback_content;
        this.feedback_photoa = feedback_photoa;
        this.feedback_photob = feedback_photob;
        this.feedback_photoc = feedback_photoc;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(Integer feedback_id) {
        this.feedback_id = feedback_id;
    }

    public String getFeedback_user_id() {
        return feedback_user_id;
    }

    public void setFeedback_user_id(String feedback_user_id) {
        this.feedback_user_id = feedback_user_id;
    }

    public String getFeedback_type() {
        return feedback_type;
    }

    public void setFeedback_type(String feedback_type) {
        this.feedback_type = feedback_type;
    }

    public String getFeedback_content() {
        return feedback_content;
    }

    public void setFeedback_content(String feedback_content) {
        this.feedback_content = feedback_content;
    }

    public String getFeedback_photoa() {
        return feedback_photoa;
    }

    public void setFeedback_photoa(String feedback_photoa) {
        this.feedback_photoa = feedback_photoa;
    }

    public String getFeedback_photob() {
        return feedback_photob;
    }

    public void setFeedback_photob(String feedback_photob) {
        this.feedback_photob = feedback_photob;
    }

    public String getFeedback_photoc() {
        return feedback_photoc;
    }

    public void setFeedback_photoc(String feedback_photoc) {
        this.feedback_photoc = feedback_photoc;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedback_id=" + feedback_id +
                ", feedback_user_id='" + feedback_user_id + '\'' +
                ", feedback_type='" + feedback_type + '\'' +
                ", feedback_content='" + feedback_content + '\'' +
                ", feedback_photoa='" + feedback_photoa + '\'' +
                ", feedback_photob='" + feedback_photob + '\'' +
                ", feedback_photoc='" + feedback_photoc + '\'' +
                '}';
    }
}
