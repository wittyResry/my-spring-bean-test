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
package com.mytest.bean;

import java.util.Properties;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mytest.common.utils.ValidateUtils;

/**
 * @author liqingyu
 * @since 2018/05/29
 */
public class BeanInvokeTest {


    @Resource(name = "sysProps")
    public Properties properties;

    @Test
    public void test() {
        //根据XML配置文件初始化Spring上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "bean-invoke.xml");
        System.out.println(ValidateUtils.getStaticInjectProp());
        Properties sysProps = applicationContext.getBean("sysProps", Properties.class);
        Assert.assertNotNull("sysProps", sysProps);
        String javaVersion = applicationContext.getBean("javaVersion", String.class);
        Assert.assertNotNull("javaVersion", javaVersion);
        Assert.assertEquals("等价实现", sysProps.getProperty("java.version"),javaVersion);
        System.out.println(javaVersion);

        //======test static注入=======
        Assert.assertEquals("注入static值", "beanInvokeValue", ValidateUtils.getStaticInjectProp());

        //
        System.out.println("=======done=======");
    }
}
