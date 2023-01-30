package cn.meshed.framework.context.support;

import cn.meshed.framework.beans.BeansException;
import cn.meshed.framework.beans.factory.ConfigurableListableBeanFactory;
import cn.meshed.framework.beans.factory.support.DefaultListableBeanFactory;

/**
 * <h1>刷新应用上下文</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;


    /**
     * 加载Bean 定义
     * @param beanFactory Bean 工厂
     */
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    /**
     * 刷新Bean工厂
     *
     * @throws BeansException
     */
    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    /**
     * 得到Bean工厂
     *
     * @return {@link ConfigurableListableBeanFactory}
     */
    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory(){
        return new DefaultListableBeanFactory();
    }
}
