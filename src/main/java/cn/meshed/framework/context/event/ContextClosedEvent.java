package cn.meshed.framework.context.event;

/**
 * <h1>上下文关闭事件</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class ContextClosedEvent extends ApplicationContextEvent{

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
