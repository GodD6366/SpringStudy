package com.godd.core.factory;

import com.godd.core.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description:
 * User: godd
 * Date: 2017-10-23
 * Time: 下午9:38
 */
public abstract class AbstractBeanFactory implements BeanFactory {
    private Map<String, BeanDefinition> beans = new ConcurrentHashMap<String, BeanDefinition>();

    public void registerBean(String beanName, BeanDefinition beanDefinition) {
        try {
            beanDefinition.setBean(doCreateBean(beanDefinition));
        } catch (Exception e) {
            e.printStackTrace();
        }
        beans.put(beanName,beanDefinition);
    }

    public Object getBean(String beanName) {
        return beans.get(beanName).getBean();
    }


    /**
     * 初始化bean
     *
     * @author 戴长春    dcc@vtc365.com
     * @date 2017/10/23 下午9:50
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
