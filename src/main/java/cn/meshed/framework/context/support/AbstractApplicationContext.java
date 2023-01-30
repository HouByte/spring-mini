package cn.meshed.framework.context.support;

import cn.meshed.framework.beans.BeansException;
import cn.meshed.framework.beans.factory.ConfigurableListableBeanFactory;
import cn.meshed.framework.beans.factory.config.BeanFactoryPostProcessor;
import cn.meshed.framework.beans.factory.config.BeanPostProcessor;
import cn.meshed.framework.context.ConfigurableApplicationContext;
import cn.meshed.framework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * <h1>抽象应用上下文</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    /**
     * 刷新Bean工厂
     *
     * @throws BeansException
     */
    protected abstract void refreshBeanFactory() throws BeansException;

    /**
     * 得到Bean工厂
     *
     * @return {@link ConfigurableListableBeanFactory}
     */
    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    /**
     * 获取bean
     *
     * @param beanName
     * @return Object
     * @throws BeansException
     */
    @Override
    public Object getBean(String beanName) throws BeansException {
        return getBeanFactory().getBean(beanName);
    }

    /**
     * 获取bean
     *
     * @param beanName
     * @param args
     * @return Object
     * @throws BeansException
     */
    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return getBeanFactory().getBean(beanName, args);
    }

    /**
     * 如果保护懒加载的类,FactoryBean初始化的类和工厂方法初始化的类会被初始化.就是说执行这个方法会执行对应的初始化.
     * 根据类型（包括子类）返回指定Bean名和Bean的Map
     *
     * @param type 类型
     * @return
     * @throws BeansException
     */
    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    /**
     * 返回工厂中所有Bean的名字
     *
     * @return {@link String[]}
     */
    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    /**
     * 根据需要类型获取bean
     *
     * @param beanName     Bean名称
     * @param requiredType 指定类型
     * @param <T>
     * @return {@link T}
     * @throws BeansException
     */
    @Override
    public <T> T getBean(String beanName, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(beanName, requiredType);
    }


    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    @Override
    public void refresh() throws BeansException {
        // 1.创建BeanFactory,并加载Bean定义
        refreshBeanFactory();

        // 2.获取BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 3.在Bean实例化之前，执行BeanFactoryPostProcessor(Invoke factory processors registered as beans in the context.)
        invokeBeanFactoryPostProcessors(beanFactory);

        // 4.BeanPostFactory需要提前Bean对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        // 5.提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();
    }


    /**
     * 执行BeanFactoryPostProcessor
     *
     * @param beanFactory Bean工厂
     */
    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        if (beanFactoryPostProcessorMap == null || beanFactoryPostProcessorMap.size() == 0){
            return;
        }
        beanFactoryPostProcessorMap.values()
                .forEach(beanFactoryPostProcessor -> beanFactoryPostProcessor.postProcessBeanFactory(beanFactory));
    }

    /**
     * BeanPostFactory 注册操作
     *
     * @param beanFactory Bean工厂
     */
    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        if (beanPostProcessorMap == null || beanPostProcessorMap.size() == 0){
            return;
        }
        beanPostProcessorMap.values().forEach(beanFactory::addBeanPostProcessor);
    }
}
