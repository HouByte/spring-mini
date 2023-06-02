package cn.meshed.framework.context;

import java.util.EventObject;

/**
 * <h1>抽象类 ApplicationEvent</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
