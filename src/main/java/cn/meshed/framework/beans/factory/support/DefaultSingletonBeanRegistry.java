package cn.meshed.framework.beans.factory.support;

import cn.meshed.framework.beans.BeansException;
import cn.meshed.framework.beans.factory.DisposableBean;
import cn.meshed.framework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final Map<String,Object> singletonObjects = new HashMap<>();

    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();

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

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();
        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }

}
