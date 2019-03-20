package com.fec.epreport.controller.app;

import com.fec.epreport.service.ManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/goods")
public class GoodsController {
    private static Logger logger = LoggerFactory.getLogger(GoodsController.class);
    @Autowired
    ManageService manageService;
    //货源详情查询
    @ResponseBody
    @RequestMapping("/selectSourceDetails.htm")
    public String selectSourceDetails(Integer goods_id,Integer user_id){
        try {
            HashMap<String,Object> hashMap = new HashMap<>();
            Integer id = null;
            hashMap.put("id",id);
            hashMap.put("user_id",user_id);
            hashMap.put("goods_id",goods_id);
        } catch (Exception e) {
            logger.error("错误提示："+e.getLocalizedMessage(),e);
            e.printStackTrace();
        }
        return "";
    }
    //货源列表查询
    @ResponseBody
    @RequestMapping("/selectGoods.htm")
    public String selectGoods(){
        try {

        } catch (Exception e) {
            logger.error("错误提示："+e.getLocalizedMessage(),e);
            e.printStackTrace();
        }
        return "";
    }
    //发布货源
    @ResponseBody
    @RequestMapping("/releaseSource.htm")
    public String releaseSource(String goods_start,String goods_end,String goods_contacts,
                                String goods_contactinformation,String goods_type,String goods_Detailedtype,
                                String goods_name,Double goods_number,Double goods_length,String goods_vetype,
                                String goods_vehicletype, String goods_loadingtime,String goods_detailed){
        try {
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("goods_start",goods_start);
            hashMap.put("goods_end",goods_end);
            hashMap.put("goods_contacts",goods_contacts);
            hashMap.put("goods_contactinformation",goods_contactinformation);
            hashMap.put("goods_type",goods_type);
            hashMap.put("goods_Detailedtype",goods_Detailedtype);
            hashMap.put("goods_name",goods_name);
            hashMap.put("goods_number",goods_number);
            hashMap.put("goods_length",goods_length);
            hashMap.put("goods_vetype",goods_vetype);
            hashMap.put("goods_vehicletype",goods_vehicletype);
            hashMap.put("goods_loadingtime",goods_loadingtime);
            hashMap.put("goods_detailed",goods_detailed);
        } catch (Exception e) {
            logger.error("错误提示："+e.getLocalizedMessage(),e);
            e.printStackTrace();
        }
        return "";
    }
    //根据条件查询货源列表
    @ResponseBody
    @RequestMapping("/selectGoodsCondition.htm")
    public String selectGoodsCondition(String goods_start,String goods_end,Integer sort,String goods_vehicletype,
                                       String goods_loadingtime,Double goods_numbermin,Double goods_numbermax,
                                       Double goods_length,String goods_vetype,String goods_type){
        try {
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("goods_start",goods_start);
            hashMap.put("goods_end",goods_end);
            hashMap.put("sort",sort);
            hashMap.put("goods_vehicletype",goods_vehicletype);
            hashMap.put("goods_loadingtime",goods_loadingtime);
            hashMap.put("goods_numbermin",goods_numbermin);
            hashMap.put("goods_numbermax",goods_numbermax);
            hashMap.put("goods_length",goods_length);
            hashMap.put("goods_vetype",goods_vetype);
            hashMap.put("goods_type",goods_type);
        } catch (Exception e) {
            logger.error("错误提示："+e.getLocalizedMessage(),e);
            e.printStackTrace();
        }
        return "";
    }
}
