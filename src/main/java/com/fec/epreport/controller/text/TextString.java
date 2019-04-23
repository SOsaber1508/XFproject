package com.fec.epreport.controller.text;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.fec.epreport.service.InterFaceService;
import com.fec.epreport.util.commons.DateUtil;
import com.fec.epreport.util.commons.StringUtils;

public class TextString {
	@Autowired
	InterFaceService interFaceService;

	public static void main(String[] args) {
//		StringBuilder sb = new StringBuilder();
//		String a = "asdasdadad";
//		if (StringUtils.isBlank(a)) {
//			System.out.println("进判断了");
//		}
//		sb.append("cefadssada");
//		if ("".equals(sb.toString())) {
//			System.out.println("1");
//		}
//		String aa = "asdad";
//		String bb = "asd";
//		String cc = "asdad";
//		if (!bb.equals(cc)) {
//			System.out.println("111");
//		}
//		if (aa.equals(cc)) {
//			System.out.println("1121");
//		}
//		String name = "password";
//		if ((name.equals("username") && !"username".equals("xfadmin"))
//				|| (name.equals("password") && !"password".equals("xfpassword"))) {
//			System.out.println("上传失败");
//		}
//		
//		JSONObject jsons= new JSONObject();
//		jsons.put("code", "200");
//		String abc=jsons.getString("code");
//		System.out.println(abc);
//		System.out.println(DateUtil.getTime());
//		
//		String filename="idsada.jpg";
//		filename = filename.substring(filename.lastIndexOf(".") + 1);	
//		System.out.println(filename);
//		
//		  if ((filename != null) && (filename.length() > 0)) { 
//	            int dot = filename.lastIndexOf('.'); 
//	            if ((dot >-1) && (dot < (filename.length()))) { 
//	                System.out.println(filename.substring(0, dot));
//	            } 
//	        }
//		  System.out.println(filename);
//	}
//		String goods_wight = "0-5%5-10";
//		if (!goods_wight.equals("")) {
//			List<String> result = Arrays.asList(goods_wight.split("%"));
//			System.out.println(result);
//		}
	}
}
