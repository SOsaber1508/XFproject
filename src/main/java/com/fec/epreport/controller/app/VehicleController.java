package com.fec.epreport.controller.app;

import com.fec.epreport.controller.backstage.DemoController;
import com.fec.epreport.service.ManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/vehicle")
public class VehicleController {
    private static Logger logger = LoggerFactory.getLogger(DemoController.class);
    @Autowired
    ManageService manageService;
    //车源详情查询
    @ResponseBody
    @RequestMapping({ "/selectVehicleDetails.htm" })
    public String selectVehicleDetails(Integer vehicle_id,Integer user_id){
        try {
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("user_id",user_id);
            hashMap.put("vehicle_id",vehicle_id);


        } catch (Exception e) {
            logger.error("错误提示："+e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
        return "";
    }
    //车源列表查询
    @ResponseBody
    @RequestMapping({ "/selectVehicles.htm" })
    public String selectVehicles(){
        try {

        } catch (Exception e) {
            logger.error("错误提示："+e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
        return "";
    }
    //根据条件查询车源列表
    @ResponseBody
    @RequestMapping({ "/selectVehiclesCondition.htm" })
    public String selectVehiclesCondition(String vehicle_start,String vehicle_end,Integer sort,Double vehicle_length,
                                            String vehicle_type,Double vehicle_loadmin,Double vehicle_loadmax){
        try {
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("vehicle_start",vehicle_start);
            hashMap.put("vehicle_end",vehicle_end);
            hashMap.put("sort",sort);
            hashMap.put("vehicle_length",vehicle_length);
            hashMap.put("vehicle_type",vehicle_type);
            hashMap.put("vehicle_loadmin",vehicle_loadmin);
            hashMap.put("vehicle_loadmax",vehicle_loadmax);



        } catch (Exception e) {
            logger.error("错误提示："+e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
        return "";
    }
    //发布车源
    @ResponseBody
    @RequestMapping({ "/releaseCar.htm" })
    public String releaseCar(String vehicle_start,String vehicle_end,String vehicle_contacts,String vehicle_contactinformation,
                             Double vehicle_length,String vehicle_type,String vehicle_detaileddescription){
        try {
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("vehicle_start",vehicle_start);
            hashMap.put("vehicle_end",vehicle_end);
            hashMap.put("vehicle_contacts",vehicle_contacts);
            hashMap.put("vehicle_contactinformation",vehicle_contactinformation);
            hashMap.put("vehicle_length",vehicle_length);
            hashMap.put("vehicle_type",vehicle_type);
            hashMap.put("vehicle_detaileddescription",vehicle_detaileddescription);


        } catch (Exception e) {
            logger.error("错误提示："+e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
        return "";
    }
}
