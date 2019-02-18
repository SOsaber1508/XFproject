package com.fec.epreport.dao;

import com.fec.epreport.entity.User;

public interface ManageDao {
    //根据用户名查询用户信息
    public User selectByName(String user_name);

}