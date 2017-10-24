package com.godd.core.context;

import com.godd.core.beans.factory.AbstractBeanFactory;
import lombok.Data;

/**
 * Description:
 * User: godd
 * Date: 2017-10-24
 * Time: 下午10:16
 */
@Data
public abstract class AbstractApplicationContext implements ApplicationContext {
    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() {

    }

    @Override
    public Object getBean(String name) throws Exception {
        if (beanFactory == null) {
            throw new IllegalAccessException("beanFactory is not defined");
        }

        return beanFactory.getBean(name);
    }
}
