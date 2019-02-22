package com.mytest.aop.jdkproxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

import com.mytest.aop.MyInvocationHandler;
import com.mytest.common.utils.LogUtils;
import com.mytest.model.UserInfo;

/**
 * @author liqingyu
 * @since 2018/06/04
 */
public class JDKProxyTest {
    /**
     * 1. 接口通过JDK动态代理类，反射实现
     * @see org.springframework.aop.framework.JdkDynamicAopProxy#invoke
     * 2. Class通过cglib动态代理实现
     */
    @Test
    public void test() {
        Service service = new UserService();
        MyInvocationHandler invocationHandler = new MyInvocationHandler(service) {
            @Override
            public void doBefore(Object proxy, Method method, Object[] args) {
                if (args.length > 0 && args[0] instanceof UserInfo) {
                    LogUtils.digest("log before method: %s.%s %s", proxy.getClass().getName(),
                        method.getName(), args[0]);
                }
            }

            @Override
            public void doAfter(Object proxy, Method method, Object[] args) {
                if (args.length > 0 && args[0] instanceof UserInfo) {
                    LogUtils.digest("log after method: %s.%s %s", proxy.getClass().getName(),
                        method.getName(), args[0]);
                }
            }
        };
        Service serviceProxy = (Service) Proxy.newProxyInstance(service.getClass().getClassLoader(),
            service.getClass().getInterfaces(), invocationHandler);

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("1");
        userInfo.setEmail("liqingyu@mytest.com");
        userInfo.setMobile("13812345678");
        UserInfo user = serviceProxy.process(userInfo);
        LogUtils.digest("脱敏后的user:" + user);
    }

}