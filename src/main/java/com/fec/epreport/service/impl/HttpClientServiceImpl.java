package com.fec.epreport.service.impl;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.fec.epreport.service.HttpClientService;

public class HttpClientServiceImpl implements HttpClientService {

	private static final Logger log = Logger.getLogger(HttpClientServiceImpl.class);

	public String httpClientGet(String requestUrl) {
		log.info("URL:" + requestUrl);

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(requestUrl);
		String result = null;
		try {
			CloseableHttpResponse response = httpclient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if (response.getStatusLine().getReasonPhrase().equals("OK")
					&& response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result = EntityUtils.toString(entity, "UTF-8");
			}
			EntityUtils.consume(entity);
			response.close();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		log.info("result:" + result);
		return result;
	}

	public String httpClientPost(String requestUrl, String json) {
		log.info("URL:" + requestUrl);
		log.info("json:" + json);

		HttpPost method = new HttpPost(requestUrl);

		// 接收参数json列表
		StringEntity entity = new StringEntity(json, "utf-8");// 解决中文乱码问题
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		method.setEntity(entity);
		HttpResponse result = null;
		String resData = null;
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
			result = httpclient.execute(method);
			resData = EntityUtils.toString(result.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONObject resJson = JSONObject.fromObject(resData);
		log.info(resJson.toString());
		return resJson.toString();
	}
}
