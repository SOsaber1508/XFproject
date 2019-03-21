package com.fec.epreport.controller.text;

import org.springframework.beans.factory.annotation.Autowired;

import com.fec.epreport.service.InterFaceService;
import com.fec.epreport.util.commons.StringUtils;

public class TextString {
	@Autowired
	InterFaceService interFaceService;

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		String a = "asdasdadad";
		if (StringUtils.isBlank(a)) {
			System.out.println("进判断了");
		}
		sb.append("cefadssada");
		if ("".equals(sb.toString())) {
			System.out.println("1");
		}
	}

}
