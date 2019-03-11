
package com.fec.epreport.util.commons;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONObject;

import java.util.Set;

public class PureNetUtil {
	/**
	 * get方法直接调用post方法
	 * 
	 * @param url
	 *            网络地址
	 * @return 返回网络数据
	 */
	public static String get(String url) {
		return post(url, null);
	}

	/**
	 * 设定post方法获取网络资源,如果参数为null,实际上设定为get方法
	 * 
	 * @param url
	 *            网络地址
	 * @param param
	 *            请求参数键值对
	 * @return 返回读取数据
	 */
	public static String post(String url, Map param) {
		HttpURLConnection conn = null;
		try {
			URL u = new URL(url);
			conn = (HttpURLConnection) u.openConnection();
			StringBuffer sb = null;
			if (param != null) {// 如果请求参数不为空
				sb = new StringBuffer();
				/*
				 * A URL connection can be used for input and/or output. Set the
				 * DoOutput flag to true if you intend to use the URL connection
				 * for output, false if not. The default is false.
				 */
				// 默认为false,post方法需要写入参数,设定true
				conn.setDoOutput(true);
				// 设定post方法,默认get
				conn.setRequestMethod("POST");
				// 获得输出流
				OutputStream out = conn.getOutputStream();
				// 对输出流封装成高级输出流
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
				// 将参数封装成键值对的形式
				Set<Map.Entry<String, String>> p = param.entrySet();
				for (Entry<String, String> entry : p) {
					sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
				}
				// 将参数通过输出流写入
				writer.write(sb.deleteCharAt(sb.toString().length() - 1).toString());
				writer.close();// 一定要关闭,不然可能出现参数不全的错误
				sb = null;
			}
			conn.connect();// 建立连接
			sb = new StringBuffer();
			// 获取连接状态码
			int recode = conn.getResponseCode();
			BufferedReader reader = null;
			if (recode == 200) {
				// Returns an input stream that reads from this open connection
				// 从连接中获取输入流
				InputStream in = conn.getInputStream();
				// 对输入流进行封装
				reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
				String str = null;
				sb = new StringBuffer();
				// 从输入流中读取数据
				while ((str = reader.readLine()) != null) {
					sb.append(str).append(System.getProperty("line.separator"));
				}
				// 关闭输入流
				reader.close();
				if (sb.toString().length() == 0) {
					return null;
				}
				//返回字符串
				return sb.toString().substring(0,
						sb.toString().length() - System.getProperty("line.separator").length());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null)// 关闭连接
				conn.disconnect();
		}
		return null;
	}
	
	/**
	 * zcy
	 * @param inStream
	 * @return
	 * @throws Exception
	 */
	//得到图片的二进制数据，以二进制封装得到数据，具有通用性  
    public static byte[] readInputStream(InputStream inStream) throws Exception{  
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        //创建一个Buffer字符串  
        byte[] buffer = new byte[1024];  
        //每次读取的字符串长度，如果为-1，代表全部读取完毕  
        int len = 0;  
        //使用一个输入流从buffer里把数据读取出来  
        while( (len=inStream.read(buffer)) != -1 ){  
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度  
            outStream.write(buffer, 0, len);  
        }  
        //关闭输入流  
        inStream.close();  
        //把outStream里的数据写入内存  
        return outStream.toByteArray();  
    }
    /**
     * 发送数据工具
     * @throws IOException 
     */
    public static String appPost(String url1) throws IOException {
    	URL url = new URL("http://192.168.3.45:8083/epreport/interface/getLiu.htm");
        HttpURLConnection connection = (HttpURLConnection) url
                .openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("connection", "Keep-Alive");
        //connection.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
        connection.connect();
    	 //POST请求
        DataOutputStream out = new DataOutputStream(
                connection.getOutputStream());
        JSONObject obj = new JSONObject();
        String message = java.net.URLEncoder.encode("哈哈哈","utf-8");
        obj.element("detail", "df");
        obj.element("TEXT1", "asd");
        obj.element("TEXT2", message);
        out.writeBytes("data="+obj.toString());
        System.out.println("data="+obj.toString());
        out.flush();
        out.close();
        //读取响应
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
        String lines;
        StringBuffer sb = new StringBuffer("");
        while ((lines = reader.readLine()) != null) {
            lines = new String(lines.getBytes(), "utf-8");
            sb.append(lines);
        }
        System.out.println(sb);
        reader.close();
        connection.disconnect();
    	return null;
    	
    }
    
    public static void main(String[]args) throws IOException {
    	appPost(null);
    }
    
    
}
