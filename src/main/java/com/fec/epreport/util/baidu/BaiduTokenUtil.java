package com.fec.epreport.util.baidu;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * 获取token类
 */
public class BaiduTokenUtil {
	private static Logger logger = LoggerFactory.getLogger(BaiduTokenUtil.class);
    /**
     * 获取权限token
     * @return 返回示例：
     * {
     * "access_token": "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567",
     * "expires_in": 2592000
     * }
     */
	
	//测试方法
//	public static void main(String arg[]) {
//        // 官网获取的 API Key 更新为你注册的
//        String clientId = "9nVQ1W2m4u8K4Ij8YgZAAqXe";
//        // 官网获取的 Secret Key 更新为你注册的
//        String clientSecret = "cuf4b6kNozXxZhmMdk0gvVrFYF9QbvO3";
//        System.out.println("开始了");
//        getAuth(clientId, clientSecret);
//    }
	
	//暂时用的奈落的相关密钥
    public static String getAuth() {
        // 官网获取的 API Key 更新为你注册的
        String clientId = "vl4gONK0BvujMG72BQWXK8sY";
        // 官网获取的 Secret Key 更新为你注册的
        String clientSecret = "5Q3lkWCQuZojj4XlO2GbYu0MS6bxE27s";
        return getAuth(clientId, clientSecret);
    }

    /**
     * 获取API访问token
     * 该token有一定的有效期，需要自行管理，当失效时需重新获取.
     * @param ak - 百度云官网获取的 API Key
     * @param sk - 百度云官网获取的 Securet Key
     * @return assess_token 示例：
     * "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567"
     * 24.5fd076f0ab70f3924704c74b11874655.2592000.1554367191.282335-15632473
     */
    public static String getAuth(String ak, String sk) {
        // 获取token地址
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + ak
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + sk;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.err.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
            System.err.println("result:" + result);
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            logger.info("access_token+++++++++++++++"+access_token);
            return access_token;
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            logger.error(e.getLocalizedMessage(), e);
            e.printStackTrace(System.err);
        }
        return null;
    }

}
