package com.fec.epreport.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.alibaba.fastjson.JSONObject;
import com.fec.epreport.entity.Share;
import com.fec.epreport.pojo.CarInformation;
import com.fec.epreport.pojo.GoodsJson;
import com.fec.epreport.pojo.GoodsList;
import com.fec.epreport.pojo.ShareShiro;
import com.fec.epreport.pojo.VehicleJson;
import com.fec.epreport.pojo.WxUser;

public interface InterFaceDao {
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

	/**
	 * 浏览记录
	 */
	public Integer tianjialiulanjiluhuo(JSONObject jsonObject);

	// 修改浏览记录时间(货车)
	public Integer xiugailiulanjiluhuoche(Map<String, Object> map);

	// 添加浏览记录(车)
	public Integer tianjialiulanjiluche(JSONObject jsonObject);

	// 查询我的浏览纪录
	public Map<String, Object> selectliulanjilu(Map<String, Object> map);

	// 查询浏览记录表的内容
	public List<Map<String, Object>> selectliulanjilubiao(String user_id);

	/**
	 * 收藏
	 */
	// 查询是否收藏此用户（货源车源）
	public Map<String, Object> selectCollection(HashMap<String, Object> hashMap);

	// 查询是否收藏此用户
	public Map<String, Object> selectMyCollectionUser(JSONObject jsonObject);

	//查询我的收藏信息
    public List<Map<String,Object>> selectMyCollection(String user_id);

	// 点击收藏取消用户
	public Integer dianjishoucanguser(JSONObject jsonObject);

	/**
	 * 发布信息
	 */
	// 历史发布查询
	public List<Map<String, Object>> selectRelease(String user_id);

	// 用户简介查询(发布信息)
	public List<Map<String, Object>> selectAUsersRelease(String user_id);

	// 用户简介查询(发布信息数量)
	public Map<String, Object> selectAUsersReleaseNumber(String user_id);

	// 重新发布接口(修改时间)
	public Integer chongxinfabuxiugai(JSONObject jsonObject);

	// 重新发布接口(查询时间)
	public Map<String, Object> chongxinfabuchaxun(JSONObject jsonObject);

	// 修改发布接口（查询该发布信息）
	public Map<String, Object> xiugaifabu(JSONObject jsonObject);

	// 修改发布接口（提交该发布信息）
	public Integer xiugaifabutijiao(JSONObject jsonObject);

	/**
	 * 车源
	 */
	// 车源
	// 车源详情查询
	public Map<String, Object> selectVehicleDetails(String vehicle_id);

	// 车源列表查询
	public List<Map<String, Object>> selectVehicles();

	// 车源列表查询(筛选)
	public List<Map<String, Object>> selectVehiclesShaiXuan(JSONObject jsonObject,
			@Param("maps") List<Map<String, Object>> maps, @Param("data") List<String> list1);

	// 发布车源
	public Integer releaseCar(VehicleJson car);

	/**
	 * 货源
	 */
	// 货源
	// 货源详情查询
	public Map<String, Object> selectSourceDetails(String goods_id);

	// 货源列表查询
	public List<GoodsList> selectGoods();

	// 发布货源
	public Integer releaseSource(GoodsJson car);

	// 条件筛选货源信息
	public List<GoodsList> selectGoodsShaiXuan(JSONObject wxObject, @Param("maps") List<Map<String, Object>> maps,
			@Param("date") List<String> date, @Param("date2") List<String> date2);

	/**
	 * 车辆相关
	 * 
	 * @return
	 */
	// 查询是否完善过车辆信息:默认为1 是未完善,0是已完善
	public String selectPerfectVehicle(String wx_id);

	// 完善车辆信息
	public int perfectVehicle(CarInformation car);

	/**
	 * 微信相关： 保存微信用户授权信息
	 */
	// 添加授权用户
	public void insertWxUser(WxUser user);

	// 查询是否授权过
	public int selectShouQuan(String wx_id);

	// 查询个人信息
	public Map<String, Object> selectAUsersss(String user_id);

	// 用户简介中查询个人信息
	public Map<String, Object> selectAUsers(String user_id);

	// 个人中心资料查询
	public Map<String, Object> selectAUserziliao(String user_id);

	// 查询此用户是否进行过身份认证
	public String selectidentityAuthentication(String user_authentication);

	// 身份认证
	public int identityAuthentication(@Param("wx_id") String wx_id, @Param("wx_idcard") String wx_idcard,
			@Param("phone") String phone, @Param("wx_name") String wx_name, @Param("wx_nickname") String wx_nickname,
			@Param("wx_headimgurl") String wx_headimgurl);

	// 总的:查询是否完善车辆信息+查询是否身份认证
	public Map<String, Object> selectShiro(String user_id);

	// 个人分享信息(残)
	public String shareInformation(String user_id);

	// 分享回调
	public int shareShiro(@Param("wx_id") String wx_id, @Param("share_shiro") String share_shiro);

	// 个人分享信息(全)
	public ShareShiro selectshareShiro(String wx_id);

	// 分享次数增加
	public int CountshareShiro(String wx_id);

	// 分享pc话术
	public Share sharePC();
	//关于我们
    public Map<String, Object> guanyuwomen();
	//版本下载查询
	public Map<String, Object> selectBanBenXiaZai();

}