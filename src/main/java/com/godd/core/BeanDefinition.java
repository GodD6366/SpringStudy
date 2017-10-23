package com.godd.core;

/**
 * Description:
 * User: godd
 * Date: 2017-10-23
 * Time: 下午9:20
 */
public class BeanDefinition {
    private Object bean;

    public BeanDefinition() {
    }

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
