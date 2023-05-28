package cn.meshed.framework.context.support;

import cn.meshed.framework.beans.BeansException;
import cn.meshed.framework.beans.factory.config.BeanPostProcessor;
import cn.meshed.framework.context.ApplicationContext;
import cn.meshed.framework.context.ApplicationContextAware;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

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
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware)bean).setApplicationContext(applicationContext);
        }
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
        return bean;
    }
}
