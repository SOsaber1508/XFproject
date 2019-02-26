package com.fec.epreport.dao;

import com.fec.epreport.entity.User;

public interface ManageDao {
    //根据用户名查询用户信息
    public User selectByName(String user_name);
    //添加加用户
    public int insertAUser(User user);
    //修改密码
    public int updatePassword(User user);
}