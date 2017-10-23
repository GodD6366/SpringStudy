package com.godd.core;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description:
 * User: godd
 * Date: 2017-10-23
 * Time: 下午9:17
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beans = new ConcurrentHashMap<String, BeanDefinition>();

    private static BeanFactory beanFactory = new BeanFactory();

    private BeanFactory() {
    }

    public static BeanFactory getInstance() {
        return beanFactory;
    }

    public void putBean(String name, Object bean) {
        beans.put(name, new BeanDefinition(bean));
    }

    public Object getBean(String name) {
        return beans.get(name).getBean();
    }

}
