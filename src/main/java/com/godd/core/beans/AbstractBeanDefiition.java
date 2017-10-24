package com.godd.core.beans;

import com.godd.core.beans.io.ResourceLoader;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: godd
 * Date: 2017-10-23
 * Time: 下午10:35
 */
@Data
@NoArgsConstructor
public abstract class AbstractBeanDefiition implements BeanDefinitionReader{

    private Map<String,BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefiition(ResourceLoader resourceLoader) {
        this.registry = new HashMap<String, BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }

    public void loadBeanDefinitions(String location) throws Exception {

    }
}
