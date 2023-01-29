package cn.meshed.framework.beans.factory.support;

import cn.meshed.framework.core.io.DefaultResourceLoader;
import cn.meshed.framework.core.io.ResourceLoader;

/**
 * <h1>AbstractBeanDefinitionReader是读取BeanDefinition一个抽象类</h1>
 * 他已经实现了部分BeanDefinitionReader接口的部分方法，并且内部维护着一个成员变量registry，这个registry变量是BeanDefinitionRegistry接口的实现类对象
 *
 * @author Vincent Vic
 * @version 1.0
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry,new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    /**
     * 获取Bean 定义注册信息
     * @return
     */
    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    /**
     * 获取资源加载器
     * @return
     */
    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
