package com.mytest.bean;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liqingyu
 * @since 2018/05/25
 */
public class BeanLifeCycleTest {

    @Test
    public void test() {
        //����XML�����ļ���ʼ��Spring������
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "bean-life-cycle.xml");
        //��Ҫע��һ���� AbstractApplicationContext ���������Ĺر� hook �� registerShutdownHook() ����������ȷ�������رգ����ҵ�����ص� destroy ����
        ((AbstractApplicationContext) applicationContext).registerShutdownHook();
        System.out.println("=======done=======");
        MixBeanProcessor mixBeanProcessor = applicationContext.getBean("mixBeanProcessor",
            MixBeanProcessor.class);
        Assert.assertNotNull("just for test bean", mixBeanProcessor);
    }
}