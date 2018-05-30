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

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liqingyu
 * @since 2018/05/29
 */
public class BeanScopeTest {
    @Test
    public void test() {
        //根据XML配置文件初始化Spring上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "bean-scope.xml");
        SingletonProcessor singletonProcessor1 = applicationContext.getBean("singletonProcessor1",
            SingletonProcessor.class);

        singletonProcessor1.setMessage("TEST 2");

        SingletonProcessor singletonProcessor = applicationContext.getBean("singletonProcessor1",
            SingletonProcessor.class);
        Assert.assertEquals("", "TEST 2", singletonProcessor.getMessage());

        SingletonProcessor singletonProcessor2 = applicationContext.getBean("singletonProcessor2",
            SingletonProcessor.class);
        Assert.assertNotSame("singleton distinguish by name", singletonProcessor1, singletonProcessor2);

        PrototypeProcessor prototypeProcessor1 = applicationContext.getBean("prototypeProcessor",
            PrototypeProcessor.class);
        PrototypeProcessor prototypeProcessor2 = applicationContext.getBean("prototypeProcessor",
            PrototypeProcessor.class);
        Assert.assertNotSame("prototype", prototypeProcessor1, prototypeProcessor2);
        Assert.assertNotSame("prototype", "TEST 4", prototypeProcessor1.getMessage());
        Assert.assertNotSame("prototype", "TEST 4", prototypeProcessor2.getMessage());
        System.out.println("=======done=======");
    }

    @Test
    public void main() {
        int a = (int) (Math.random()*10);
        int t = a >5 && a < 11 ? 1: 0;
        System.out.println(t);
    }
}
