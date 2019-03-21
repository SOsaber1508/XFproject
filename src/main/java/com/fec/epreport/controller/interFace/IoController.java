package com.fec.epreport.controller.interFace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fec.epreport.util.commons.JsonUtils;

@Controller
@RequestMapping(value = "/interface2")
public class IoController {
	private static final String SUCCESS = "nice";
	private static Logger logger = LoggerFactory.getLogger(IoController.class);
	@RequestMapping(value = "/ceshi.htm", method = RequestMethod.GET)
	public String httpRequest(String requestUrl, String requestMethod, Map<String, String> requestParameters) throws IOException {
	    try {
	        URL url = new URL("http://192.168.3.45:8083/epreport/interface/ceshi2.htm");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setDoOutput(true);//需要用到输出流
	        conn.setDoInput(true);//需要用到输入流
	        conn.setRequestMethod(requestMethod);
	        conn.setRequestProperty("content-type", "text/html");//设置内容类型
	        // 使用输出流添加数据至请求体
	        if (requestParameters.size() != 0) {
	            String json = JsonUtils.toJson(requestParameters);//转换为json
	            OutputStream os = conn.getOutputStream();//获取输出流
	            os.write(json.getBytes());//写入
	            os.flush();
	        }
	        conn.connect();
	        // 读取服务器端返回的内容
	        InputStream is = conn.getInputStream();
	        InputStreamReader isr = new InputStreamReader(is, "utf-8");
	        BufferedReader br = new BufferedReader(isr);
	        StringBuffer buffer = new StringBuffer();
	        String line;
	        while ((line = br.readLine()) != null) {
	            buffer.append(line);
	        }
	        return buffer.toString();
	    } catch (Exception e) {
	        logger.error("http请求异常", e);
	        throw e;
	    }
	}
	
	public String activate(HttpServletRequest request, HttpServletResponse response) throws IOException{
	    InputStream is = null;
	    try {
	        is = request.getInputStream();//获取输入流
	        ArrayList<Byte> arr = new ArrayList<Byte>();
	        byte[] buffer = new byte[50];//缓存数组
	        int len;
	        //读取数据
	        while ((len=is.read(buffer))!=-1) {
	            for (int i = 0; i < len; i++) {
	                arr.add(buffer[i]);
	            }
	        }
	        byte[] src = new byte[arr.size()];
	        for (int i = 0; i < src.length; i++) {
	            src[i] = arr.get(i);
	        }
	        String json = new String(src);
	        @SuppressWarnings("unchecked")
	        Map<String, Object> map = JsonUtils.toMap(json);
	        System.out.println(map);
	    }  catch (Exception e) {
	        e.printStackTrace();
	    }  finally {
	        if (is != null)
	            is.close();
	    }
	    return SUCCESS;
	}
	
	
	
	
	
	
	
	
}


