package cn.meshed.framework.beans.factory;

import cn.meshed.framework.beans.BeansException;
import cn.meshed.framework.beans.factory.config.AutowireCapableBeanFactory;
import cn.meshed.framework.beans.factory.config.BeanDefinition;
import cn.meshed.framework.beans.factory.config.ConfigurableBeanFactory;

/**
 * <h1>提供bean definition的解析,注册功能,再对单例来个预加载(解决循环依赖问题).</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface ConfigurableListableBeanFactory extends ConfigurableBeanFactory, ListableBeanFactory,
        AutowireCapableBeanFactory {

    /**
     * 获取bean定义
     * @param beanName bean 名称
     * @return {@link BeanDefinition}
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 预先初始化Bean
     *
     * @throws BeansException
     */
    void preInstantiateSingletons() throws BeansException;

}
