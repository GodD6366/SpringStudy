package com.godd.core.aop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * Description:
 * User: godd
 * Date: 2017-10-25
 * Time: 下午8:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReflectiveMethodInvocation implements MethodInvocation {

    private Object target;

    private Method method;

    private Object[] args;

    public Object[] getArguments() {
        return new Object[0];
    }

    public Object proceed() throws Throwable {
        return method.invoke(target, args);
    }

    public Object getThis() {
        return target;
    }

    public AccessibleObject getStaticPart() {
        return method;
    }
}
