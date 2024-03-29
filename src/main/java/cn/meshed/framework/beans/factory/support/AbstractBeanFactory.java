package cn.meshed.framework.beans.factory.support;

import cn.meshed.framework.beans.BeansException;
import cn.meshed.framework.beans.factory.FactoryBean;
import cn.meshed.framework.beans.factory.config.BeanDefinition;
import cn.meshed.framework.beans.factory.config.BeanPostProcessor;
import cn.meshed.framework.beans.factory.config.ConfigurableBeanFactory;
import cn.meshed.framework.utils.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Abstract BeanFactory</h1>
 * 抽象类定义模板方法
 *
 * @author Vincent Vic
 * @version 1.0
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    /**
     * BeanPostProcessors to apply in createBean
     */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    /**
     * ClassLoader to resolve bean class names with, if necessary
     */
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();


    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }

    /**
     * 获取bean
     *
     * @param beanName
     * @return Object
     * @throws BeansException
     */
    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName, null);
    }

    /**
     * 获取bean
     *
     * @param beanName
     * @return Object
     * @throws BeansException
     */
    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    /**
     * 根据需要类型获取bean
     *
     * @param beanName     Bean名称
     * @param requiredType 指定类型
     * @return {@link T}
     * @throws BeansException
     */
    @Override
    public <T> T getBean(String beanName, Class<T> requiredType) throws BeansException {
        return (T) getBean(beanName);
    }

    /**
     * 添加Bean扩展处理器
     *
     * @param beanPostProcessor
     */
    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * 返回BeanPostProcessor列表
     *
     * @return {@link BeanPostProcessor}
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }

    protected <T> T doGetBean(final String beanName, final Object... args) throws BeansException {
        Object sharedInstance  = getSingleton(beanName);
        if (sharedInstance  != null) {
            return (T) getObjectForBeanInstance(sharedInstance, beanName);
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        Object bean = createBean(beanName, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, beanName);
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)){
            // 如果是 FactoryBean，则需要调用 FactoryBean#getObject
            return beanInstance;
        }
        Object object = getCacheObjectForFactoryBean(beanName);

        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }
        return object;
    }

    /**
     * 创建Bean定义
     *
     * @param beanName
     * @param beanDefinition
     * @return
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    /**
     * 获取bean 定义
     *
     * @param beanName bean name
     * @return {@link BeanDefinition}
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
