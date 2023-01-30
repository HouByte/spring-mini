package cn.meshed.framework.test.context;

import cn.meshed.framework.beans.BeansException;
import cn.meshed.framework.beans.factory.config.BeanPostProcessor;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class PrintBeanPostProcessor implements BeanPostProcessor {
    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean     bean对象
     * @param beanName bean名称
     * @return {@link Object}
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Post Process Before Initialization ： "+ beanName);
        return bean;
    }

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean     bean对象
     * @param beanName bean名称
     * @return {@link Object}
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Post Process After Initialization ： "+ beanName);
        return bean;
    }
}
