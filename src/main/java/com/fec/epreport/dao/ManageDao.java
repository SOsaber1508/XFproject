package com.fec.epreport.dao;

import com.fec.epreport.entity.User;

import java.util.List;
import java.util.Map;

public interface ManageDao {
    //根据用户名查询用户信息
    public User selectByName(String user_name);
    //添加加用户
    public int insertAUser(User user);
    //修改密码
    public int updatePassword(User user);
    //货源信息
    // 查询一年中的各月份的订单量
    public Map<String,Object> selectGoodsOrderNumber(String dates);
    //查询所有数据的时间的年份
    public List<Map<String,Object>> selectGoodsTime();
}