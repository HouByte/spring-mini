package cn.meshed.framework.context.support;

import cn.meshed.framework.beans.factory.support.DefaultListableBeanFactory;
import cn.meshed.framework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * <h1>XML 文件应用上下文</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{

    /**
     * 加载配置位置
     *
     * @return {@link String[]}
     */
    protected abstract String[] getConfigLocations();

    /**
     * 加载Bean 定义
     *
     * @param beanFactory Bean 工厂
     */
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }
}
