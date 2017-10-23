package com.godd.core;

/**
 * Description:
 * User: godd
 * Date: 2017-10-23
 * Time: 下午9:17
 */
public interface BeanFactory {
        void registerBean(String beanName, BeanDefinition beanDefinition);
        Object getBean(String beanName);
}
