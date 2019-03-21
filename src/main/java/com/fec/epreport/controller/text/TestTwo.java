package com.fec.epreport.controller.text;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
/**
 * JSONObject 创建一个JSON对象并out.write();
 * @author Dana·Li
 */
public class TestTwo extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String urlPath="xxxx";
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");      //解决中文乱码问题

        PrintWriter out = response.getWriter();
        Map map = new HashMap(); 

        map.put("name", "Dana、Li"); 
        map.put("age", new Integer(22)); 
        map.put("Provinces", new String("广东省")); 
        map.put("citiy", new String("珠海市")); 
        map.put("Master", new String("C、C++、Linux、Java"));
        JSONObject json = JSONObject.fromObject(map); 
        
        out.write(json.toString());
        out.flush();
        out.close();
    }
    

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        //ServerFactory.getServer(8080).start();
        //列出原始数据
        StringBuilder json = new StringBuilder();   
//        URL oracle = new URL(GetJsonInterfaceInfo.urlPath); 
//        URLConnection yc = oracle.openConnection(); 
//        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(),"UTF-8")); 
//        String inputLine = null; 
//        while ( (inputLine = in.readLine()) != null){ 
//            json.append(inputLine); 
//        } 
//        in.close(); 
        String Strjson=json.toString();
        System.out.println("原始数据:");
        System.out.println(Strjson.toString()); 
    }

}