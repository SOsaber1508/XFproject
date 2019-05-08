package com.fec.epreport.controller.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.fec.epreport.entity.Share;
import com.fec.epreport.service.InterFaceService;
import com.fec.epreport.util.commons.PureNetUtil;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/evaluate")
public class EvaluateController {
	private static Logger logger = LoggerFactory.getLogger(EvaluateController.class);
	@Resource
	HttpServletRequest request;
	@Resource
	HttpServletResponse response;
	@Autowired
	InterFaceService interFaceService;

	//评价列表查询
    @ResponseBody
    @RequestMapping("/selectEvaluates.htm")
    public Map<String, Object> selectEvaluates(Integer user_id){
        logger.info("come in   /evaluate /selectEvaluates.htm");
        Map<String, Object> jsonObject = new HashMap<String, Object>();
        List<Map<String,Object>> listjsonObject = null;
        try {
            String sb = "{" + "    \"wx_id\": \"o_xR71EEsiiZ7zmG2XXqd_u8FUbE\"" + "}";
//			String sb = PureNetUtil.buffJson(request);
            if ("".equals(sb.toString())) {
                jsonObject.put("code", "201");
                return jsonObject;
            }
            JSONObject wxObject = JSONObject.parseObject(sb);
            listjsonObject = interFaceService.selectEvaluates(wxObject.getString("wx_id"));
            jsonObject.put("favorableRate", "暂无");
            jsonObject.put("haoping_number",interFaceService.selectPraise(wxObject.getString("wx_id")).get("haoping_number"));
            jsonObject.put("zhongping_number",interFaceService.selectIn(wxObject.getString("wx_id")).get("zhongping_number")) ;
            jsonObject.put("chaping_number",interFaceService.selectDifferenc(wxObject.getString("wx_id")).get("chaping_number")) ;

        } catch (Exception e) {
            logger.error("错误提示(selectEvaluates)："+e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
        logger.info("leave   /evaluate /selectEvaluates.htm");
        jsonObject.put("code", "200");
        jsonObject.put("list",listjsonObject);
        return jsonObject;
    }

  //提交评价
    @ResponseBody
    @RequestMapping("/submissionEvaluates.htm")
    public Map<String, Object> submissionEvaluates(Integer user_id,String evaluate_type,String evaluate_content){
        logger.info("come in   /evaluate /submissionEvaluates.htm");
        Map<String, Object> jsonObject = new HashMap<String, Object>();
        try {
           // String sb = "{" + "    \"id\": \"1003\",\"user_id\": \"1004\",\"evaluate_type\": \"1\",\"evaluate_content\": \"设定地方官索尼单反\"" + "}";
            String sb = PureNetUtil.buffJson(request);
            if ("".equals(sb.toString())) {
                jsonObject.put("code", "201");
                return jsonObject;
            }
            JSONObject wxObject = JSONObject.parseObject(sb);
            Integer number=  interFaceService.submissionEvaluates(wxObject);
            jsonObject.put("number", "1");

        } catch (Exception e) {
            logger.error("错误提示(submissionEvaluates)："+e.getLocalizedMessage(),e);
            e.printStackTrace();
        }
        logger.info("leave   /evaluate /submissionEvaluates.htm");
        jsonObject.put("code", "200");
        return jsonObject;
    }

  //点击评价
    @ResponseBody
    @RequestMapping(value = "/clickEvaluates.htm")
    public Map<String, Object> clickEvaluates(Integer user_id){
        logger.info("come in   /evaluate /clickEvaluates.htm");
        Map<String, Object> jsonObject = new HashMap<String, Object>();
        try {
            //String sb = "{" + "    \"wx_id\": \"1001\"" + "}";
			String sb = PureNetUtil.buffJson(request);
            if ("".equals(sb.toString())) {
                jsonObject.put("code", "201");
                return jsonObject;
            }
            JSONObject wxObject = JSONObject.parseObject(sb);
            jsonObject = interFaceService.clickEvaluates(wxObject.getString("wx_id"));

        } catch (Exception e) {
            logger.error("错误提示(clickEvaluates)："+e.getLocalizedMessage(),e);
            e.printStackTrace();
        }
        logger.info("leave   /evaluate /clickEvaluates.htm");
        jsonObject.put("code", "200");
        return jsonObject;
    }

	// 分享内容
	@ResponseBody
	@RequestMapping("/shareCard.htm")
	public Map<String, Object> shareCard() {
        logger.info("come in   /evaluate /shareCard.htm");
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		try {
//			String sb = PureNetUtil.buffJson(request);
//			if ("".equals(sb.toString())) {
//				jsonObject.put("code", "201");
//				return jsonObject;
//			}
			Share share = interFaceService.sharePC();
			jsonObject.put("share_title", share.getShare_title());
			jsonObject.put("share_value", share.getShare_value());
			jsonObject.put("share_img", share.getShare_img());
			jsonObject.put("share_url", share.getShare_url());
		} catch (Exception e) {
			logger.error("错误提示(shareCard)：" + e.getLocalizedMessage(), e);
			e.printStackTrace();//apiwireless.58.com/api/redirect/down/3
		}
        logger.info("leave   /evaluate /shareCard.htm");
		return jsonObject;
	}

	// apk下载页
	@RequestMapping("/shareDownload.htm")
	public String shareDownload() {
		try {

		} catch (Exception e) {
			logger.error("错误提示：" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		return "share/share";
	}

	@RequestMapping("/download2.htm")
	public void downLoad(HttpServletResponse response, boolean isOnLine) throws Exception {
		logger.info("开始下载");
		String filePath=request.getServletContext().getRealPath("/app_update/peihuo.apk");
		File f = new File(filePath);
        if (!f.exists()) {
            response.sendError(404, "File not found!");
            return;
        }
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
        byte[] buf = new byte[1024];
        int len = 0;

        response.reset(); // 非常重要
        if (isOnLine) { // 在线打开方式
            URL u = new URL("file:///" + filePath);
            response.setContentType(u.openConnection().getContentType());
            response.setHeader("Content-Disposition", "inline; filename=" + f.getName());
            // 文件名应该编码成UTF-8
        } else { // 纯下载方式
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + f.getName());
        }
        OutputStream out = response.getOutputStream();
        while ((len = br.read(buf)) > 0)
            out.write(buf, 0, len);
        br.close();
        out.close();
        
        logger.info("离开下载");
    }
	// 重定向到apk下载页
		@RequestMapping("/download.htm")
		public String download() {
			logger.info("leave download.htm");
			return "share/share2";
		}
		// apk下载页
		@RequestMapping("/download3.htm")
		public String download3() {
			try {

			} catch (Exception e) {
				logger.error("错误提示：" + e.getLocalizedMessage(), e);
				e.printStackTrace();
			}
			return "share/share3";
		}
}