package com.godd.core.aop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description:
 * User: godd
 * Date: 2017-10-25
 * Time: 下午8:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JdkDynamicAopProxy implements InvocationHandler, AopProxy {
    private AdvisedSupport advised;

    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] { advised.getTargetSource()
                .getTargetClass() }, this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
        return methodInterceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(), method,
                args));
    }
}
