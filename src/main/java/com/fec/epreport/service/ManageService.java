package com.fec.epreport.service;


import com.fec.epreport.entity.User;
import com.fec.epreport.entity.Users;

import java.util.List;
import java.util.Map;

public interface ManageService {
    //根据用户名查询用户信息
    public User selectByName(String user_name);
    //添加加用户
    public int insertAUser(User user);
    //修改密码
    public int updatePassword(User user);
    //货源信息
    // 查询一年中的各月份的订单量
    public Map selectGoodsOrderNumber(String date);
    //查询车源货源所有数据的时间的年份
    public List<Map<String,Object>> selectGoodsVehiceTime();
    //车源信息 查询一年中的各月份的订单量
    public Map<String,Object> selectVehiceOrderNumber(String dates);
    //查询用户数量
    public Map<String,Object> selectUserNumber(String startTime, String endTime);
    //查询车源数量
    public Map<String,Object> selectVehiceNumber(String startTime, String endTime);
    //查询货源源数量
    public Map<String,Object> selectDoodsNumber(String startTime, String endTime);
    //查询车源完成数量
    public Map<String,Object> selectVehiceStateNumber();
    //查询货源完成源数量
    public Map<String,Object> selectDoodsStateNumber();
    //查询所有的用户信息
    public List<Users> selectAllusers();
    //查询认证用户数量
    public Map<String, Object> selectRenZhengUserNumber(String startTime, String endTime);
    //查询用户创建时间（年）
    public List<Map<String,Object>> selectUserYear();
    //查询一个月中用户授权数量
    public Map<String,Object> selectAUserNumber(String dates);
    //查询一个月中用户认证数量
    public Map<String,Object> selectAUserRenZhengNumber(String dates);
}
