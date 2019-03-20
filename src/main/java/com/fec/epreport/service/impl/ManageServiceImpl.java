package com.fec.epreport.service.impl;


import com.fec.epreport.dao.ManageDao;
import com.fec.epreport.entity.User;
import com.fec.epreport.entity.Users;
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
    //查询车源货源所有数据的时间的年份
    @Override
    public List<Map<String,Object>> selectGoodsVehiceTime() {
        List<Map<String,Object>> map = null;
        try {
            map=manageDao.selectGoodsVehiceTime();
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return map;
    }

    //车源信息 查询一年中的各月份的订单量
    @Override
    public Map<String, Object> selectVehiceOrderNumber(String dates) {
        Map map = null;
        try {
            map=manageDao.selectVehiceOrderNumber(dates);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return map;
    }
    //查询用户数量
    @Override
    public Map<String, Object> selectUserNumber() {
        Map map = null;
        try {
            map=manageDao.selectUserNumber();
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return map;
    }
    //查询车源数量
    @Override
    public Map<String, Object> selectVehiceNumber() {
        Map map = null;
        try {
            map=manageDao.selectVehiceNumber();
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return map;
    }
    //查询货源源数量
    @Override
    public Map<String, Object> selectDoodsNumber() {
        Map map = null;
        try {
            map=manageDao.selectDoodsNumber();
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return map;
    }
    //查询车源完成数量
    @Override
    public Map<String, Object> selectVehiceStateNumber() {
        Map map = null;
        try {
            map=manageDao.selectVehiceStateNumber();
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return map;
    }
    //查询货源完成源数量
    @Override
    public Map<String, Object> selectDoodsStateNumber() {
        Map map = null;
        try {
            map=manageDao.selectDoodsStateNumber();
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return map;
    }
    //查询所有的用户信息
    @Override
    public List<Users> selectAllusers() {
        List<Users> list = null;
        try {
            list=manageDao.selectAllusers();
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return list;
    }
}