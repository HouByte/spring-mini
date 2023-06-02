package cn.meshed.framework.context.support;

import cn.meshed.framework.beans.BeansException;
import cn.meshed.framework.beans.factory.ConfigurableListableBeanFactory;
import cn.meshed.framework.beans.factory.config.BeanFactoryPostProcessor;
import cn.meshed.framework.beans.factory.config.BeanPostProcessor;
import cn.meshed.framework.context.ApplicationEvent;
import cn.meshed.framework.context.ApplicationListener;
import cn.meshed.framework.context.ConfigurableApplicationContext;
import cn.meshed.framework.context.event.ApplicationEventMulticaster;
import cn.meshed.framework.context.event.ContextClosedEvent;
import cn.meshed.framework.context.event.ContextRefreshedEvent;
import cn.meshed.framework.context.event.SimpleApplicationEventMulticaster;
import cn.meshed.framework.core.io.DefaultResourceLoader;

import java.util.Collection;
import java.util.Map;

/**
 * <h1>抽象应用上下文</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";

    private ApplicationEventMulticaster applicationEventMulticaster;

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

        // 3. 添加 ApplicationContextAwareProcessor，让继承自 ApplicationContextAware 的 Bean 对象都能感知所属的 ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

        // 4.在Bean实例化之前，执行BeanFactoryPostProcessor(Invoke factory processors registered as beans in the context.)
        invokeBeanFactoryPostProcessors(beanFactory);

        // 5.BeanPostFactory需要提前Bean对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        // 6.提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();

        // 7.注册生命周期钩子
        registerShutdownHook();

        // 8. 初始化事件发布者
        initApplicationEventMulticaster();

        // 9. 注册事件监听器
        registerListeners();

        // 10. 发布容器刷新完成事件
        finishRefresh();
    }

    private void initApplicationEventMulticaster() {
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, applicationEventMulticaster);
    }

    private void registerListeners() {
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        for (ApplicationListener listener : applicationListeners) {
            applicationEventMulticaster.addApplicationListener(listener);
        }
    }

    private void finishRefresh() {
        publishEvent(new ContextRefreshedEvent(this));
    }


    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
    }
    /**
     * 执行BeanFactoryPostProcessor
     *
     * @param beanFactory Bean工厂
     */
    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        if (beanFactoryPostProcessorMap == null || beanFactoryPostProcessorMap.size() == 0) {
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
        if (beanPostProcessorMap == null || beanPostProcessorMap.size() == 0) {
            return;
        }
        beanPostProcessorMap.values().forEach(beanFactory::addBeanPostProcessor);
    }

    /**
     * 注册关闭钩子
     */
    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    /**
     * 容器关闭处理
     */
    @Override
    public void close() {
        // 发布容器关闭事件
        publishEvent(new ContextClosedEvent(this));

        // 执行销毁单例bean的销毁方法
        getBeanFactory().destroySingletons();
    }
}
