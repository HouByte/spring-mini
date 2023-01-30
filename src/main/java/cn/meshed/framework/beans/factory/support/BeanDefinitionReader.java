package cn.meshed.framework.beans.factory.support;

import cn.meshed.framework.beans.BeansException;
import cn.meshed.framework.core.io.Resource;
import cn.meshed.framework.core.io.ResourceLoader;

/**
 * <h1>BeanDefinitionReader 的作用是读取 Spring 配置文件中的内容，将其转换为 IoC 容器内部的数据结构：BeanDefinition。</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface BeanDefinitionReader {

    /**
     * 获取Bean定义注册信息
     * @return {@link BeanDefinitionRegistry}
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获取资源加载器
     * @return {@link ResourceLoader}
     */
    ResourceLoader getResourceLoader();

    /**
     * 根据资源加载Bean定义
     * @param resource 资源
     * @throws BeansException bean 加载异常
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    /**
     * 根据多个资源加载Bean定义
     * @param resources 多个资源
     * @throws BeansException bean 加载异常
     */
    void loadBeanDefinitions(Resource... resources) throws BeansException;

    /**
     * 根据位置加载Bean定义
     * @param location 位置
     * @throws BeansException bean 加载异常
     */
    void loadBeanDefinitions(String location) throws BeansException;

    /**
     * 根据多个位置加载Bean定义
     * @param locations 位置
     * @throws BeansException bean 加载异常
     */
    void loadBeanDefinitions(String ...locations) throws BeansException;

}
