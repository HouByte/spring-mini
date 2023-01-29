package cn.meshed.framework.beans.factory.support;

import cn.meshed.framework.beans.BeansException;
import cn.meshed.framework.beans.factory.ConfigurableListableBeanFactory;
import cn.meshed.framework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <h1>Bean 容器核心实现类</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {

    private final Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap(256);

    /**
     * 获取bean 定义
     *
     * @param beanName bean name
     * @return {@link BeanDefinition}
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null){
            throw new BeansException("No bean named '"+beanName+"' is defined");
        }
        return beanDefinition;
    }

    /**
     * 判断是否包含指定名称的BeanDefinition
     *
     * @param beanName bean 名称
     * @return {@link boolean}
     */
    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    /**
     * 按照类型返回 Bean 实例
     *
     * @param type
     * @return
     * @throws BeansException
     */
    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String,T> result = new HashMap<>();
        beanDefinitionMap.forEach(((beanName, beanDefinition) -> {
            Class<?> beanClass = beanDefinition.getBeanClass();
            if (type.isAssignableFrom(beanClass)){
                result.put(beanName,(T)getBean(beanName));
            }
        }));
        return result;
    }

    /**
     * 返回注册表中所有的Bean名称
     *
     * @return {@link String[]}
     */
    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }

    /**
     * 注册Bean 定义
     *
     * @param beanName       bean naem
     * @param beanDefinition Bean 定义
     */
    @Override
    public void registryBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);
    }
}
