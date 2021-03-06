package com.mytest.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mytest.bean.MyProcessor;
import com.mytest.model.UserInfo;

/**
 * @author liqingyu
 * @since 2018/05/30
 */
public class BeanProcessAspectTest {

    @Test
    public void test() {
        //根据XML配置文件初始化Spring上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "aop-processor.xml");
        MyProcessor myProcessor = applicationContext.getBean("myProcessor", MyProcessor.class);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("1");
        userInfo.setEmail("liqingyu@mytest.com");
        userInfo.setMobile("13812345678");
        myProcessor.processor(userInfo);
    }
}