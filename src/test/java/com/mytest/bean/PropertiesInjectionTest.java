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

        import org.junit.Test;
        import org.springframework.context.ApplicationContext;
        import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liqingyu
 * @since 2019/02/21
 */
public class PropertiesInjectionTest {
    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "bean-prop.xml");
        PropertiesInjection propertiesInjection = applicationContext.getBean("propertiesInjection", PropertiesInjection.class);
        System.out.println("propertiesInjection=" + propertiesInjection);
    }
}
