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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liqingyu
 * @since 2018/06/04
 */
public abstract class MyInvocationHandler implements InvocationHandler {
    /** Proxied object */
    private Object target;

    /**
     * Constructor
     */
    public MyInvocationHandler() {
        super();
    }

    /**
     * Constructor with params
     *
     * @param target
     */
    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    public abstract void doBefore(Object proxy, Method method, Object[] args);

    public abstract void doAfter(Object proxy, Method method, Object[] args);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.doBefore(proxy, method, args);
        Object result = method.invoke(target, args);
        this.doAfter(proxy, method, args);
        return result;
    }
}
