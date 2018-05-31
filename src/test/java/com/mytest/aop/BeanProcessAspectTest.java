package com.mytest.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author liqingyu
 * @since 2018/05/30
 */
public class BeanProcessAspectTest {

    @Test
    public void test() {
        //����XML�����ļ���ʼ��Spring������
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "aop-processor.xml");
        MyProcessor myProcessor = applicationContext.getBean("myProcessor", MyProcessor.class);
        myProcessor.processor("hello world!");
    }
}