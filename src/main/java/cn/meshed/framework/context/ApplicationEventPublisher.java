package cn.meshed.framework.context;

/**
 * <h1>事件发布</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface ApplicationEventPublisher {

    /**
     * Notify all listeners registered with this application of an application
     * event. Events may be framework events (such as RequestHandledEvent)
     * or application-specific events.
     * @param event the event to publish
     */
    void publishEvent(ApplicationEvent event);
}
