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

import org.springframework.beans.factory.InitializingBean;

import com.mytest.common.utils.LogUtils;

/**
 * @author liqingyu
 * @since 2018/05/25
 */
public class DemoInitializingBean implements InitializingBean {
    /** message */
    private String message;

    static {
        LogUtils.digestLog();
    }

    /**
     * init
     */
    public void init() {
        LogUtils.digestLog();
    }

    /**
     * before init be called
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() {
        LogUtils.digestLog();
    }

    /**
     * Getter method for property <tt>message</tt>.
     *
     * @return property value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter method for property <tt>message</tt>.
     *
     * @param message value to be assigned to property message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
