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
     * @param beanName
     * @return Object
     * @throws BeansException
     */
    Object getBean(String beanName) throws BeansException;

    /**
     * 获取bean
     * @param beanName
     * @return Object
     * @throws BeansException
     */
    Object getBean(String beanName,Object... args) throws BeansException;
}
