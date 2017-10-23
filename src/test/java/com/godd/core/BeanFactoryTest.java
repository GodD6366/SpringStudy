package com.godd.core;

import org.junit.Test;

/**
 * Description:
 * User: godd
 * Date: 2017-10-23
 * Time: 下午9:25
 */
public class BeanFactoryTest {

    @Test
    public void testBeanFactory() {
        //1.初始化容器
        BeanFactory beanFactory = new AutowiseCapableBeanFactory();

        //2.存放对象信息

        BeanDefinition beanDefinition = new BeanDefinition("com.godd.core.MySpringServer");
        beanFactory.registerBean("SpringServer",beanDefinition);


        //3.创建bean,并且调用
        MySpringServer springServer = (MySpringServer) beanFactory.getBean("SpringServer");
        springServer.sayHello();

    }

}