package com.fec.epreport.service.impl;





import com.fec.epreport.dao.ManageDao;
import com.fec.epreport.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fec.epreport.service.ManageService;


@Service("manageService")  
public class ManageServiceImpl implements ManageService {
    @Autowired
    ManageDao manageDao;
    //根据用户名查询用户信息
    @Override
    public User selectByName(String user_name) {
        User user =null;
        try {
            user= manageDao.selectByName(user_name);
        }catch (Exception e){
            e.getLocalizedMessage();
        }
        return user;
    }

    @Override
    public int insertAUser(User user) {
        return manageDao.insertAUser(user);
    }

    @Override
    public int updatePassword(User user) {
        return manageDao.updatePassword(user);
    }

}