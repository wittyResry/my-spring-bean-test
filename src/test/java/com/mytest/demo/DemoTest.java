package com.mytest.demo;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author liqingyu
 * @since 2018/05/25
 */
public class DemoTest {

    @Test
    public void test() {
        //����XML�����ļ���ʼ��Spring������
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "beanTestContext.xml");
        MixBeanProcessor mixBeanProcessor = applicationContext.getBean("mixBeanProcessor",
            MixBeanProcessor.class);
        Assert.assertNotNull("just for test demo", mixBeanProcessor);
    }
}