package com.fec.epreport.pojo;

import java.io.Serializable;

public class Textmodel implements Serializable{
	private String age;
	private String name;

	//序列化
	private static final long serialVersionUID = 1L;
	public Textmodel(String string, int i) {
		// TODO Auto-generated constructor stub
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
