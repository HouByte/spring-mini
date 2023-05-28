package cn.meshed.framework.context;

import cn.meshed.framework.beans.factory.Aware;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface ApplicationContextAware extends Aware {

    /**
     * 设置应用上下文
     *
     * @param applicationContext 应用上下文
     */
    void setApplicationContext(ApplicationContext applicationContext);

}
