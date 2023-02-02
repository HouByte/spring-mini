package cn.meshed.framework.context;

import cn.meshed.framework.beans.BeansException;

/**
 * <h1>配置应用上下文</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

    /**
     * 注册关闭钩子
     */
    void registerShutdownHook();

    /**
     * 容器关闭处理
     */
    void close();
}
