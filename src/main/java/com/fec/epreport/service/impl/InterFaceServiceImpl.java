package com.fec.epreport.service.impl;


import com.fec.epreport.dao.InterFaceDao;
import com.fec.epreport.service.InterFaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("interFaceService")
public class InterFaceServiceImpl implements InterFaceService {
    private static Logger logger = LoggerFactory.getLogger(InterFaceServiceImpl.class);
    @Autowired
    InterFaceDao interFaceDao;

    //评价列表查询
    @Override
    public List<Map<String, Object>> selectEvaluates(Integer user_id) {
        List<Map<String, Object>> maps = null;
        try {
            maps=interFaceDao.selectEvaluates(user_id);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return maps;
    }
    //好评数（货源车源）
    @Override
    public Map<String, Object> selectPraise(Integer user_id) {
        Map<String, Object> map = null;
        try {
            map=interFaceDao.selectPraise(user_id);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return map;
    }
    //中评数（货源车源）
    @Override
    public Map<String, Object> selectIn(Integer user_id) {
        Map<String, Object> map = null;
        try {
            map=interFaceDao.selectIn(user_id);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return map;
    }
    //差评数（货源车源）
    @Override
    public Map<String, Object> selectDifferenc(Integer user_id) {
        Map<String, Object> map = null;
        try {
            map=interFaceDao.selectDifferenc(user_id);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return map;
    }
    //提交评价
    @Override
    public Integer submissionEvaluates(HashMap<String, Object> hashMap) {
        Integer integer = null;
        try {
            integer=interFaceDao.submissionEvaluates(hashMap);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return integer;
    }
    //点击评价
    @Override
    public Map<String, Object> clickEvaluates(Integer user_id) {
        Map<String, Object> map = null;
        try {
            map=interFaceDao.clickEvaluates(user_id);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return map;
    }
    //货源详情查询
    @Override
    public Map<String, Object> selectSourceDetails(HashMap<String, Object> hashMap) {
        Map<String, Object> map = null;
        try {
            map=interFaceDao.selectSourceDetails(hashMap);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return map;
    }
    //查询是否收藏此用户（货源车源）
    @Override
    public Map<String, Object> selectCollection(HashMap<String, Object> hashMap) {
        Map<String, Object> map = null;
        try {
            map=interFaceDao.selectCollection(hashMap);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return map;
    }
    //货源列表查询
    @Override
    public List<Map<String, Object>> selectGoods() {
        List<Map<String, Object>> maps = null;
        try {
            maps=interFaceDao.selectGoods();
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return maps;
    }
    //发布货源
    @Override
    public Integer releaseSource(HashMap<String, Object> hashMap) {
        Integer integer = null;
        try {
            integer=interFaceDao.releaseSource(hashMap);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return integer;
    }
    //根据条件查询货源列表
    @Override
    public List<Map<String, Object>> selectGoodsCondition(HashMap<String, Object> hashMap) {
        List<Map<String, Object>> maps = null;
        try {
            maps=interFaceDao.selectGoodsCondition(hashMap);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return maps;
    }
    //查询个人信息
    @Override
    public Map<String, Object> selectAUsersss(Integer user_id) {
        Map<String, Object> map = null;
        try {
            map=interFaceDao.selectAUsersss(user_id);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return map;
    }
    //历史发布查询
    @Override
    public List<Map<String, Object>> selectRelease(Integer user_id) {
        List<Map<String, Object>> maps = null;
        try {
            maps=interFaceDao.selectRelease(user_id);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return maps;
    }
    //完善车辆信息
    @Override
    public Integer perfectVehicle(HashMap<String, Object> hashMap) {
        Integer integer = null;
        try {
            integer=interFaceDao.perfectVehicle(hashMap);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return integer;
    }
    //查询我的收藏信息
    @Override
    public List<Map<String, Object>> selectMyCollection(Integer user_id) {
        List<Map<String, Object>> maps = null;
        try {
            maps=interFaceDao.selectMyCollection(user_id);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return maps;
    }
    //个人分享信息
    @Override
    public Map<String, Object> shareInformation(Integer user_id) {
        Map<String, Object> map = null;
        try {
            map=interFaceDao.shareInformation(user_id);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return map;
    }
    //用户简介查询
    @Override
    public List<Map<String, Object>> selectAUsersRelease(Integer user_id) {
        List<Map<String, Object>> maps = null;
        try {
            maps=interFaceDao.selectAUsersRelease(user_id);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return maps;
    }
    //用户简介中查询个人信息
    @Override
    public Map<String, Object> selectAUsers(Integer user_id) {
        Map<String, Object> map = null;
        try {
            map=interFaceDao.selectAUsers(user_id);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return map;
    }
    //查询此用户是否进行过身份认证
    @Override
    public Map<String, Object> identityAuthentication(HashMap<String, Object> hashMap) {
        Map<String, Object> map = null;
        try {
            map=interFaceDao.identityAuthentication(hashMap);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return map;
    }
    //车源详情查询
    @Override
    public Map<String, Object> selectVehicleDetails(HashMap<String, Object> hashMap) {
        Map<String, Object> map = null;
        try {
            map=interFaceDao.selectVehicleDetails(hashMap);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return map;
    }
    //车源列表查询
    @Override
    public List<Map<String, Object>> selectVehicles() {
        List<Map<String, Object>> maps = null;
        try {
            maps=interFaceDao.selectVehicles();
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return maps;
    }
    //根据条件查询车源列表
    @Override
    public List<Map<String, Object>> selectVehiclesCondition(HashMap<String, Object> hashMap) {
        List<Map<String, Object>> maps = null;
        try {
            maps=interFaceDao.selectVehiclesCondition(hashMap);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return maps;
    }
    //发布车源
    @Override
    public Integer releaseCar(HashMap<String, Object> hashMap) {
        Integer integer = null;
        try {
            integer=interFaceDao.releaseCar(hashMap);
        } catch (DataAccessException d) {
            logger.info("查询数据库错误："+d.getLocalizedMessage());
        }
        return integer;
    }

}