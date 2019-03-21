package com.fec.epreport.service;


import com.fec.epreport.pojo.WxUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface InterFaceService {
    //评价列表查询
    public List<Map<String,Object>> selectEvaluates(Integer user_id);
    //好评数（货源车源）
    public Map<String,Object> selectPraise(Integer user_id);
    //中评数（货源车源）
    public Map<String,Object> selectIn(Integer user_id);
    //差评数（货源车源）
    public Map<String,Object> selectDifferenc(Integer user_id);
    //提交评价
    public Integer submissionEvaluates(HashMap<String,Object> hashMap);
    //点击评价
    public Map<String,Object> clickEvaluates(Integer user_id);
    //货源详情查询
    public Map<String,Object> selectSourceDetails(HashMap<String,Object> hashMap);
    //查询是否收藏此用户（货源车源）
    public Map<String,Object> selectCollection(HashMap<String,Object> hashMap);
    //货源列表查询
    public List<Map<String,Object>> selectGoods();
    //发布货源
    public Integer releaseSource(HashMap<String,Object> hashMap);
    //根据条件查询货源列表
    public List<Map<String,Object>> selectGoodsCondition(HashMap<String,Object> hashMap);
    //历史发布查询
    public List<Map<String,Object>> selectRelease(String user_id);
    //完善车辆信息
    public Integer perfectVehicle(HashMap<String,Object> hashMap);
    //查询我的收藏信息
    public List<Map<String,Object>> selectMyCollection(String user_id);
    //个人分享信息
    public Map<String,Object> shareInformation(String user_id);
    //用户简介查询
    public List<Map<String,Object>> selectAUsersRelease(Integer user_id);
    //用户简介中查询个人信息
    public Map<String,Object> selectAUsers(Integer user_id);
    //身份认证
    public Integer identityAuthentication(HashMap<String, Object> hashMap);
    //查询此用户是否进行过身份认证
    public Map<String,Object> selectidentityAuthentication(HashMap<String,Object> hashMap);
    //车源详情查询
    public Map<String,Object> selectVehicleDetails(HashMap<String,Object> hashMap);
    //车源列表查询
    public List<Map<String,Object>> selectVehicles();
    //根据条件查询车源列表
    public List<Map<String,Object>> selectVehiclesCondition(HashMap<String,Object> hashMap);
    //发布车源
    public Integer releaseCar(HashMap<String,Object> hashMap);
    
    /**
     * 
     * @param 微信相关
     */
    //发布车源
	public void insertWxUser(WxUser user);
	//查询是否授权过
	public int selectShouQuan(String user_id);
	//查询个人信息
    public Map<String,Object> selectAUsersss(String user_id);
}
