package com.fec.epreport.util.commons;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import net.sf.json.JSONObject;
/**
 * 给接口传递json格式的数据
 * @author zcy
 *
 */
public class AppAddJson {
    public static final String ADD_URL = "http://192.168.3.45:8080/xxx/xxx";
    public static void appadd() {
        try {
            URL url = new URL(ADD_URL);
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
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        appadd();
    }

}