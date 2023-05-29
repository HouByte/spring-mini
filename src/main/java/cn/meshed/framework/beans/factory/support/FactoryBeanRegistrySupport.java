package cn.meshed.framework.beans.factory.support;

import cn.meshed.framework.beans.BeansException;
import cn.meshed.framework.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {

    private final Map<String, Object> facoryBeanObjectCache = new ConcurrentHashMap<>();

    protected Object getCacheObjectForFactoryBean(String beanName) {
        return this.facoryBeanObjectCache.get(beanName);
    }

    protected Object getObjectFromFactoryBean(FactoryBean factory, String beanName) {
        if (factory.isSingleton()) {
            Object object = getCacheObjectForFactoryBean(beanName);
            if (object == null) {
                object = doGetObjectFromFactoryBean(factory, beanName);
                this.facoryBeanObjectCache.put(beanName, object);
            }
            return object;
        } else {
            return doGetObjectFromFactoryBean(factory, beanName);
        }
    }

    private Object doGetObjectFromFactoryBean(FactoryBean factory, String beanName) {
        try {
            return factory.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
    }
}
