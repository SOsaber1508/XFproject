package com.fec.epreport.service;

public interface HttpClientService {

	public String httpClientGet(String requestUrl);
	
	public String httpClientPost(String requestUrl,String json);
}
