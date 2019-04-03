package com.fec.epreport.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fec.epreport.dao.InterFaceDao;
import com.fec.epreport.entity.Share;
import com.fec.epreport.pojo.CarInformation;
import com.fec.epreport.pojo.GoodsJson;
import com.fec.epreport.pojo.GoodsList;
import com.fec.epreport.pojo.ShareShiro;
import com.fec.epreport.pojo.VehicleJson;
import com.fec.epreport.pojo.WxUser;
import com.fec.epreport.service.InterFaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("interFaceService")
public class InterFaceServiceImpl implements InterFaceService {
	private static Logger logger = LoggerFactory.getLogger(InterFaceServiceImpl.class);
	@Autowired
	InterFaceDao interFaceDao;

	/**
	 * 评价
	 * 
	 * @return
	 */

	// 评价列表查询
	@Override
	public List<Map<String, Object>> selectEvaluates(String user_id) {
		List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
		try {
			maps = interFaceDao.selectEvaluates(user_id);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return maps;
	}

	// 好评数（货源车源）
	@Override
	public Map<String, Object> selectPraise(String user_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = interFaceDao.selectPraise(user_id);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return map;
	}

	// 中评数（货源车源）
	@Override
	public Map<String, Object> selectIn(String user_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = interFaceDao.selectIn(user_id);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return map;
	}

	// 差评数（货源车源）
	@Override
	public Map<String, Object> selectDifferenc(String user_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = interFaceDao.selectDifferenc(user_id);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return map;
	}

	// 提交评价
	@Override
	public Integer submissionEvaluates(JSONObject jsonObject) {
		Integer integer = 0;
		try {
			integer = interFaceDao.submissionEvaluates(jsonObject);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return integer;
	}

	// 点击评价
	@Override
	public Map<String, Object> clickEvaluates(String user_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = interFaceDao.clickEvaluates(user_id);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return map;
	}

	/**
	 * 货源
	 */
	// 货源
	// 货源详情查询
	@Override
	public Map<String, Object> selectSourceDetails(String goods_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = interFaceDao.selectSourceDetails(goods_id);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return map;
	}

	// 货源列表查询
	@Override
	public List<GoodsList> selectGoods() {
		List<GoodsList> maps = null;
		try {
			maps = interFaceDao.selectGoods();
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return maps;
	}

	// 发布货源
	@Override
	public Integer releaseSource(GoodsJson car) {
		Integer integer = 0;
		try {
			integer = interFaceDao.releaseSource(car);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return integer;
	}

	@Override
	public List<GoodsList> selectGoodsShaiXuan(JSONObject wxObject, List<Map<String, Object>> maps1, List<String> list1,
			List<String> list2) {
		List<GoodsList> maps = null;
		try {
			maps = interFaceDao.selectGoodsShaiXuan(wxObject, maps1, list1, list2);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return maps;
	}

	/**
	 * 车源
	 */
	// 车源详情查询
	@Override
	public Map<String, Object> selectVehicleDetails(String vehicle_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = interFaceDao.selectVehicleDetails(vehicle_id);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return map;
	}

	// 车源列表查询
	@Override
	public List<Map<String, Object>> selectVehicles() {
		List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
		try {
			maps = interFaceDao.selectVehicles();
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return maps;
	}

	// 车源列表查询(筛选)
	@Override
	public List<Map<String, Object>> selectVehiclesShaiXuan(JSONObject jsonObject, List<Map<String, Object>> maps1,
			List<String> list1) {
		List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
		try {
			System.out.println(maps1);
			maps = interFaceDao.selectVehiclesShaiXuan(jsonObject, maps1, list1);

		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return maps;
	}

	// 发布车源
	@Override
	public Integer releaseCar(VehicleJson car) {
		Integer integer = 0;
		try {
			integer = interFaceDao.releaseCar(car);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return integer;
	}

	// 查询我的收藏信息
	@Override
	public List<Map<String, Object>> selectMyCollection(String user_id) {
		List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
		try {
			maps = interFaceDao.selectMyCollection(user_id);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return maps;
	}

	// 个人分享信息
	@Override
	public String shareInformation(String user_id) {
		String user_share_shiro = null;
		try {
			user_share_shiro = interFaceDao.shareInformation(user_id);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return user_share_shiro;
	}

	// 身份认证
	@Override
	public int identityAuthentication(String wx_id, String wx_idcard, String phone, String wx_name, String wx_nickname,
			String wx_headimgurl) {
		int i = 0;
		try {
			i = interFaceDao.identityAuthentication(wx_id, wx_idcard, phone, wx_name, wx_nickname, wx_headimgurl);
		} catch (DataAccessException d) {
			logger.info("更改数据库错误：" + d.getLocalizedMessage());
		}
		return i;
	}

	/**
	 * 发布信息相关
	 */
	// 重新发布接口(修改时间)
	@Override
	public Integer chongxinfabuxiugai(JSONObject jsonObject) {
		Integer integer = 0;
		try {
			integer = interFaceDao.chongxinfabuxiugai(jsonObject);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return integer;
	}

	// 重新发布接口(查询时间)
	@Override
	public Map<String, Object> chongxinfabuchaxun(JSONObject jsonObject) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = interFaceDao.chongxinfabuchaxun(jsonObject);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return map;
	}

	// 修改发布接口（查询该发布信息）
	@Override
	public Map<String, Object> xiugaifabu(JSONObject jsonObject) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = interFaceDao.xiugaifabu(jsonObject);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误(xiugaifabu)：" + d.getLocalizedMessage());
		}
		return map;
	}

	// 修改发布接口（提交该发布信息）
	@Override
	public Integer xiugaifabutijiao(JSONObject jsonObject) {
		Integer integer = 0;
		try {
			integer = interFaceDao.xiugaifabutijiao(jsonObject);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return integer;
	}

	/**
	 * 车辆相关
	 * 
	 */
	// 查询是否收藏此用户（货源车源）
	@Override
	public Map<String, Object> selectCollection(HashMap<String, Object> hashMap) {
		Map<String, Object> map = null;
		try {
			map = interFaceDao.selectCollection(hashMap);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return map;
	}

	// 查询是否完善过车辆信息:默认为1 是未完善,0是已完善
	@Override
	public String selectPerfectVehicle(String wx_id) {
		String user_perfect = null;
		try {
			user_perfect = interFaceDao.selectPerfectVehicle(wx_id);
		} catch (DataAccessException d) {
			logger.info("查询是否完善过车辆数据库错误：" + d.getLocalizedMessage());
		}
		return user_perfect;
	}

	// 完善车辆信息
	@Override
	public int perfectVehicle(CarInformation car) {
		int i = 0;
		try {
			i = interFaceDao.perfectVehicle(car);
		} catch (DataAccessException d) {
			logger.info("完善车辆信息添加数据库错误：" + d.getLocalizedMessage());
		}
		return i;
	}

	// 历史发布查询
	@Override
	public List<Map<String, Object>> selectRelease(String user_id) {
		List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
		try {
			maps = interFaceDao.selectRelease(user_id);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return maps;
	}

	/**
	 * 浏览记录
	 */
	// 添加浏览记录(货)
	@Override
	public Integer tianjialiulanjiluhuo(JSONObject jsonObject) {
		Integer integer = 0;
		try {
			integer = interFaceDao.tianjialiulanjiluhuo(jsonObject);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return integer;
	}

	// 修改浏览记录时间(货车)
	@Override
	public Integer xiugailiulanjiluhuoche(Map<String, Object> map) {
		Integer integer = 0;
		try {
			integer = interFaceDao.xiugailiulanjiluhuoche(map);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return integer;
	}

	// 添加浏览记录(车)
	@Override
	public Integer tianjialiulanjiluche(JSONObject jsonObject) {
		Integer integer = 0;
		try {
			integer = interFaceDao.tianjialiulanjiluche(jsonObject);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return integer;
	}

	// 查询我的浏览纪录
	@Override
	public Map<String, Object> selectliulanjilu(Map<String, Object> map1) {
		Map<String, Object> map = new HashMap<>();
		try {
			map = interFaceDao.selectliulanjilu(map1);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return map;
	}

	// 查询浏览记录表的内容
	@Override
	public List<Map<String, Object>> selectliulanjilubiao(String user_id) {
		List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
		try {
			maps = interFaceDao.selectliulanjilubiao(user_id);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return maps;
	}

	/**
	 * 微信相关： 保存微信用户授权信息
	 */
	// 保存微信用户授权信息
	@Override
	public void insertWxUser(WxUser user) {
		try {
			interFaceDao.insertWxUser(user);
		} catch (DataAccessException d) {
			logger.info("保存微信用户授权信息错误：" + d.getLocalizedMessage());
		}
	}

	// 查询是否授权过该微信用户
	@Override
	public int selectShouQuan(String wx_id) {
		int count = 0;
		try {
			count = interFaceDao.selectShouQuan(wx_id);
			logger.info("count+++++++++++" + count);
		} catch (DataAccessException d) {
			logger.info("查询是否授权过该微信用户错误：" + d.getLocalizedMessage());
		}
		return count;
	}

	// 查询个人信息
	@Override
	public Map<String, Object> selectAUsersss(String user_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = interFaceDao.selectAUsersss(user_id);
			logger.info("map++++" + map);

		} catch (DataAccessException d) {
			logger.info("查询个人信息错误：" + d.getLocalizedMessage());
		}
		return map;
	}

	// 查询此用户是否进行过身份认证
	@Override
	public String selectidentityAuthentication(String user_authentication) {
		String authentication = null;
		try {
			authentication = interFaceDao.selectidentityAuthentication(user_authentication);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return authentication;
	}

	// 总的:查询是否完善车辆信息+查询是否身份认证
	@Override
	public Map<String, Object> selectShiro(String user_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = interFaceDao.selectShiro(user_id);
			logger.info("map++++" + map);

		} catch (DataAccessException d) {
			logger.info("查询个人信息错误：" + d.getLocalizedMessage());
		}
		return map;
	}

	// 分享回调
	@Override
	public int shareShiro(String wx_id, String share_shiro) {
		int count = 0;
		try {
			count = interFaceDao.shareShiro(wx_id, share_shiro);
			logger.info("count+++++++++++" + count);
		} catch (DataAccessException d) {
			logger.info("查询是否授权过该微信用户错误：" + d.getLocalizedMessage());
		}
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public ShareShiro selectshareShiro(String wx_id) {
		ShareShiro shareShiro = null;
		try {
			shareShiro = interFaceDao.selectshareShiro(wx_id);
			logger.info("shareShiro+++++++++++" + shareShiro);
		} catch (DataAccessException d) {
			logger.info("查询是否授权过该微信用户错误：" + d.getLocalizedMessage());
		}
		return shareShiro;
	}

	// 分享次数增加
	@Override
	public int CountshareShiro(String wx_id) {
		int count = 0;
		try {
			count = interFaceDao.CountshareShiro(wx_id);
			logger.info("count+++++++++++" + count);
		} catch (DataAccessException d) {
			logger.info("查询是否授权过该微信用户错误：" + d.getLocalizedMessage());
		}
		return count;
	}

	// 查询后台分享的话术
	@Override
	public Share sharePC() {
		Share share = null;
		try {
			share = interFaceDao.sharePC();
			logger.info("share+++++++++++" + share);
		} catch (DataAccessException d) {
			logger.info("查询是否授权过该微信用户错误：" + d.getLocalizedMessage());
		}
		return share;
	}

	/**
	 * 微信相關
	 */
	// 用户
	// 个人中心资料查询
	@Override
	public Map<String, Object> selectAUserziliao(String user_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = interFaceDao.selectAUserziliao(user_id);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return map;
	}

	// 用户简介查询
	@Override
	public List<Map<String, Object>> selectAUsersRelease(String user_id) {
		List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
		try {
			maps = interFaceDao.selectAUsersRelease(user_id);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return maps;
	}

	// 用户简介查询(发布信息数量)
	@Override
	public Map<String, Object> selectAUsersReleaseNumber(String user_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = interFaceDao.selectAUsersReleaseNumber(user_id);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return map;
	}

	// 用户简介中查询个人信息
	@Override
	public Map<String, Object> selectAUsers(String user_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = interFaceDao.selectAUsers(user_id);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return map;
	}

	// 关于我们
	@Override
	public Map<String, Object> guanyuwomen() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = interFaceDao.guanyuwomen();
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：" + d.getLocalizedMessage());
		}
		return map;
	}

	// 查询是否收藏此用户
	public Map<String, Object> selectMyCollectionUser(JSONObject jsonObject) {
		Map<String, Object> map = new HashMap<>();
		try {
			map = interFaceDao.selectMyCollectionUser(jsonObject);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误：(selectMyCollectionUser)" + d.getLocalizedMessage());
		}
		return map;
	}

	// 点击收藏取消用户
	public Integer dianjishoucanguser(JSONObject jsonObject) {
		Integer integer = 0;
		try {
			integer = interFaceDao.dianjishoucanguser(jsonObject);
		} catch (DataAccessException d) {
			logger.info("查询数据库错误()：" + d.getLocalizedMessage());
		}
		return integer;
	}

}