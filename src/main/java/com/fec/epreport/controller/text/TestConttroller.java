package com.fec.epreport.controller.text;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fec.epreport.entity.Users;
import com.fec.epreport.pojo.WxUser;
import com.fec.epreport.service.InterFaceService;
import com.fec.epreport.util.commons.PureNetUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * 接收json用测试接口
 * 
 * @author zcy
 *
 */
@Controller
@RequestMapping("/test1")  
public class TestConttroller {
	private static Logger logger = LoggerFactory.getLogger(TestConttroller.class);

	
	@Autowired
	InterFaceService interFaceService;
	
	@ResponseBody
	@RequestMapping(value = "/test.htm", method = RequestMethod.POST)
	public Map<String, Object> getString(HttpServletRequest request) {
		logger.info("进入/test1/test.htm");
		Map<String, Object> jsonObject = new HashMap<String, Object>(); // 创建Json对象
		try {
			String sb = PureNetUtil.buffJson(request);
			if ("".equals(sb.toString())) {
				jsonObject.put("code", "201");
				return jsonObject;
			}
				//WxUser user = JSON.parseObject(sb, WxUser.class);
				//interFaceService.insertWxUser(user);
			System.out.println("拿到接口的数据为：" + sb);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		jsonObject.put("code", "200");
		return jsonObject;
	}

	@ResponseBody
	@RequestMapping(value = "/bodyceshi.htm", method = RequestMethod.POST)
	public Map<String, Object> bodyceshi(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
		Map<String, Object> tobject = new HashMap<String, Object>(); // 创建Json对象
		try {
			String nickName = jsonObject.getString("nickname");
			String sex = jsonObject.getString("sex");
			String city = jsonObject.getString("city");
			String province = jsonObject.getString("province");
			String country = jsonObject.getString("country");
			String headimgurl = jsonObject.getString("headimgurl");
			String unionid = jsonObject.getString("unionid");
			String openid = jsonObject.getString("openid");
			// String emailTitle = jsonObject.get("emailTitle").toString();
			// String emailBody = jsonObject.get("emailBody").toString();
			logger.info(nickName);
			logger.info(sex);
			logger.info(city);
			logger.info(province);
			logger.info(country);
			logger.info(headimgurl);
			logger.info(unionid);
			logger.info(openid);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		tobject.put("code", "200");
		return tobject;
	}
//    /**
//     * 文件上传
//     * @param f
//     * @param request
//     * @return
//     */
//    @RequestMapping("updFile")
//    public Map<String,Object> updFile(MultipartFile f, HttpServletRequest request) {
//        Map<String,Object> map = new JSONObject();
//        if (!f.isEmpty()) {// 判断文件是否为空
//            try {
//                Map<String,String> strictParams = request.getParameterMap();
//                String contentType = f.getContentType();//文件类型
//                String organization = strictParams.get("organization");//组织
//                if (StringUtils.isBlank(organization)) {
//                    return TransitionEnum.请求参数缺失.getMap("The organization Can't find");
//                }
//                String scheme = strictParams.get("scheme");//功能方案
//                if (StringUtils.isBlank(scheme)) {
//                    scheme = "";
//                }
//                InputStream inputStream = f.getInputStream();//文件
//                if (null == inputStream) {
//                    return TransitionEnum.请求参数缺失.getMap("The file Can't find");
//                }
//                map = baseImagesService.upload(contentType, organization, scheme, inputStream);
//                return map;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }else {
//            return TransitionEnum.请求参数缺失.getMap("The file Can't find");
//        }
//        return TransitionEnum.系统异常.getMap();
//    }

}