package cn.meshed.framework.context.event;

import cn.meshed.framework.context.ApplicationContext;
import cn.meshed.framework.context.ApplicationEvent;

/**
 * <h1>应用上下文事件</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class ApplicationContextEvent extends ApplicationEvent {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext(){
        return (ApplicationContext) getSource();
    }
}
