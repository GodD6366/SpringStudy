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

    /**
     * 注册备案到容器中
     *
     * @author 戴长春    dcc@vtc365.com
     * @date 2017/10/24 下午1:39
     */
    public void registerBean(String beanName, BeanDefinition beanDefinition) {
        try {
            beanDefinition.setBean(doCreateBean(beanDefinition));
        } catch (Exception e) {
            e.printStackTrace();
        }
        beans.put(beanName, beanDefinition);
    }

    public Object getBean(String beanName) {
        BeanDefinition beanDefinition = beans.get(beanName);
        if (beanDefinition.getSchema().equals("single")) {
            return beanDefinition.getBean();
        } else {
            try {
                return doCreateBean(beanDefinition);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * 初始化bean
     *
     * @author 戴长春    dcc@vtc365.com
     * @date 2017/10/23 下午9:50
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
