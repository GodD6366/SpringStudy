package com.godd.core;

/**
 * Description:
 * User: godd
 * Date: 2017-10-23
 * Time: 下午10:34
 */
public interface BeanDefinitionReader {
    void loadBeanDefinitions(String location) throws Exception;
}
