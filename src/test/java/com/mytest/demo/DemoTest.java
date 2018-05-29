package com.mytest.demo;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liqingyu
 * @since 2018/05/25
 */
public class DemoTest {

    @Test
    public void test() {
        //根据XML配置文件初始化Spring上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "beanTestContext.xml");
        MixBeanProcessor mixBeanProcessor = applicationContext.getBean("mixBeanProcessor",
            MixBeanProcessor.class);
        System.out.println("完成");
        Assert.assertNotNull("just for test demo", mixBeanProcessor);
    }
}