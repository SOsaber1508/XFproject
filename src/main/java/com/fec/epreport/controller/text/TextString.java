package com.fec.epreport.controller.text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.fec.epreport.service.InterFaceService;
import com.fec.epreport.util.commons.DateUtil;
import com.fec.epreport.util.commons.StringUtils;

public class TextString {
	@Autowired
	InterFaceService interFaceService;

	public static void main(String[] args) throws ParseException {
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
//		String a=null;
//		if(StringUtils.isBlank(a)) {
//			System.out.println("TextString.enclosing_method()");
//		}
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dBegin = sdf.parse("2018-04-23");
		Date dEnd = sdf.parse(sdf.format(date));
		List<String> datas = findDates(dBegin, dEnd);
		System.out.println(datas);
		List<String> list = new ArrayList<String>();
		List<String> lists = new ArrayList<String>();
		list.add("01");
		list.add("02");
		list.add("03");
		list.add("04");
		list.add("05");
		list.add("06");
		list.add("07");
		list.add("08");
		list.add("09");
		list.add("10");
		list.add("11");
		list.add("12");
		list.add("13");
		list.add("14");
		list.add("15");
		list.add("16");
		list.add("17");
		list.add("18");
		list.add("19");
		list.add("20");
		list.add("21");
		list.add("22");
		list.add("23");
		list.add("24");
		for (String data:datas) {
			for (String h:list) {
				lists.add(data+" "+h);
			}
		}
		System.out.println(lists);
	}
	private static List<String> findDates(Date dBegin, Date dEnd) {
		List<String> lDate = new ArrayList<String>();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		lDate.add(sd.format(dBegin));
		Calendar calBegin = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calBegin.setTime(dBegin);
		Calendar calEnd = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calEnd.setTime(dEnd);
		// 测试此日期是否在指定日期之后
		while (dEnd.after(calBegin.getTime()))
		{
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
			calBegin.add(Calendar.DAY_OF_MONTH, 1);
			lDate.add(sd.format(calBegin.getTime()));
		}
		return lDate;
	}
}
