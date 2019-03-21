package com.fec.epreport.controller.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/evaluate")
public class EvaluateController {
    private static Logger logger = LoggerFactory.getLogger(EvaluateController.class);

    //评价列表查询
    @ResponseBody
    @RequestMapping("/selectEvaluates.htm")
    public String selectEvaluates(Integer user_id){
        try {

        } catch (Exception e) {
            logger.error("错误提示："+e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
        return "";
    }
    //提交评价
    @ResponseBody
    @RequestMapping("/submissionEvaluates.htm")
    public String submissionEvaluates(Integer user_id,String evaluate_type,String evaluate_content){
        try {
            HashMap<String,Object> hashMap = new HashMap<>();
            Integer id=null;
            hashMap.put("id",id);
            hashMap.put("user_id",user_id);
            hashMap.put("evaluate_type",evaluate_type);
            hashMap.put("evaluate_content",evaluate_content);
        } catch (Exception e) {
            logger.error("错误提示："+e.getLocalizedMessage(),e);
            e.printStackTrace();
        }
        return "";
    }
    //点击评价
    @ResponseBody
    @RequestMapping("/clickEvaluates.htm")
    public String clickEvaluates(Integer user_id){
        try {

        } catch (Exception e) {
            logger.error("错误提示："+e.getLocalizedMessage(),e);
            e.printStackTrace();
        }
        return "";
    }
}
