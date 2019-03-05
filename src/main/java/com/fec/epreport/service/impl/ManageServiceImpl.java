package com.fec.epreport.service.impl;


import com.fec.epreport.dao.ManageDao;
import com.fec.epreport.entity.User;
import com.fec.epreport.service.ManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("manageService")  
public class ManageServiceImpl implements ManageService {
    private static Logger logger = LoggerFactory.getLogger(ManageServiceImpl.class);

    @Autowired
    ManageDao manageDao;
    //根据用户名查询用户信息
    @Override
    public User selectByName(String user_name) {
        User user =null;
        try {
            user= manageDao.selectByName(user_name);
        }catch (Exception e){
            logger.info("查询错误："+e.getLocalizedMessage());
        }
        return user;
    }

    @Override
    public int insertAUser(User user) {
        int i=0;
        try {
            i=manageDao.insertAUser(user);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return i;
    }

    @Override
    public int updatePassword(User user) {
        int i=0;
        try {
            i=manageDao.updatePassword(user);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return i;
    }
    //货源信息
    // 查询一年中的各月份的订单量
    @Override
    public Map selectGoodsOrderNumber(String date) {
        Map map = null;
        try {
            map=manageDao.selectGoodsOrderNumber(date);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return map;

    }
    //查询所有数据的时间的年份
    @Override
    public List<Map<String,Object>> selectGoodsTime() {
        List<Map<String,Object>> map = null;
        try {
            map=manageDao.selectGoodsTime();
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return map;
    }

}