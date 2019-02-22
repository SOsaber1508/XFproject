package com.fec.epreport.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

public class PasswordEncryptConfigurer extends PropertyPlaceholderConfigurer {
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)throws BeansException {
        System.out.println("正在解密系统文件。。。");
        try {
            String JdPassword = props.getProperty("password");
            System.out.println(JdPassword);
            String JdPasswords = null;
            if (JdPassword != null) {
                //加密  password
               /* JdPasswords = EncryptUtil.encrypt(JdPassword);*/
                 //解密  password
                JdPasswords = EncryptUtil.decrypt(JdPassword);
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
