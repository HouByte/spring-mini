package cn.meshed.framework.beans.factory.support;

import cn.meshed.framework.beans.BeansException;
import cn.meshed.framework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * <h1>实例化策略</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface InstantiationStrategy {

    /**
     * 实例化构建对象
     * @param beanDefinition
     * @param beanName
     * @param constructor
     * @param args
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> constructor, Object[] args) throws BeansException;
}
