package com.godd.core.context;

import com.godd.core.beans.factory.AbstractBeanFactory;
import com.godd.core.beans.factory.AutowiseCapableBeanFactory;
import com.godd.core.beans.io.ResourceLoader;
import com.godd.core.beans.xml.XmlBeanDefinitionReader;

/**
 * Description:
 * User: godd
 * Date: 2017-10-24
 * Time: 下午10:16
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String location;

    public ClassPathXmlApplicationContext(String location) throws Exception {
        this(location, new AutowiseCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String location, AbstractBeanFactory beanFactory) throws Exception {
        super(beanFactory);
        this.location = location;
        refresh();
    }

    @Override
    public void refresh() {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        try {
            xmlBeanDefinitionReader.loadBeanDefinitions(location);
            xmlBeanDefinitionReader.getRegistry().forEach((key, value) -> {
                beanFactory.registerBean(key, value);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
