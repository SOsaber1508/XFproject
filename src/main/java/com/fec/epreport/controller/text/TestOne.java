package com.fec.epreport.controller.text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

public class TestOne {
	private static Logger logger = LoggerFactory.getLogger(TestOne.class);
	public static void main(String[] args) {
		JSONObject jsobj1 = new JSONObject();
		JSONObject jsobj2 = new JSONObject();
		jsobj2.put("deviceID", "112");
		jsobj2.put("channel", "channel");
		jsobj2.put("state", "0");
		jsobj1.put("item", jsobj2);
		jsobj1.put("requestCommand", "control");
		post(jsobj1, "http://192.168.3.45:8083/epreport/test1/test.htm");
	}

	public static String post(JSONObject json, String path) {
		String result = "";
		try {
			CloseableHttpClient client = HttpClients.createDefault();
			HttpPost post = new HttpPost(path);
			post.setHeader("Content-Type", "appliction/json");
			post.addHeader("Authorization", "Basic YWRtaW46");
			StringEntity s = new StringEntity(json.toString(), "utf-8");
			s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "appliction/json"));
			post.setEntity(s);
			HttpResponse httpResponse = client.execute(post);
			InputStream in = httpResponse.getEntity().getContent();//调用getEntity()方法获取到一个HttpEntity实例
			BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
			StringBuilder strber = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null) {
				strber.append(line + "\n");
			}
			in.close();
			result = strber.toString();
			if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				result = "服务器异常";
			}
		} catch (Exception e) {
			logger.info("请求异常");
			throw new RuntimeException(e);
		}
		logger.info("result==" + result);
		return result;
	}
}