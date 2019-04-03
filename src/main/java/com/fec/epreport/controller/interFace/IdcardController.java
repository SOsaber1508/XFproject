/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.fec.epreport.controller.interFace;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.fec.epreport.dao.JedisClient;
import com.fec.epreport.service.InterFaceService;
import com.fec.epreport.util.baidu.BaiduHttpUtil;
import com.fec.epreport.util.baidu.Base64Util;
import com.fec.epreport.util.baidu.TokenUtil;
import com.fec.epreport.util.commons.FileUtil;
import com.fec.epreport.util.commons.PureNetUtil;
import com.fec.epreport.util.commons.StringUtils;


import java.util.List;
import java.util.UUID;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
/**
 * 身份证识别
 */
@Controller
@RequestMapping(value = "/baiduIDcard")
public class IdcardController {
	private static Logger logger = LoggerFactory.getLogger(IdcardController.class);

	
	@Autowired
	InterFaceService interFaceService;
	
	@Autowired
    JedisClient jedisClient;
	// 静态变量redis百度云票据
	private static String BdRedis = "Access_token";

	/**
	 * 重要提示代码中所需工具类 FileUtil,Base64Util,HttpUtil,GsonUtils请从
	 * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
	 * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
	 * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
	 * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3 下载
	 */
	@ResponseBody
	@RequestMapping(value = "/baidu.htm", method = RequestMethod.POST)
	public JSONObject baiduIDcard(HttpServletRequest req, HttpServletResponse resp) {
		logger.info("进入/baiduIDcard/baidu.htm");
		JSONObject json = new JSONObject();
		/**正式**/
		String sb = PureNetUtil.buffJson(req);
			if ("".equals(sb.toString())) {
				json.put("code", "208");
				return json;
			}
			
		//imageFile(req,resp);
		JSONObject wxObject = JSONObject.parseObject(sb);
		String wx_idcard=wxObject.getString("wx_idcard");
		String wx_id=wxObject.getString("wx_id");
		String phone=wxObject.getString("phone");
		String wx_name=wxObject.getString("wx_name");
		String wx_nickname=wxObject.getString("wx_nickname");
		//拓展名
		String fileExtName=wxObject.getString("fileExtName");
		//微信头像
		String wx_headimgurl="http://47.111.11.27:8080/epreport/imageFace/"+wx_id+"."+fileExtName;
		//String wx_headimgurl=req.getServletContext().getRealPath("/")+"imageFace"+"/"+wx_id+"."+fileExtName;
		System.out.println("读取的wx_headimgurl路径+++"+wx_headimgurl);
		/**
		 * 测试
		String wx_idcard="522530199208180048";
		String wx_id="o_xR71EEsi2313iZ7zmG2XXqd_u8FUbE";
		String fileExtName="png";
		String phone="18254737806";
		String wx_name="奈落落";
		String wx_nickname="奈落";
		 */
		// 身份证识别url
		String idcardIdentificate = "https://aip.baidubce.com/rest/2.0/ocr/v1/idcard";
		// 本地图片路径
		String filePath = req.getServletContext().getRealPath("/WEB-INF/upload/"+wx_id+"."+fileExtName);
		//String filePath = req.getServletContext().getRealPath("/")+"WEB-INF"+"/"+"upload"+"/"+wx_id+"."+fileExtName;
		//String filePath = "d:/demo-card-5.jpg";
		System.out.println("读取的身份证接口filePath路径+++"+filePath);
		//1.页面上传图片  multipart  我这边接
		
		//2.用流接解析成图片
		
		//3.你上传到固定的地址,json=wxId,   png/jpg,,        xxxx:/wxId   png/jpg
		
		try {
			byte[] imgData = FileUtil.readFileByBytes(filePath);
			String imgStr = Base64Util.encode(imgData);
			// 识别身份证正面id_card_side=front;识别身份证背面id_card_side=back;
			String params = "id_card_side=front&" + URLEncoder.encode("image", "UTF-8") + "="
					+ URLEncoder.encode(imgStr, "UTF-8");
			/**
			 * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
			 */
			// 24.af8e6bb0b02c0baf5f6c4707b6e2fda5.2592000.1553765130.282335-15632473
			String accessToken;
			// 调百度云tokenUtil
			accessToken = TokenUtil.IDcard();
			if (!StringUtils.isBlank(accessToken)) {
				jedisClient.del(BdRedis);
				jedisClient.set(BdRedis, accessToken);
				logger.info("redis删除+添加新的");
			} else {
				accessToken = jedisClient.get(BdRedis);
				logger.info("票据没过期直接读redis里的");
			}
			// 结果
			JSONObject resultObject = JSONObject
					.parseObject(BaiduHttpUtil.post(idcardIdentificate, accessToken, params));
			System.out.println(resultObject);
			JSONObject param = new JSONObject();
			param = resultObject.getJSONObject("words_result");
			if(param.getJSONObject("公民身份号码").getString("words").equals("")) {
				json.put("code", "203");//没识别出来(要么是图片不够清晰要么不是身份证图片)
				return json;
			}
			// getJSONObject("姓名");
			//HashMap<String, String> resultmap = new HashMap<>();
			//resultmap.put("Home", param.getJSONObject("住址").getString("words"));// 住址
			//resultmap.put("birthDay", param.getJSONObject("出生").getString("words"));// 出生
			//resultmap.put("idCard", param.getJSONObject("公民身份号码").getString("words"));// 公民身份号码
			//resultmap.put("sex", param.getJSONObject("性别").getString("words"));// 性别
			//resultmap.put("userName", param.getJSONObject("姓名").getString("words"));// 性别
			//resultmap.put("code", "200");// 状态吗
			//System.out.println(resultmap);
			
			if(wx_idcard.equals(param.getJSONObject("公民身份号码").getString("words"))) {
				int i=interFaceService.identityAuthentication(wx_id,wx_idcard,phone,wx_name,wx_nickname,wx_headimgurl);
				if(i==1) {
					json.put("code", "200");
				}else {
					json.put("code", "208");
				}
				
			}else {
				json.put("code", "202");
			}
			//PrintWriter out = new PrintWriter(resp.getOutputStream());
			//out.print(json);
			//out.flush();
		} catch (Exception e) {
			json.put("code", "208");
			logger.error(e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * Base64对字符串和文件流的编码和解码：
	 * 
	 * @param arg
	 * @throws IOException
	 */
//	public static void main(String arg[]) throws IOException {
//		// 1.字符串的编码
//		String base64 = Base64.getEncoder().encodeToString("asdsadadad".getBytes("utf-8"));
//		// 可以将字符串转成Base64格式的串
//		System.out.println(base64);
//		// 2.字符串解码
//		String str = new String(Base64.getDecoder().decode(
//				"SmF2YTggQmFzZTY0IEphdmEgOCDmlrDnibnmgKcg5ZyoSmF2YSA45LitLEJhc2U2NOe8lueggeW3sue7j+aIkOS4ukphdmHnsbvlupPnmoTmoIflh4bjgIIgSmF2YSA4IOWGhee9ruS6hiBCYXNlNjQg57yW56CB55qE57yW56CB5Zmo5ZKM6Kej56CB5Zmo44CCIEJhc2U2NOW3peWFt+exu+aPkOS+m+S6huS4gOWll+mdmeaAgS4uLg=="),
//				"UTF-8");
//		// 对Base64的串实现解码
//		System.out.println(str);
//
//		// 3.文件实现Base64编码
//		File file = new File("C:\\Users\\Loufree\\Desktop\\1.png");
//		// 使用了非阻塞的java.nio工具包，以上是将1.png图片转成base64编码
//		byte[] b = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
//		String base64Str = Base64.getEncoder().encodeToString(b);
//		// 对Base64的串实现解码
//		System.out.println(base64Str);
//
//		// 4. Base64解码成文件
//		String str1 = "ZG9ja2VyIGVjbGlwc2Xmj5Lku7YNCuWQjeensO+8mmRvY2tlci1uaWdodGx5DQrlnLDlnYDvvJpodHRwOi8vZG93bmxvYWQuZWNsaXBzZS5vcmcvbGludXh0b29scy91cGRhdGVzLWRvY2tlci1uaWdodGx5Lw==";
//		Files.write(Paths.get("D:/create.txt"), Base64.getDecoder().decode(str), StandardOpenOption.CREATE);
//		// 使用了非阻塞的java.nio工具包，Base64解码成文件。
//		System.out.println(str1);
//	}

//	// 接收流
//	@RequestMapping(value = "/portal/redirect", method = { RequestMethod.POST, RequestMethod.GET }, produces = {
//			"text/html;charset=UTF-8" })
//	public String test(HttpServletRequest request) {
//		InputStream inputStream;
//		String json = "";
//		String res = "";
//		// 获得响应流，获得输入对象
//		try {
//			inputStream = request.getInputStream();
//			// 建立接收流缓冲，准备处理
//			StringBuffer requestBuffer = new StringBuffer();
//			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
//			// 读入流，并转换成字符串
//			String readLine;
//			while ((readLine = reader.readLine()) != null) {
//				requestBuffer.append(readLine).append("\n");
//			}
//			reader.close();
//			json = requestBuffer.toString();
//			// logger.error("RequestInfo:" + xmlInfo);
//		} catch (Exception e) {
//			// logger.error("接收同步消息失败"+e);
//		}
//		logger.debug("request json:" + json);
//		return "manage/typography";
//	}
	
//	@RequestMapping(value = "/imageFile.htm", method = RequestMethod.POST)
//	public void imageFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		//解决post请求的乱码
//		//request.setCharacterEncoding("utf-8");
//		
//	/*	//获取一个输入流
//		ServletInputStream in = request.getInputStream();
//		
//		//读取流
//		String str = IOUtils.toString(in);
//		
//		System.out.println(str);*/
//		
//		
//		//获取工厂类实例
//		DiskFileItemFactory factory = new DiskFileItemFactory();
//		
//		//创建解析器类实例
//		ServletFileUpload fileUpload = new ServletFileUpload(factory);
//		
//		//fileUpload通过该对象来限制文件的大小
//		//设置当文件的大小为50KB
//		//fileUpload.setFileSizeMax(1024*50);
//		
//		//设置多个文件的总大小为300mb
//		fileUpload.setSizeMax(1024*1024*300);
//		 //消息提示
//        String message = "";
//		try {
//			//解析request
//			List<FileItem> fileItems = fileUpload.parseRequest(request);
//			
//			//遍历fileItems，读取表单的信息
//			for (FileItem fileItem : fileItems) {
//				
//				//判断当前表单项是否是一个普通表单项
//				if(fileItem.isFormField()){
//					//获取属性名
//					String fieldName = fileItem.getFieldName();
//					//获取属性值
//					String value = fileItem.getString("utf-8");
//					System.out.println(fieldName+" = "+value);
//				}else{
//					//如果是文件表单项
//					//获取文件的大小
//					long size = fileItem.getSize();
//					
//					//判断size是否为0
//					if(size==0){
//						continue;
//					}
//					
//					//获取文件的类型
//					String contentType = fileItem.getContentType();
//					
//					//获取文件的名字
//					String name = fileItem.getName();
//					//判断name中是否包含有路径信息
//					if(name.contains("\\")){
//						//如果包含则截取字符串
//						name = name.substring(name.lastIndexOf("\\")+1);
//					}
//					
//					//生成一个UUID，作为文件名的前缀
//					String prefix = UUID.randomUUID().toString().replace("-", "");
//					name = prefix+"_"+name;
//					
//					
//					//获取表单项的属性名
//					String fieldName = fileItem.getFieldName();
//					
//					System.out.println("文件的大小: "+size);
//					System.out.println("文件的类型: "+contentType);
//					System.out.println("文件的名字: "+name);
//					System.out.println("表单项name属性名: "+fieldName);
//					
//					//获取ServletContext对象
//					//ServletContext context = this.getServletContext();
//					//获取项目的真实路径
//					String path = request.getServletContext().getRealPath("/WEB-INF/upload");
//					
//					//判断路径是否存在
//					File file = new File(path);
//					if(!file.exists()){
//						//如果不存在该路径，则创建一个路径
//						file.mkdirs();
//					}
//					
//					//将文件写入到磁盘中
//					fileItem.write(new File(path+"/"+name));
//					message = "文件上传成功！";
//				}
//			}
//			//重定向到一个页面
//			//response.sendRedirect(request.getContextPath()+"/success.jsp");
//		}catch(FileSizeLimitExceededException e){
//			//一但捕获到该异常，则说明单个文件大小超过限制。
//			//设置一个错误消息
//			request.setAttribute("msg", "单个文件大小请不要超过50KB");
//			//转发到index.jsp
//			//request.getRequestDispatcher("/index.jsp").forward(request, response);
//		}catch(SizeLimitExceededException e){
//			//一但捕获到该异常，则说明单个文件大小超过限制。
//			//设置一个错误消息
//			request.setAttribute("msg", "所有文件大小请不要超过300mb");
//			//转发到index.jsp
//			//request.getRequestDispatcher("/index.jsp").forward(request, response);
//		}
//		catch (FileUploadException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		  request.setAttribute("message",message);
//		
//	}
}
