package com.fec.epreport.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.fec.epreport.entity.Share;
import com.fec.epreport.pojo.CarInformation;
import com.fec.epreport.pojo.GoodsJson;
import com.fec.epreport.pojo.GoodsList;
import com.fec.epreport.pojo.ShareShiro;
import com.fec.epreport.pojo.VehicleJson;
import com.fec.epreport.pojo.WxUser;

public interface InterFaceService {
	// 用户
	// 个人中心资料查询
	public Map<String, Object> selectAUserziliao(String user_id);

	// 评价列表查询
	public List<Map<String, Object>> selectEvaluates(String user_id);

	// 好评数（货源车源）
	public Map<String, Object> selectPraise(String user_id);

	// 中评数（货源车源）
	public Map<String, Object> selectIn(String user_id);

	// 差评数（货源车源）
	public Map<String, Object> selectDifferenc(String user_id);

	// 提交评价
	public Integer submissionEvaluates(JSONObject jsonObject);

	// 点击评价
	public Map<String, Object> clickEvaluates(String user_id);

	// 查询是否收藏此用户（货源车源）
	public Map<String, Object> selectCollection(HashMap<String, Object> hashMap);

	// 历史发布查询
	public List<Map<String, Object>> selectRelease(String user_id);

	// 查询我的收藏信息
	public List<Map<String, Object>> selectMyCollection(String user_id);

	// 用户简介查询
	public List<Map<String, Object>> selectAUsersRelease(String user_id);

	// 用户简介查询(发布信息数量)
	public Map<String, Object> selectAUsersReleaseNumber(String user_id);

	// 用户简介中查询个人信息
	public Map<String, Object> selectAUsers(String user_id);

	// 重新发布接口(修改时间)
	public Integer chongxinfabuxiugai(JSONObject jsonObject);

	// 重新发布接口(查询时间)
	public Map<String, Object> chongxinfabuchaxun(JSONObject jsonObject);

	// 修改发布接口（查询该发布信息）
	public Map<String, Object> xiugaifabu(JSONObject jsonObject);

	// 修改发布接口（提交该发布信息）
	public Integer xiugaifabutijiao(JSONObject jsonObject);

	// 关于我们
	public Map<String, Object> guanyuwomen();

	// 添加浏览记录(货)
	public Integer tianjialiulanjiluhuo(JSONObject jsonObject);

	// 修改浏览记录时间(货车)
	public Integer xiugailiulanjiluhuoche(Map<String, Object> map);

	// 添加浏览记录(车)
	public Integer tianjialiulanjiluche(JSONObject jsonObject);

	// 查询我的浏览纪录
	public Map<String, Object> selectliulanjilu(Map<String, Object> map);

	// 查询浏览记录表的内容
	public List<Map<String, Object>> selectliulanjilubiao(String user_id);

	// 查询是否收藏此用户
	public Map<String, Object> selectMyCollectionUser(JSONObject jsonObject);

	// 点击收藏取消用户
	public Integer dianjishoucanguser(JSONObject jsonObject);

	/**
	 * 货源
	 */
	// 货源详情查询
	public Map<String, Object> selectSourceDetails(String goods_id);

	// 货源列表查询
	public List<GoodsList> selectGoods();

	// 条件筛选货源列表
	public List<GoodsList> selectGoodsShaiXuan(JSONObject wxObject, List<Map<String, Object>> maps, List<String> list1,
			List<String> list2);

	// 发布货源
	public Integer releaseSource(GoodsJson car);

	/**
	 * 车源
	 */
	// 车源详情查询
	public Map<String, Object> selectVehicleDetails(String vehicle_id);

	// 车源列表查询
	public List<Map<String, Object>> selectVehicles();

	// 车源列表查询(筛选)
	public List<Map<String, Object>> selectVehiclesShaiXuan(JSONObject jsonObject, List<Map<String, Object>> maps,
			List<String> list1);

	// 发布车源
	public Integer releaseCar(VehicleJson car);

	/**
	 * 车辆相关
	 * 
	 * @return
	 */
	// 查询是否完善过车辆信息
	public String selectPerfectVehicle(String wx_id);

	// 完善车辆信息
	public int perfectVehicle(CarInformation car);

	/**
	 * 
	 * @param 微信相关
	 */
	// 保存微信授权
	public void insertWxUser(WxUser user);

	// 查询是否授权过
	public int selectShouQuan(String user_id);

	// 查询个人信息
	public Map<String, Object> selectAUsersss(String user_id);

	// 查询此用户是否进行过身份认证
	public String selectidentityAuthentication(String user_authentication);

	// 身份认证
	public int identityAuthentication(String wx_id, String wx_idcard, String phone, String wx_name, String wx_nickname,
			String wx_headimgurl);

	// 总的:查询是否完善车辆信息+查询是否身份认证
	public Map<String, Object> selectShiro(String string);

	// 个人分享信息(残)
	public String shareInformation(String string);

	// 分享接口回调
	public int shareShiro(String wx_id, String share_shiro);

	// 查询分享权限(全)
	public ShareShiro selectshareShiro(String wx_id);

	// 分享次数增加
	public int CountshareShiro(String string);

	// 查询后台分享的话术
	public Share sharePC();

}
