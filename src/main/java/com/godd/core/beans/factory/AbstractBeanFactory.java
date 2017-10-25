package com.godd.core.beans.factory;

import com.godd.core.beans.BeanDefinition;

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
        beans.put(beanName, beanDefinition);
    }

    /**
     * 获取容器中bean,没有初始化则执行初始化
     *
     * @author 戴长春    dcc@vtc365.com
     * @date 2017/10/24 下午9:55
     */
    public Object getBean(String beanName) throws Exception {
        BeanDefinition beanDefinition = beans.get(beanName);
        if (beanDefinition == null) {
            throw new IllegalAccessException("no bean named '" + beanName + "' is defined");
        }

        /**
         * 如果bean已经创建,并且是单例模式,则直接返回
         * @author 戴长春    dcc@vtc365.com
         * @date 2017/10/24 下午9:56
         */
        if (beanDefinition.getBean() != null && beanDefinition.getSchema().equals("single")) {
            return beanDefinition.getBean();
        } else {
            try {
                System.err.println("create bean for name: " + beanName);
                Object bean = doCreateBean(beanDefinition);
                beanDefinition.setBean(bean);
                return bean;
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
