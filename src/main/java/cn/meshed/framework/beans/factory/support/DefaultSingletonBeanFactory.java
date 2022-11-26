package cn.meshed.framework.beans.factory.support;

import cn.meshed.framework.beans.factory.config.SingletonBeanFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class DefaultSingletonBeanFactory implements SingletonBeanFactory {

    private final Map<String,Object> singletonObjects = new HashMap<>();
    /**
     * 获取单例
     *
     * @param beanName bean name
     * @return object
     */
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 注册单例
     *
     * @param beanName        bean name
     * @param singletonObject 单例对象
     */
    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
