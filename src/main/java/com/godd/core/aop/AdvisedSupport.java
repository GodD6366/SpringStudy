package com.godd.core.aop;

import lombok.Data;
import org.aopalliance.intercept.MethodInterceptor;

/**
 * Description:
 * User: godd
 * Date: 2017-10-25
 * Time: 下午8:21
 */
@Data
public class AdvisedSupport {
    private TargetSource targetSource;

    private MethodInterceptor methodInterceptor;
}
