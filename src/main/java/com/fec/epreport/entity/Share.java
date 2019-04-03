package com.fec.epreport.entity;

import java.io.Serializable;

//分享表
public class Share implements Serializable {
	// 序列化实例化
	private static final long serialVersionUID = 1L;
	private int share_id;
	private String share_title;//分享标题
	private String share_value;//分享内容
	private String share_img;//分享图片url
	private String share_url;//分享跳转的页面

	public int getShare_id() {
		return share_id;
	}

	public void setShare_id(int share_id) {
		this.share_id = share_id;
	}

	public String getShare_title() {
		return share_title;
	}

	public void setShare_title(String share_title) {
		this.share_title = share_title;
	}

	public String getShare_value() {
		return share_value;
	}

	public void setShare_value(String share_value) {
		this.share_value = share_value;
	}

	public String getShare_img() {
		return share_img;
	}

	public void setShare_img(String share_img) {
		this.share_img = share_img;
	}

	public String getShare_url() {
		return share_url;
	}

	public void setShare_url(String share_url) {
		this.share_url = share_url;
	}

	@Override
	public String toString() {
		return "Share [share_id=" + share_id + ", share_title=" + share_title + ", share_value=" + share_value
				+ ", share_img=" + share_img + ", share_url=" + share_url + "]";
	}

	public Share(int share_id, String share_title, String share_value, String share_img, String share_url) {
		super();
		this.share_id = share_id;
		this.share_title = share_title;
		this.share_value = share_value;
		this.share_img = share_img;
		this.share_url = share_url;
	}

	public Share() {
		super();
		// TODO Auto-generated constructor stub
	}

}
