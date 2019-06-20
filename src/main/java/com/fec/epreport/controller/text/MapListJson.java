package com.fec.epreport.controller.text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class MapListJson {
	public static void main(String []args) {
        String soap = "1111";
        List<String> list = new ArrayList<>();
        JSONObject param1 = new JSONObject();
        Map<String, String> param0 = new HashMap<String, String>();
        list.add(soap);
        list.add(soap);
        param1.put("soap",soap);
        param1.put("soap","2222");
        param0.put("soap",soap);
        param0.put("soap","3333");

        System.out.println("这是list的输出：" + list);
        System.out.println("这是json的输出：" + param1);
        System.out.println("这是map的输出：" + param0);
        
        JSONArray jsonArray = new JSONArray();
        JSONObject json = new JSONObject();
        json.put("a","1");
        json.put("b","2");
        json.put("c","3");
        jsonArray.add(json);
        System.out.println(jsonArray);
        
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("code", "200");
        
        System.out.println(map2);
        
        List<Map<String,Object>> listjsonObject = new ArrayList<Map<String,Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("1", "a");
        map1.put("2", "b");
        map1.put("3", "c");
        listjsonObject.add(map1);

        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("11", "aa");
        map3.put("22", "bb");
        map3.put("33", "cc");
        listjsonObject.add(map3);
        System.out.println(listjsonObject);
    }
}
