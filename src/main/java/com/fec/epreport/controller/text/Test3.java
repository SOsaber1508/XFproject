//package com.suneee.scn.wms.web.rocketmq;
//
//import java.util.List;
//
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Service;
//import org.springframework.web.context.support.WebApplicationObjectSupport;
//
//
//@Service("itemMessage")
//public class Test3 extends WebApplicationObjectSupport implements
//        MsgConsumerI {
//
//    private static final Logger log=LoggerFactory.getLogger(Test3.class);
//    
//    @Autowired
//    private ItemMainDao itemMainDao;
//    
//    private static ApplicationContext applicationContext = null;
//
//    public static ApplicationContext getAppContext() {
//        return applicationContext;
//    }
//
//    public static Object getBean(String name) {
//        return applicationContext.getBean(name);
//    }
//    
//     @Override
//     protected void initApplicationContext(ApplicationContext context) {
//     super.initApplicationContext(context);
//         if(applicationContext == null){
//         applicationContext = context;
//       }
//     }
//
//    
//
//    @Override
//    public boolean dealMsg(MsgInfo msg) {
//        log.debug("send数据已经传过来了:"+msg.getData());
//        //{'request': {'enterpriseid': 55,'ownerCode': 'SunEee01',
//        //'item': {'itemName': '熊孩子新疆无花果成品268g','itemType': 'ZC','barCode': '6924459400256',' shelfLife ': 0,'itemCode': 'xhzwhggcp_268'}}}
//        
//        //分解json
//        JSONObject jsonObject = JSONObject.fromObject(msg.getData());
//        String request = jsonObject.getString("request");
//        JSONObject itemd = JSONObject.fromObject(request);
//        String items = itemd.getString("item");
//        JSONObject item = JSONObject.fromObject(items);
//        
//}}