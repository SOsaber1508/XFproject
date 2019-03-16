package com.fec.epreport.controller.text;
 
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
 
/**
 *  接收json用测试接口
 * @author zcy
 *
 */
@Controller
@RequestMapping("/test1")
public class TestConttroller{
	private static Logger logger = LoggerFactory.getLogger(TestConttroller.class);
	
    @ResponseBody
	@RequestMapping(value="/test.htm",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
	public Map<String,Object> getString(HttpServletRequest request) {
    	logger.info("进入/test1/test.htm");
		Map<String,Object> jsonObject = new HashMap<String, Object>();  //创建Json对象
		try (InputStreamReader reader=new InputStreamReader(request.getInputStream(),"UTF-8")){
		//后台接收
		char [] buff=new char[1024];
		int length=0;
		while((length=reader.read(buff))!=-1){
		     String x=new String(buff,0,length);
		     System.out.println(x);
		}
		reader.close();
		//响应
		jsonObject.put("username", "张三");         //设置Json对象的属性
		jsonObject.put("password", "123456");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		return jsonObject;
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