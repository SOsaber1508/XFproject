package com.fec.epreport.dao;

import com.fec.epreport.entity.User;
import com.fec.epreport.entity.Users;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ManageDao {
    //根据管理员用户名查询管理员用户信息
    public User selectByName(String user_name);
    //添加管理员用户
    public int insertAUser(User user);
    //修改管理员用户密码
    public int updatePassword(User user);
    //货源信息 查询一年中的各月份的订单量
    public Map<String,Object> selectGoodsOrderNumber(String dates);
    //查询车源货源所有数据的时间的年份
    public List<Map<String,Object>> selectGoodsVehiceTime();
    //车源信息 查询一年中的各月份的订单量
    public Map<String,Object> selectVehiceOrderNumber(String dates);
    //查询用户数量
    public Map<String,Object> selectUserNumber(@Param("startTime") String startTime, @Param("endTime") String endTime);
    //查询车源数量
    public Map<String,Object> selectVehiceNumber(@Param("startTime") String startTime, @Param("endTime") String endTime);
    //查询货源源数量
    public Map<String,Object> selectDoodsNumber(@Param("startTime") String startTime, @Param("endTime") String endTime);
    //查询车源完成数量
    public Map<String,Object> selectVehiceStateNumber();
    //查询货源完成源数量
    public Map<String,Object> selectDoodsStateNumber();
    //查询所有的用户信息
    public List<Users> selectAllusers();
    //查询认证用户数量
    public Map<String, Object> selectRenZhengUserNumber(@Param("startTime") String startTime, @Param("endTime") String endTime);
}