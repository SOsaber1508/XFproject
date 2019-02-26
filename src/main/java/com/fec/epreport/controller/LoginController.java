package com.fec.epreport.controller;

import com.alibaba.fastjson.JSON;
import com.fec.epreport.entity.User;
import com.fec.epreport.service.ManageService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    ManageService manageService;
    //管理登陆
    //根据用户名查询用户信息
    //不返回路径返回值
    //@ResponseBody
    @RequestMapping("/adminLand.htm")
    public void adminLand(String user_name, String user_password, HttpSession hs, HttpServletResponse resp) throws Exception {
       // System.out.println("1");

        User user = manageService.selectByName(user_name);
        String str = (String) hs.getAttribute("md5RandomKey");
        String string="1";
        if(user!=null){
            String md5str = DigestUtils.md5Hex(str);
            String md5strpwd = md5str+user.getUser_password();
            if(md5strpwd.equals(user_password)){
                hs.setAttribute("username",user_name);
                string="2";
            }
        }
        String json = JSON.toJSONString(string);
        resp.getWriter().write(json);
    }
    //页面退出登录
    @ResponseBody
    @RequestMapping(value = "/logout.htm")
    public void logout(HttpSession session,HttpServletResponse resp) throws IOException {
        //清除session
        session.invalidate();
        String json = JSON.toJSONString("true");
        resp.getWriter().write(json);
    }
    //管理员注册
    @RequestMapping("/register.htm")
    public void register(String user_name, String user_password, HttpSession hs, HttpServletResponse resp) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String user_creationtime = df.format(new Date());// new Date()为获取当前系统时间
        User user = manageService.selectByName(user_name);
        String str="1";
        if(user==null){
            User user1 = new User(null,user_name,user_password,null,null,null,null,user_creationtime,null);
            int num = manageService.insertAUser(user1);
            if(num==1){
                str="2";
            }
        }
        System.out.println(str);
        String json = JSON.toJSONString(str);
        resp.getWriter().write(json);
    }
    //管理员修改密码
    @RequestMapping("/updatePassword.htm")
    public void updatePassword(String user_password, String user_upassword, HttpSession hs, HttpServletResponse resp) throws Exception {
        String user_name = (String) hs.getAttribute("username");
        User user = manageService.selectByName(user_name);
        String str="1";
        if(user.getUser_password().equals(user_password)){
            User user1 = new User(null,user_name,user_upassword,null,null,null,null,null,null);
            int num = manageService.updatePassword(user1);
            if(num==1){
                str="2";
            }
        }
        String json = JSON.toJSONString(str);
        resp.getWriter().write(json);
    }
}
