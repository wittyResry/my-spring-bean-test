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
package com.mytest.aop;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.AopUtils;

import com.mytest.aop.annotation.CheckAnnotated;
import com.mytest.bean.MyProcessor;
import com.mytest.common.utils.LogUtil;

/**
 * @author liqingyu
 * @since 2018/06/01
 */
public class BeanInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object retVal;
        try {
            LogUtil.digestLog();
            LogUtil.digest("log Begining method: %s.%s",
                invocation.getThis().getClass().getName(),
                invocation.getMethod().getName());
            Method method = AopUtils.getTargetClass(invocation.getThis()).getMethod(
                invocation.getMethod().getName(), invocation.getMethod().getParameterTypes());
                    //接口参数列表
            Object[] args = invocation.getArguments();
            if (invocation.getThis() instanceof MyProcessor) {
                ((MyProcessor) invocation.getThis()).setExtMassage("TEST 2");
            }
            method.isAnnotationPresent(CheckAnnotated.class);
            retVal = invocation.proceed();
        } catch (Exception e) {
            retVal = null;
        }
        return retVal;
    }
}
