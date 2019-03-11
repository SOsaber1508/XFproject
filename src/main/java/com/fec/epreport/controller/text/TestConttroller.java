package com.fec.epreport.controller.text;
 
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
 
 
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
 
/**
 *  接收json用测试接口
 * @author zcy
 *
 */
@Controller
@RequestMapping("/test")
public class TestConttroller{
 
    @Resource
	protected HttpServletRequest request;
    
    @ResponseBody
	@RequestMapping(value="/test.htm",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
	public Map<String,Object> getString() throws UnsupportedEncodingException, IOException{
		System.out.println("进入=====================");
		//后台接收
		InputStreamReader reader=new InputStreamReader(request.getInputStream(),"UTF-8");
		char [] buff=new char[1024];
		int length=0;
		while((length=reader.read(buff))!=-1){
		     String x=new String(buff,0,length);
		     System.out.println(x);
		}
		//响应
		Map<String,Object> jsonObject = new HashMap<String, Object>();  //创建Json对象
		jsonObject.put("username", "张三");         //设置Json对象的属性
		jsonObject.put("password", "123456");
		return jsonObject;
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
}