package cn.meshed.framework.beans.factory.support;

import cn.meshed.framework.beans.BeansException;
import cn.meshed.framework.beans.factory.BeanFactory;
import cn.meshed.framework.beans.factory.config.BeanDefinition;

/**
 * <h1>Abstract BeanFactory</h1>
 * 抽象类定义模板方法
 * @author Vincent Vic
 * @version 1.0
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanFactory implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws BeansException {
        Object bean = getSingleton(beanName);
        if (bean != null){
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName,beanDefinition);
    }

    /**
     * 创建Bean定义
     *
     * @param beanName
     * @param beanDefinition
     * @return
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

    /**
     * 获取bean 定义
     * @param beanName bean name
     * @return {@link BeanDefinition}
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
