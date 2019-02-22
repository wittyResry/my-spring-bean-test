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

/**
 * [Spring in action] 3.5.3 配置属性外在化
 *
 * @author liqingyu
 * @since 2019/02/21
 */
public class PropertiesInjection {
    private String url;
    private String driver;

    /**
     * org.springframework.beans.factory.config.PropertyResourceConfigurer#postProcessBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
     *
     * @return
     */
    @Override
    public String toString() {
        return "PropertiesInjection{" +
                "url='" + url + '\'' +
                ", driver='" + driver + '\'' +
                '}';
    }

    /**
     * Setter method for property <tt>url</tt>.
     *
     * @param url value to be assigned to property url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Setter method for property <tt>driver</tt>.
     *
     * @param driver value to be assigned to property driver
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }
}
