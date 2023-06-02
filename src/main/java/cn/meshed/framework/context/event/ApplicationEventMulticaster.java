package cn.meshed.framework.context.event;

import cn.meshed.framework.context.ApplicationEvent;
import cn.meshed.framework.context.ApplicationListener;

/**
 * <h1>事件广播器</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface ApplicationEventMulticaster {

    /**
     * Add a listener to be notified of all events.
     * @param listener the listener to add
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * Remove a listener from the notification list.
     * @param listener the listener to remove
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * Multicast the given application event to appropriate listeners.
     * @param event the event to multicast
     */
    void multicastEvent(ApplicationEvent event);
}
