package com.fec.epreport.util.http;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;


/**
 * http连接池
 * @author zcy
 *
 */
public class HttpClientPoolHelper {

    private static Logger logger = Logger.getLogger(HttpClientPoolHelper.class);

    private static HttpClientPoolHelper httpClientPoolHelper = new HttpClientPoolHelper();
    public static HttpClientPoolHelper getInstance(){
        return httpClientPoolHelper;
    }

    private CloseableHttpClient httpClient;

    private RequestConfig requestConfig;

    /**
     * 重试次数
     */
    private final static int retryCount = 3;

    /**
     * 最大连接数
     */
    private final static int maxTotal = 200;

    /**
     * 每个路由基础的最大连接数
     */
    private final static int defaultMaxPerRoute = 200;

    /**
     * 从连接管理器请求连接时使用的超时
     */
    private final static int connectionRequestTimeout = 20000;

    /**
     * 连接超时
     */
    private final static int connectTimeout = 20000;

    /**
     * 等待数据超时
     */
    private final static int socketTimeout = 20000;

    public HttpClientPoolHelper() {
    	//socketTimeout=20000;
        ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
        LayeredConnectionSocketFactory sslsf = SSLConnectionSocketFactory.getSocketFactory();
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", plainsf)
                .register("https", sslsf)
                .build();

        //请求重试处理
        HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
            public boolean retryRequest(IOException exception,int executionCount, HttpContext context) {
                if (executionCount >= retryCount) {// 重试次数                    
                    return false;
                }
                if (exception instanceof NoHttpResponseException) {// 如果服务器丢掉了连接，那么就重试                    
                    return true;
                }
                if (exception instanceof SSLHandshakeException) {// 不要重试SSL握手异常                    
                    return false;
                }                
                if (exception instanceof InterruptedIOException) {// 超时                    
                    return false;
                }
                if (exception instanceof UnknownHostException) {// 目标服务器不可达                    
                    return false;
                }
                if (exception instanceof ConnectTimeoutException) {// 连接被拒绝                    
                    return false;
                }
                if (exception instanceof SSLException) {// ssl握手异常                    
                    return false;
                }

                HttpClientContext clientContext = HttpClientContext.adapt(context);
                HttpRequest request = clientContext.getRequest();

                if (!(request instanceof HttpEntityEnclosingRequest)) {                    
                    return true;
                }
                return false;
            }
        };  

        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);

        cm.setDefaultSocketConfig(SocketConfig.custom().setSoKeepAlive(true).build());

        // 最大连接数
        cm.setMaxTotal(maxTotal);
        // 每个路由基础的连接数
        cm.setDefaultMaxPerRoute(defaultMaxPerRoute);

        httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .setRetryHandler(httpRequestRetryHandler)
                .build();

        // 配置请求的超时设置。单位都是毫秒
        // ConnectTimeout:连接超时
        // SocketTimeout:等待数据超时
        // ConnectionRequestTimeout:从连接管理器请求连接时使用的超时
        requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .setConnectTimeout(connectTimeout)
                .setSocketTimeout(socketTimeout)
                .build();
    }

    public String getRequest(String targetUrl) throws Exception {
        long start = System.currentTimeMillis(); 
        if (StringUtils.isBlank(targetUrl)) {
            throw new IllegalArgumentException("调用getRequest方法，targetUrl不能为空!");
        }
        String responseResult = null;
        CloseableHttpResponse response = null;
        try {
            HttpGet httpget = new HttpGet(targetUrl);
            httpget.setConfig(requestConfig);
            response = httpClient.execute(httpget);
            responseResult = EntityUtils.toString(response.getEntity(), "UTF-8");
        } finally {
            // 释放链接
            response.close();
        }
        long end = System.currentTimeMillis();
        logger.debug("getRequest "+targetUrl+" elapse "+(end - start)+" ms " );
        return responseResult;
    }

    public String postRequest(String targetUrl, String requestContent) throws Exception {

        return postRequest(targetUrl, requestContent, null);
    }

    public String postRequest(String targetUrl, String requestContent, String contentType) throws Exception {
        long start = System.currentTimeMillis();

        if (StringUtils.isBlank(targetUrl)) {
            throw new IllegalArgumentException("调用postRequest方法，targetUrl不能为空!");
        }

        String responseResult = null;

        CloseableHttpResponse response = null;

        try {
            HttpPost httppost = new HttpPost(targetUrl);
            // 设置超时
            httppost.setConfig(requestConfig);

            if (!StringUtils.isBlank(requestContent)) {
                StringEntity entity = new StringEntity(requestContent, "UTF-8");
                entity.setContentEncoding("UTF-8");
                if(StringUtils.isNotBlank(contentType)){
                    entity.setContentType(contentType);
                }
                httppost.setEntity(entity);
            }

            response = httpClient.execute(httppost);

            responseResult = EntityUtils.toString(response.getEntity(), "UTF-8");
        } finally {
            // 释放链接
            if (response != null) {
                response.close();
            }
        }

        long end = System.currentTimeMillis();
        logger.debug("postRequest "+targetUrl+" elapse "+(end - start)+" ms ");
        return responseResult;
    }

    public CloseableHttpClient getHttpClient() {
        return httpClient;
    }

    public RequestConfig getRequestConfig() {
        return requestConfig;
    }  
    
  //参考调用方式
    /**
     * private static HttpClientPoolHelper hcph = HttpClientPoolHelper.getInstance();
	 *	try {
     *	result = hcph.postRequest(targetUrl, requestJson.toString());
     *	} catch (Exception e) {
    		e.printStackTrace();
		}
     * 
     */
    
    
    
}