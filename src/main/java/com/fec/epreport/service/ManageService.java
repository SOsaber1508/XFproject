package com.fec.epreport.service;


import com.fec.epreport.entity.User;

public interface ManageService {
    //根据用户名查询用户信息
    public User selectByName(String user_name);

}
