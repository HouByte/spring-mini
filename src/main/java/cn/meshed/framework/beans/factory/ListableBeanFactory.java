package cn.meshed.framework.beans.factory;

import cn.meshed.framework.beans.BeansException;

import java.util.Map;

/**
 * <h1>根据条件返回Bean的集合</h1>
 * 提供了BeanDefinition、BeanName、注解有关的各种操作。
 * 这个工厂接口扩展了BeanFactory的功能，作为上文指出的BeanFactory二级接口,扩展了跟BeanDefinition的功能
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 如果保护懒加载的类,FactoryBean初始化的类和工厂方法初始化的类会被初始化.就是说执行这个方法会执行对应的初始化.
     * 根据类型（包括子类）返回指定Bean名和Bean的Map
     *
     * @param type 类型
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回工厂中所有Bean的名字
     *
     * @return {@link String[]}
     */
    String[] getBeanDefinitionNames();

}
