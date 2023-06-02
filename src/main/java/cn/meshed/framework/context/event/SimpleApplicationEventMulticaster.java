package cn.meshed.framework.context.event;

import cn.meshed.framework.beans.factory.BeanFactory;
import cn.meshed.framework.context.ApplicationEvent;
import cn.meshed.framework.context.ApplicationListener;

import java.util.Collection;
import java.util.Optional;

/**
 * <h1>简单实现事件广播器</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    /**
     * Multicast the given application event to appropriate listeners.
     *
     * @param event the event to multicast
     */
    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
