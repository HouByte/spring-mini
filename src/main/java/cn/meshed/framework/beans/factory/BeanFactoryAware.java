package cn.meshed.framework.beans.factory;

import cn.meshed.framework.beans.BeansException;

/**
 * <h1>感知到所属的 BeanFactory</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface BeanFactoryAware extends Aware {

    /**
     * 设置Bean工厂
     *
     * @param beanFactory bean 工厂
     * @throws BeansException
     */
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
