package com.godd.core;

import com.godd.core.factory.AutowiseCapableBeanFactory;
import com.godd.core.factory.BeanFactory;
import com.godd.core.io.ResourceLoader;
import com.godd.core.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * Description:
 * User: godd
 * Date: 2017-10-23
 * Time: 下午9:25
 */
public class BeanFactoryTest {

    @Test
    public void testBeanFactory() throws Exception {

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("mySpring.xml");

        //1.初始化容器
        BeanFactory beanFactory = new AutowiseCapableBeanFactory();

        //2.存放对象信息

        //3.存储字段值
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBean(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        //4.创建bean,并且调用
        MySpringServer springServer = (MySpringServer) beanFactory.getBean("SpringServer");
        springServer.sayHello();

    }

}