package com.godd.core;

import com.godd.core.context.ApplicationContext;
import com.godd.core.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * Description:
 * User: godd
 * Date: 2017-10-23
 * Time: 下午9:25
 */
public class BeanFactoryTest {

    @Test
    public void testBeanFactory() throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("mySpring.xml");
        OutputServer outputServer = (OutputServer) context.getBean("OutputServer");
        outputServer.sayHello();
    }

}