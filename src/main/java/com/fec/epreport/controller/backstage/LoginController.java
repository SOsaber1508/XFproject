package com.fec.epreport.controller.backstage;

import com.alibaba.fastjson.JSON;
import com.fec.epreport.entity.User;
import com.fec.epreport.service.ManageService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    /*private static HttpClientPoolHelper hcph = HttpClientPoolHelper.getInstance();*/
    @Autowired
    ManageService manageService;
    //管理登陆
    //根据用户名查询用户信息
    //不返回路径返回值
    //@ResponseBody
    @RequestMapping("/adminLand.htm")
    public void adminLand(String user_name, String user_password, HttpSession hs, HttpServletResponse resp) throws Exception {
        /*try {
            String result = null;
            result = hcph.postRequest("http://www.baidu.com", "adsdshdisgdys");
            System.err.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        try {
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
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
    }
    //页面退出登录
    @ResponseBody
    @RequestMapping(value = "/logout.htm")
    public void logout(HttpSession session,HttpServletResponse resp) throws IOException {
        //清除session
        try {
            session.invalidate();
            String json = JSON.toJSONString("true");
            resp.getWriter().write(json);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
    }
    //管理员注册
    @RequestMapping("/register.htm")
    public void register(String user_name, String user_password, HttpSession hs, HttpServletResponse resp) throws Exception {
        try {
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
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
    }
    //管理员修改密码
    @RequestMapping("/updatePassword.htm")
    public void updatePassword(String user_password, String user_upassword, HttpSession hs, HttpServletResponse resp) throws Exception {
        try {
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
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
    }
    //货源信息
    // 查询一年中的各月份的订单量
    @RequestMapping("/selectGoodsOrderNumber.htm")
    public void selectGoodsOrderNumber(String year,HttpServletResponse resp) throws Exception {
        //请求解决乱码
        resp.setContentType("text/html;charset=utf-8");
        try {
            List<String> list = new ArrayList<>();
            list.add(year+"-01-%");
            list.add(year+"-02-%");
            list.add(year+"-03-%");
            list.add(year+"-04-%");
            list.add(year+"-05-%");
            list.add(year+"-06-%");
            list.add(year+"-07-%");
            list.add(year+"-08-%");
            list.add(year+"-09-%");
            list.add(year+"-10-%");
            list.add(year+"-11-%");
            list.add(year+"-12-%");
            Map<String,Object> map = new HashMap<>();
            int i=1;
            for (String list1:list) {
                Map<String,Object> map1 = manageService.selectGoodsOrderNumber(list1);
                Map<String,Object> map2 = manageService.selectVehiceOrderNumber(list1);
                map.put("Goods"+i,map1.get("order_quantity"));
                map.put("Vehicle"+i,map2.get("order_vehicle"));
                i++;
            }
            String json = JSON.toJSONString(map);
            resp.getWriter().write(json);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
    }
    // 查询一年中的各月份的订单量
    @RequestMapping("/selectUserYearNumber.htm")
    public void selectUserYearNumber(String year,HttpServletResponse resp) throws Exception {
        //请求解决乱码
        resp.setContentType("text/html;charset=utf-8");
        try {
            List<String> list = new ArrayList<>();
            list.add(year+"-01-%");
            list.add(year+"-02-%");
            list.add(year+"-03-%");
            list.add(year+"-04-%");
            list.add(year+"-05-%");
            list.add(year+"-06-%");
            list.add(year+"-07-%");
            list.add(year+"-08-%");
            list.add(year+"-09-%");
            list.add(year+"-10-%");
            list.add(year+"-11-%");
            list.add(year+"-12-%");
            Map<String,Object> map = new HashMap<>();
            int i=1;
            for (String list1:list) {
                Map<String,Object> map1 = manageService.selectAUserNumber(list1);
                Map<String,Object> map2 = manageService.selectAUserRenZhengNumber(list1);
                map.put("ShouQuanUser"+i,map1.get("user_number"));
                map.put("RenZhengUser"+i,map2.get("user_number"));
                i++;
            }
            String json = JSON.toJSONString(map);
            resp.getWriter().write(json);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
    }
    // 查询一年中的各月份的订单量
    @RequestMapping("/selectUserBiLi.htm")
    public void selectUserBiLi(HttpServletResponse resp) throws Exception {
        //请求解决乱码
        resp.setContentType("text/html;charset=utf-8");
        try {
            String startTime="";
            String endTime="";
            Map<String,Object> map = new HashMap<String, Object>();
            // 用户授权数
            Map<String, Object> map1 = manageService.selectUserNumber(startTime, endTime);
            String shouQuan = map1.get("user_number").toString();
            int shouQuans = Integer.parseInt(shouQuan);
            // 认证
            Map<String, Object> map2 = manageService.selectRenZhengUserNumber(startTime, endTime);
            String renZheng = map2.get("user_renzheng").toString();
            int renZhengs = Integer.parseInt(renZheng);
            int weiRenZheng = shouQuans-renZhengs;
            String weiRenZhengs = weiRenZheng+"";
            map.put("weiRenZheng",weiRenZhengs);
            map.put("yiRenZheng",renZheng);

            String json = JSON.toJSONString(map);
            resp.getWriter().write(json);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
    }


    // 查询从项目到现在的用户货源车源数量信息
    @RequestMapping("/selectAllUserGoodsNumber.htm")
    public void selectAllUserGoodsNumber(HttpServletResponse resp) throws Exception {
        //请求解决乱码
        resp.setContentType("text/html;charset=utf-8");
        try {
            Map<String, Object> map = new HashMap<>();
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dBegin = sdf.parse("2019-04-23");
            Date dEnd = sdf.parse(sdf.format(date));
            List<String> datas = findDates(dBegin, dEnd);

            List<String> VehicleNumber = new ArrayList<>();
            List<String> GoodsNumber = new ArrayList<>();
            List<String> UserRenZhengNumber = new ArrayList<>();
            List<String> UserNumber = new ArrayList<>();
            for (String riqi:datas) {
                VehicleNumber.add(manageService.selectVehiceOrderNumber(riqi).get("order_vehicle").toString());
                GoodsNumber.add(manageService.selectGoodsOrderNumber(riqi).get("order_quantity").toString());
                UserRenZhengNumber.add(manageService.selectAUserRenZhengNumber(riqi).get("user_number").toString());
                UserNumber.add(manageService.selectAUserNumber(riqi).get("user_number").toString());
            }
            map.put("datas",datas);
            map.put("VehicleNumber",VehicleNumber);
            map.put("GoodsNumber",GoodsNumber);
            map.put("UserRenZhengNumber",UserRenZhengNumber);
            map.put("UserNumber",UserNumber);

            String json = JSON.toJSONString(map);
            resp.getWriter().write(json);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
    }
    //列出一段范围内的时间组成list集合
    private static List<String> findDates(Date dBegin, Date dEnd) {
        List<String> lDate = new ArrayList<String>();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        lDate.add(sd.format(dBegin));
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime()))
        {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(sd.format(calBegin.getTime()));
        }
        return lDate;
    }
}
