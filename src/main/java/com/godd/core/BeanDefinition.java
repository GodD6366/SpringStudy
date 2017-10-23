package com.godd.core;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Description:
 * User: godd
 * Date: 2017-10-23
 * Time: 下午9:20
 */
@Data
@Accessors(chain = true)
public class BeanDefinition {
    private String beanClassName;

    private Class beanClass;

    private PropertyValues filedValues;

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
