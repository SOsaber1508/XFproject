package com.fec.epreport.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

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
    }
}
