package com.fec.epreport.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.fec.epreport.util.baidu.EncryptUtil;

import java.util.Properties;

public class PasswordEncryptConfigurer extends PropertyPlaceholderConfigurer {
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)throws BeansException {
    	try {
            String JdPassword = props.getProperty("password");
            String JdPasswords = null;
            if (JdPassword != null) {
                //加密  password
                String Jd = EncryptUtil.encrypt("Xfkjadmin123");
                System.out.println("加密："+Jd);
                //解密  password
                JdPasswords = EncryptUtil.decrypt(JdPassword);
                System.out.println("解密："+JdPasswords);
             }
            //将解密后的密码放入Properties中
             props.setProperty("password", JdPasswords);
             super.processProperties(beanFactory, props);
        }catch (Exception e){
            e.printStackTrace();
            throw new BeanInitializationException(e.getMessage());
        }
    }
}
