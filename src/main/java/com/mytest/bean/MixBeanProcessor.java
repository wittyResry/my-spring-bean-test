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

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import com.mytest.common.utils.LogUtil;

/**
 * @author liqingyu
 * @since 2018/05/25
 */
public class MixBeanProcessor implements InitializingBean, BeanFactoryPostProcessor,DisposableBean {

    /** demoInitializingBean */
    private DemoInitializingBean demoInitializingBean;

    static {
        LogUtil.digestLog();
    }

    /**
     * constructor
     */
    public MixBeanProcessor() {
        LogUtil.digestLog();
    }

    /**
     * init-method
     */
    public void init() {
        LogUtil.digestLog();
    }

    /**
     * destroy
     */
    @Override
    public void destroy() {
        LogUtil.digestLog();
    }

    /**
     * Invoked by a BeanFactory after it has set all bean properties supplied
     * (and satisfied BeanFactoryAware and ApplicationContextAware).
     * <p>This method allows the bean instance to perform initialization only
     * possible when all bean properties have been set and to throw an
     * exception in the event of misconfiguration.
     * @throws Exception in the event of misconfiguration (such
     * as failure to set an essential property) or if initialization fails.
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        LogUtil.digestLog();
    }

    /**
     * Modify the application context's internal bean factory after its standard
     * initialization. All bean definitions will have been loaded, but no beans
     * will have been instantiated yet. This allows for overriding or adding
     * properties even to eager-initializing beans.
     * @param beanFactory the bean factory used by the application context
     * @throws org.springframework.beans.BeansException in case of errors
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        LogUtil.digestLog();
    }

    /**
     * Setter method for property <tt>demoInitializingBean</tt>.
     *
     * @param demoInitializingBean value to be assigned to property demoInitializingBean
     */
    public void setDemoInitializingBean(DemoInitializingBean demoInitializingBean) {
        LogUtil.digestLog();
        this.demoInitializingBean = demoInitializingBean;
    }
}
