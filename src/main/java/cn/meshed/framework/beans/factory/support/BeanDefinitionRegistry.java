package cn.meshed.framework.beans.factory.support;

import cn.meshed.framework.beans.BeansException;
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

    /**
     * 使用Bean名称查询BeanDefinition
     *
     * @param beanName bean 名称
     * @return {@link BeanDefinition}
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 判断是否包含指定名称的BeanDefinition
     * @param beanName bean 名称
     * @return {@link boolean}
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回注册表中所有的Bean名称
     * @return {@link String[]}
     */
    String[] getBeanDefinitionNames();

}
