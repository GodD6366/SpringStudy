package com.godd.core;

import java.lang.reflect.InvocationTargetException;
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
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            Class beanClass = beanDefinition.getBeanClass();
            bean = beanClass.newInstance();
            //获取属性值对象
            Iterator<PropertyValue> iterator = beanDefinition.getFiledValues().getPropertyValues().iterator();

            while (iterator.hasNext()) {
                PropertyValue next = iterator.next();
                Method method = null;

                try {

                    method = beanClass.getDeclaredMethod(parSetterName(next.getName()), next.getValue().getClass());
                    method.invoke(bean, next.getValue());

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {

                }
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public String parSetterName(String name) {
        return "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
