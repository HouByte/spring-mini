package cn.meshed.framework.test.context;

import cn.meshed.framework.beans.BeansException;
import cn.meshed.framework.beans.factory.ConfigurableListableBeanFactory;
import cn.meshed.framework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class PrintBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory Bean工厂
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("Post Process Bean Factory ： Print");
    }
}
