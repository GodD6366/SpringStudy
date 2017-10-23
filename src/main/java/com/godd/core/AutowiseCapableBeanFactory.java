package com.godd.core;

/**
 * Description:
 * User: godd
 * Date: 2017-10-23
 * Time: 下午9:39
 */
public class AutowiseCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
