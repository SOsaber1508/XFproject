package com.fec.epreport.pojo;

import java.io.Serializable;

//货源信息
public class ShareShiro implements Serializable {
	// 序列化实例化
	private static final long serialVersionUID = 1L;
	private String user_share_shiro;
	private int  user_share;
	private String user_sharetime;
	public String getUser_share_shiro() {
		return user_share_shiro;
	}
	public void setUser_share_shiro(String user_share_shiro) {
		this.user_share_shiro = user_share_shiro;
	}
	public int getUser_share() {
		return user_share;
	}
	public void setUser_share(int user_share) {
		this.user_share = user_share;
	}
	public String getUser_sharetime() {
		return user_sharetime;
	}
	public void setUser_sharetime(String user_sharetime) {
		this.user_sharetime = user_sharetime;
	}
	
}
