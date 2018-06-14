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

import org.aspectj.lang.ProceedingJoinPoint;

import com.mytest.bean.MyProcessor;
import com.mytest.common.utils.LogUtils;

/**
 * @author liqingyu
 * @since 2018/05/30
 */
public class BeanProcessAspect {

    /**
     * Around advice.
     *
     * @param jp the jp
     * @return the object
     */
    public Object aroundAdvice(ProceedingJoinPoint jp) {
        Object retVal;
        try {
            LogUtils.digestLog();
            LogUtils.digest("log Begining method: %s.%s", jp.getTarget().getClass().getName(),
                jp.getSignature().getName());
            if (jp.getTarget() instanceof MyProcessor) {
                ((MyProcessor) jp.getTarget()).setExtMassage("TEST 2");
            }
            retVal = jp.proceed(jp.getArgs());
        } catch (Throwable throwable) {
            retVal = null;
        }
        return retVal;
    }
}
