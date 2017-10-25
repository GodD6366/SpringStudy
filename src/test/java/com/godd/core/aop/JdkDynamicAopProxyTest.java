package com.godd.core.aop;

import com.godd.core.OutputServer;
import com.godd.core.context.ApplicationContext;
import com.godd.core.context.ClassPathXmlApplicationContext;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description:
 * User: godd
 * Date: 2017-10-25
 * Time: 下午8:30
 */
public class JdkDynamicAopProxyTest {
    @Test
    public void testInterceptor() throws Exception {
        // --------- outputServer without AOP
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("mySpring.xml");
        HelloWorldService outputServer = (HelloWorldService) applicationContext.getBean("helloWorldService");
//        outputServer.helloWorld();

        // --------- outputServer with AOP
        // 1. 设置被代理对象(Joinpoint)
        AdvisedSupport advisedSupport = new AdvisedSupport();

        TargetSource targetSource = new TargetSource(outputServer, HelloWorldService.class);
        advisedSupport.setTargetSource(targetSource);

        // 2. 设置拦截器(Advice)
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advisedSupport.setMethodInterceptor(timerInterceptor);

        // 3. 创建代理(Proxy)
        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
        HelloWorldService helloWorldServiceProxy = (HelloWorldService) jdkDynamicAopProxy.getProxy();

        // 4. 基于AOP的调用
        helloWorldServiceProxy.helloWorld();

    }

}