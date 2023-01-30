package cn.meshed.framework.beans.factory.config;

import cn.meshed.framework.beans.BeansException;
import cn.meshed.framework.beans.factory.BeanFactory;

/**
 * <h1>容器外的Bean使用依赖注入</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     *
     * @param existingBean 扩展Bean
     * @param beanName Bean名称
     * @return {@link Object}
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
     *
     * @param existingBean 扩展Bean
     * @param beanName Bean名称
     * @return {@link Object}
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
