/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mytest.demo;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liqingyu
 * @since 2018/05/29
 */
public class BeanPostProcessorTest {

    /**
     * 注意，对每个配置了InitializingBean或者init-method的bean都会做修饰
     */
    @Test
    public void test() {

        //根据XML配置文件初始化Spring上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "bean-post-processor.xml");
        System.out.println("=======done=======");
        DemoInitializingBean bean1 = applicationContext.getBean("demoInitializingBean",
            DemoInitializingBean.class);
        Assert.assertEquals("test1", "Hello World 1! TEST 1", bean1.getMessage());
        DemoInitializingBean bean2 = applicationContext.getBean("demoInitializingBean2",
            DemoInitializingBean.class);
        Assert.assertEquals("test2", "Hello World 2! TEST 2", bean2.getMessage());
        System.out.println(bean1.getMessage());
        System.out.println(bean2.getMessage());
    }
}
