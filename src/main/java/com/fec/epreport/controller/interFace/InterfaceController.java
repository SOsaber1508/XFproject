package com.fec.epreport.controller.interFace;

import com.alibaba.fastjson.JSONObject;
import com.fec.epreport.service.RedisService;
import com.fec.epreport.util.commons.PureNetUtil;
import com.fec.epreport.util.http.HttpClientPoolHelper;

import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
@RequestMapping(value = "/interface")
public class InterfaceController {
	private static HttpClientPoolHelper hcph = HttpClientPoolHelper.getInstance();

	@Autowired
	private RedisService redisService;

	private static Logger logger = LoggerFactory.getLogger(InterfaceController.class);

	// 保存图片
	// @RequestMapping(value = "/xxxx.htm", method = RequestMethod.GET)
	// public void getImage() throws Exception{
	public static void main(String[] args) throws Exception {
		// new一个URL对象
		URL url = new URL("http://t2.hddhhn.com/uploads/tu/20150700/tqywprfq2is.jpg");
		// 打开链接
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// 设置请求方式为"GET"
		conn.setRequestMethod("GET");
		// 超时响应时间为5秒
		conn.setConnectTimeout(5 * 1000);
		// 通过输入流获取图片数据
		InputStream inStream = conn.getInputStream();
		// 得到图片的二进制数据，以二进制封装得到数据，具有通用性
		byte[] data = PureNetUtil.readInputStream(inStream);
		// new一个文件对象用来保存图片，默认保存当前工程根目录
		File imageFile = new File("pic20190219.jpg");
		// 创建输出流
		FileOutputStream outStream = new FileOutputStream(imageFile);
		// 写入数据
		outStream.write(data);
		// 关闭输出流
		outStream.close();
	}

	// 测试接口
	public String getIPXY(String ip) {
		// ip转经纬度
		String url = "http://192.168.3.46";
		String result = PureNetUtil.get(url);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "奈落落");
		jsonObject.put("passward", "qaz00608704");
		jsonObject.put("nickname", "奈落");
		return null;
	}

	/**
	 * zcy 2019年2月18日09:55:59
	 * 
	 * @return
	 */
	// 构造的json测试接口
	@ResponseBody
	@RequestMapping(value = "/ceshi.htm", method = RequestMethod.GET)
	public JSONObject ceshi() {
		JSONObject params = new JSONObject();
		params.put("SRC_STM_CODE", "222");
		params.put("TENANT_ID", "222");
		params.put("NM", "222");
		params.put("BRTH_DT", "1983-01-20");
		params.put("GND_CODE", "asdads");
		JSONArray params2 = new JSONArray();
		JSONObject param3 = new JSONObject();
		param3.put("DOC_TP_CODE", "10100");
		param3.put("DOC_NBR", "100200198301202210");
		param3.put("DOC_CUST_NM", "test");
		params2.add(param3);
		params.put("DOCS", params2);
		return params;
	}

	/**
	 * zcy 2019年2月18日09:55:59
	 * 
	 * @return
	 */
	// get测试接口
	@ResponseBody
	@RequestMapping(value = "/ceshi2.htm", method = RequestMethod.POST)
	public JSONObject ceshi2() {
		JSONObject params = new JSONObject();
		params.put("name", "zcy");
		params.put("passward", "qaz006");
		params.put("nickname", "zzzz");
		return params;
	}

	@ResponseBody
	@RequestMapping(value = "/get.htm", method = RequestMethod.GET)
	public void get() {
		String result = PureNetUtil.get("http://192.168.3.45:8083/epreport//interface/get.htm");
		System.out.println(result);
	}

	/**
	 * zcy 2019年2月18日09:55:59
	 * 
	 * @return
	 */
	//
	@ResponseBody
	@RequestMapping(value = "/ceshi3.htm", method = RequestMethod.POST)
	public JSONObject ceshi3() {
		JSONObject params = new JSONObject();
		params.put("name", "zcy");
		params.put("passward", "qaz006");
		params.put("nickname", "zzzz");
		return params;
	}

	public void ImageInterface(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		// 回复给客户端一个信息
		pw.println("receive!");
		// 利用request对象返回客户端来的输入流
		try (ServletInputStream sis = request.getInputStream()) {
			OutputStream os = new FileOutputStream("d:/pic20190219.jpg");
			BufferedOutputStream bos = new BufferedOutputStream(os);
			byte[] buf = new byte[1024];
			int length = 0;
			length = sis.readLine(buf, 0, buf.length);// 使用sis的读取数据的方法
			while (length != -1) {
				bos.write(buf, 0, length);
				length = sis.read(buf);
			}
			sis.close();
			bos.close();
			os.close();
		}

	}

//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
//			throws ServletException, IOException {
//		//转到doGet中做处理
//		doGet(request, response);
//	}
	// 测试redis
	@RequestMapping(value = "/ceshi4.htm", method = RequestMethod.GET)
	public void ceshi4() {
		redisService.getUserList(0);
	}

	@RequestMapping(value = "/getLiu.htm", method = { RequestMethod.POST, RequestMethod.GET }, produces = {
			"text/html;charset=UTF-8" })
	public ModelAndView test(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		System.out.println("进来了");
		InputStream inputStream;
		String json = "";
		String res = "";
		// 获得响应流，获得输入对象
		try {
			inputStream = request.getInputStream();
			// 建立接收流缓冲，准备处理
			StringBuffer requestBuffer = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
			// 读入流，并转换成字符串
			String readLine;
			while ((readLine = reader.readLine()) != null) {
				requestBuffer.append(readLine).append("\n");
			}
			reader.close();
			json = requestBuffer.toString();
			// logger.error("RequestInfo:" + xmlInfo);
		} catch (Exception e) {
			// logger.error("接收同步消息失败"+e);
		}
		System.out.println("request json:" + json);
//mav.setViewName("redirect:../../pic/index.html");
		return null;
	}

	// http连接池接口用法
	// 示例
	public String httpCeshi() {
		String targetUrl = "asdasdadad";
		JSONObject requestJson = new JSONObject();
		requestJson.put("name", "zcy");
		requestJson.put("passward", "qaz006");
		requestJson.put("nickname", "zzzz");
		String result = null;
		// 实体list =manageServer.selcet(xxxxxx); 查出来的东西
		// list 直接转string 也行 应该有把
		// result = hcph.postRequest(targetUrl, 要传的);
		try {
			result = hcph.postRequest(targetUrl, requestJson.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

//	// http连接池接口用法
//	// 示例
//	@RequestMapping(value = "/wx_certification.htm", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
//	public void wx_certification(HttpServletRequest request) throws UnsupportedEncodingException, IOException {
//		try (InputStreamReader reader = new InputStreamReader(request.getInputStream(), "UTF-8")) {
//			// 后台接收
//			char[] buff = new char[1024];
//			int length = 0;
//			while ((length = reader.read(buff)) != -1) {
//				String x = new String(buff, 0, length);
//				System.out.println(x);
//			}
//			reader.close();
//			String targetUrl = "asdasdadad";
//			JSONObject requestJson = new JSONObject();
////		requestJson.put("name", "zcy");
////		requestJson.put("passward", "qaz006");
////		requestJson.put("nickname", "zzzz");
//			String result = null;
//			// 实体list =manageServer.selcet(xxxxxx); 查出来的东西
//			// list 直接转string 也行 应该有把
//			// result = hcph.postRequest(targetUrl, 要传的);
//			try {
//				// result = hcph.postRequest(targetUrl, requestJson.toString());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//	}
}
