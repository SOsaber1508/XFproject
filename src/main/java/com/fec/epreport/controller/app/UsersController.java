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
@RequestMapping(value = "/users")
public class UsersController {
    private static Logger logger = LoggerFactory.getLogger(UsersController.class);
    @Autowired
    ManageService manageService;
    //查询个人信息
    @ResponseBody
    @RequestMapping("/selectAUsers.htm")
    public String selectAUsers(){
        try {
        } catch (Exception e) {
            logger.error("错误提示："+e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
        return "";
    }
    //历史发布查询
    @ResponseBody
    @RequestMapping("/selectRelease.htm")
    public String selectRelease(){
        try {

        } catch (Exception e) {
            logger.error("错误提示："+e.getLocalizedMessage(),e);
            e.printStackTrace();
        }
        return "";
    }
    //完善车辆信息
    @ResponseBody
    @RequestMapping("/perfectVehicle.htm")
    public String perfectVehicle(Double user_conductor,String user_vehicletype,Double user_load){
        try {
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("user_conductor",user_conductor);
            hashMap.put("user_vehicletype",user_vehicletype);
            hashMap.put("user_load",user_load);
        } catch (Exception e) {
            logger.error("错误提示："+e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
        return "";
    }
    //查询我的收藏信息
    @ResponseBody
    @RequestMapping("/selectMyCollection.htm")
    public String selectMyCollection(){
        try {

        } catch (Exception e) {
            logger.error("错误提示："+e.getLocalizedMessage(),e);
            e.printStackTrace();
        }
        return "";
    }
    //分享信息
    @ResponseBody
    @RequestMapping("/shareInformation.htm")
    public String shareInformation(){
        try {

        } catch (Exception e) {
            logger.error("错误提示："+e.getLocalizedMessage(),e);
            e.printStackTrace();
        }
        return "";
    }
    //用户简介查询
    @ResponseBody
    @RequestMapping("/selectAUsersRelease.htm")
    public String selectAUsersRelease(Integer user_id){
        try {

        } catch (Exception e) {
            logger.error("错误提示："+e.getLocalizedMessage(),e);
            e.printStackTrace();
        }
        return "";
    }
    //身份认证
    @ResponseBody
    @RequestMapping("/identityAuthentication.htm")
    public String identityAuthentication(String user_realname,String user_idnumber,String user_phonenumber){
        try {
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("user_realname",user_realname);
            hashMap.put("user_idnumber",user_idnumber);
            hashMap.put("user_phonenumber",user_phonenumber);
        } catch (Exception e) {
            logger.error("错误提示："+e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
        return "";
    }
}
