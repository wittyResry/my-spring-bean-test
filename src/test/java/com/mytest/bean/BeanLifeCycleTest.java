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
        //根据XML配置文件初始化Spring上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "bean-life-cycle.xml");
        //需要注册一个在 AbstractApplicationContext 类中声明的关闭 hook 的 registerShutdownHook() 方法。它将确保正常关闭，并且调用相关的 destroy 方法
        ((AbstractApplicationContext) applicationContext).registerShutdownHook();
        System.out.println("=======done=======");
        MixBeanProcessor mixBeanProcessor = applicationContext.getBean("mixBeanProcessor",
            MixBeanProcessor.class);
        Assert.assertNotNull("just for test bean", mixBeanProcessor);
    }
}