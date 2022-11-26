package cn.meshed.framework.beans.factory.support;

import cn.meshed.framework.beans.factory.config.BeanDefinition;

/**
 * <h1>BeanDefinition Registry</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface BeanDefinitionRegistry {

    /**
     * 注册Bean 定义
     * @param beanName bean naem
     * @param beanDefinition Bean 定义
     */
    void registryBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
