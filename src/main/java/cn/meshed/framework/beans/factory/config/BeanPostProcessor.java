package cn.meshed.framework.beans.factory.config;

import cn.meshed.framework.beans.BeansException;

/**
 * <h1>用于修改新实例化 Bean 对象的扩展点</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface BeanPostProcessor {

    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean bean对象
     * @param beanName bean名称
     * @return {@link Object}
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean bean对象
     * @param beanName bean名称
     * @return {@link Object}
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
