package com.godd.core;

/**
 * Description:
 * User: godd
 * Date: 2017-10-23
 * Time: 下午9:20
 */
public class BeanDefinition {
    private String beanClassName;

    private Class beanClass;

    public BeanDefinition() {
    }

    public BeanDefinition(String beanClassName) {
        this.setBeanClassName(beanClassName);;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
