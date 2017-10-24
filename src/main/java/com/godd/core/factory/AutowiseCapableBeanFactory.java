package com.godd.core.factory;

import com.godd.core.BeanDefinition;
import com.godd.core.Property.PropertyValue;
import com.godd.core.util.BeanUtil;

import java.lang.reflect.Method;
import java.util.Iterator;

/**
 * Description:
 * User: godd
 * Date: 2017-10-23
 * Time: 下午9:39
 */
public class AutowiseCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = null;
        Class beanClass = beanDefinition.getBeanClass();
        bean = beanClass.newInstance();
        //获取属性值对象
        Iterator<PropertyValue> iterator = beanDefinition
                .getFiledValues()
                .getPropertyValues()
                .iterator();

        //变量属性值,注入到对象中
        while (iterator.hasNext()) {
            PropertyValue next = iterator.next();
            Method method = beanClass.getDeclaredMethod(
                    parSetterName(next.getName()),
                    next.getValue().getClass()
            );

            method.invoke(bean, next.getValue());
        }

        return bean;
    }

    /**
     * AutowiseCapableBeanFactory
     *
     * @author 戴长春    dcc@vtc365.com
     * @date 2017/10/24 下午1:39
     */
    public String parSetterName(String name) {
        return "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
