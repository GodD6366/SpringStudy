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

        //1.加载xml配置文件
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("mySpring.xml");

        //2.初始化容器
        BeanFactory beanFactory = new AutowiseCapableBeanFactory();

        //3.存储XML中定义的bean信息
        xmlBeanDefinitionReader.getRegistry().forEach((key, value) -> {
            System.out.println("[register]: " + key);
            beanFactory.registerBean(key, value);
        });

        //4.创建bean,并且调用
        MySpringServer springServer = (MySpringServer) beanFactory.getBean("SpringServer");
        springServer.sayHello();
    }

}