package cn.meshed.framework.beans.factory;

import cn.meshed.framework.beans.BeansException;

/**
 * <h1>Bean Factory</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface BeanFactory {

    /**
     * 获取bean
     * @param beanName Bean名称
     * @return {@link Object}
     * @throws BeansException
     */
    Object getBean(String beanName) throws BeansException;

    /**
     * 获取bean
     * @param beanName Bean名称
     * @return {@link Object}
     * @throws BeansException
     */
    Object getBean(String beanName,Object... args) throws BeansException;

    /**
     * 根据需要类型获取bean
     *
     * @param beanName Bean名称
     * @param requiredType 指定类型
     * @return {@link T}
     * @param <T>
     * @throws BeansException
     */
    <T> T getBean(String beanName, Class<T> requiredType) throws BeansException;
}
