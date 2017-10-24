package com.godd.core.beans.factory;

/**
 * Description:
 * User: godd
 * Date: 2017-10-23
 * Time: 下午9:17
 */
public interface BeanFactory {
        Object getBean(String beanName) throws Exception;
}
