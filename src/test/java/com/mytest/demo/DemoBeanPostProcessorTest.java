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
public class DemoBeanPostProcessorTest {

    /**
     * 注意，对每个配置了InitializingBean或者init-method的bean都会做修饰
     */
    @Test
    public void test() {

        //根据XML配置文件初始化Spring上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "beanPostProcessor.xml");
        DemoInitializingBean demoInitializingBean = applicationContext.getBean("demoInitializingBean",
                DemoInitializingBean.class);
        System.out.println("done");
        Assert.assertNotNull("just for test demo", demoInitializingBean);
    }
}
