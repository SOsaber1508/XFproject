package com.fec.epreport.entity;

import java.io.Serializable;

//通话记录
public class Conversation implements Serializable {
    //序列化实例化
    private static final long serialVersionUID = 1L;
    private Integer conversation_id;
    private String conversation_user_id;
    private String conversation_user_ids;
    private String conversation_time;
    private String conversation_phonenumber;

    public Conversation() {
    }

    public Conversation(Integer conversation_id, String conversation_user_id, String conversation_user_ids, String conversation_time, String conversation_phonenumber) {
        this.conversation_id = conversation_id;
        this.conversation_user_id = conversation_user_id;
        this.conversation_user_ids = conversation_user_ids;
        this.conversation_time = conversation_time;
        this.conversation_phonenumber = conversation_phonenumber;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(Integer conversation_id) {
        this.conversation_id = conversation_id;
    }

    public String getConversation_user_id() {
        return conversation_user_id;
    }

    public void setConversation_user_id(String conversation_user_id) {
        this.conversation_user_id = conversation_user_id;
    }

    public String getConversation_user_ids() {
        return conversation_user_ids;
    }

    public void setConversation_user_ids(String conversation_user_ids) {
        this.conversation_user_ids = conversation_user_ids;
    }

    public String getConversation_time() {
        return conversation_time;
    }

    public void setConversation_time(String conversation_time) {
        this.conversation_time = conversation_time;
    }

    public String getConversation_phonenumber() {
        return conversation_phonenumber;
    }

    public void setConversation_phonenumber(String conversation_phonenumber) {
        this.conversation_phonenumber = conversation_phonenumber;
    }

    @Override
    public String toString() {
        return "Conversation{" +
                "conversation_id=" + conversation_id +
                ", conversation_user_id='" + conversation_user_id + '\'' +
                ", conversation_user_ids='" + conversation_user_ids + '\'' +
                ", conversation_time='" + conversation_time + '\'' +
                ", conversation_phonenumber='" + conversation_phonenumber + '\'' +
                '}';
    }
}
