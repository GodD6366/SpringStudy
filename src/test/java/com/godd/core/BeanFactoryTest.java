package com.godd.core;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description:
 * User: godd
 * Date: 2017-10-23
 * Time: 下午9:25
 */
public class BeanFactoryTest {

    @Test
    public void testBeanFactory() {
        BeanFactory beanFactory = BeanFactory.getInstance();
        beanFactory.putBean("MySpringServer", new MySpringServer());

        MySpringServer mySpringServer = (MySpringServer) beanFactory.getBean("MySpringServer");
        mySpringServer.sayHello();

    }

}