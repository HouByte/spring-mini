package cn.meshed.framework.beans.factory.config;

/**
 * <h1>BeanDefinition</h1>
 * Bean 定义信息
 * @author Vincent Vic
 * @version 1.0
 */
public class BeanDefinition {

    private Class<?> beanClass;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }
}
