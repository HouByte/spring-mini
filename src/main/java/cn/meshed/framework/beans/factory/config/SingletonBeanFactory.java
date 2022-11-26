package cn.meshed.framework.beans.factory.config;

/**
 * <h1>Singleton BeanFactory</h1>
 * 单例对象注册接口
 * @author Vincent Vic
 * @version 1.0
 */
public interface SingletonBeanFactory {

    /**
     * 获取单例
     * @param beanName bean name
     * @return object
     */
    Object getSingleton(String beanName);

    /**
     * 注册单例
     * @param beanName bean name
     * @param singletonObject 单例对象
     */
    void registerSingleton(String beanName, Object singletonObject);

}
