package com.godd.core.beans;

import com.godd.core.beans.Property.PropertyValues;
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
    private Object bean; //单例时存放的bean对象

    private String schema; //single

    private String beanClassName;

    private Class beanClass;

    private PropertyValues filedValues = new PropertyValues();

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
