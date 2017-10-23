package com.godd.core;

import org.junit.Test;

import java.util.Date;

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

        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.godd.core.MySpringServer");

        //3.存储字段值
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue().setName("name").setValue("GodD6366"));
        propertyValues.addPropertyValue(new PropertyValue().setName("createTime").setValue(new Date()));
        beanDefinition.setFiledValues(propertyValues);

        beanFactory.registerBean("SpringServer",beanDefinition);

        //4.创建bean,并且调用
        MySpringServer springServer = (MySpringServer) beanFactory.getBean("SpringServer");
        springServer.sayHello();

    }

}