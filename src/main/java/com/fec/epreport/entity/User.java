package com.fec.epreport.entity;

import java.io.Serializable;

//管理员表
public class User implements Serializable {
    //序列化实例化
	private static final long serialVersionUID = 1L;
	private Integer user_id;
    private String user_name;
    private String user_password;
    private String user_realname;
    private String user_phonenumber;
    private String user_idnumber;
    private String user_wechatnumber;
    private String user_creationtime;
    private String user_modificationtime;

    public User() {
    }

    public User(Integer user_id, String user_name, String user_password, String user_realname, String user_phonenumber, String user_idnumber, String user_wechatnumber, String user_creationtime, String user_modificationtime) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_realname = user_realname;
        this.user_phonenumber = user_phonenumber;
        this.user_idnumber = user_idnumber;
        this.user_wechatnumber = user_wechatnumber;
        this.user_creationtime = user_creationtime;
        this.user_modificationtime = user_modificationtime;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_realname() {
        return user_realname;
    }

    public void setUser_realname(String user_realname) {
        this.user_realname = user_realname;
    }

    public String getUser_phonenumber() {
        return user_phonenumber;
    }

    public void setUser_phonenumber(String user_phonenumber) {
        this.user_phonenumber = user_phonenumber;
    }

    public String getUser_idnumber() {
        return user_idnumber;
    }

    public void setUser_idnumber(String user_idnumber) {
        this.user_idnumber = user_idnumber;
    }

    public String getUser_wechatnumber() {
        return user_wechatnumber;
    }

    public void setUser_wechatnumber(String user_wechatnumber) {
        this.user_wechatnumber = user_wechatnumber;
    }

    public String getUser_creationtime() {
        return user_creationtime;
    }

    public void setUser_creationtime(String user_creationtime) {
        this.user_creationtime = user_creationtime;
    }

    public String getUser_modificationtime() {
        return user_modificationtime;
    }

    public void setUser_modificationtime(String user_modificationtime) {
        this.user_modificationtime = user_modificationtime;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_realname='" + user_realname + '\'' +
                ", user_phonenumber='" + user_phonenumber + '\'' +
                ", user_idnumber='" + user_idnumber + '\'' +
                ", user_wechatnumber='" + user_wechatnumber + '\'' +
                ", user_creationtime='" + user_creationtime + '\'' +
                ", user_modificationtime='" + user_modificationtime + '\'' +
                '}';
    }
}
