package cn.meshed.framework.context.event;

/**
 * <h1>上下文刷新事件</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class ContextRefreshedEvent extends ApplicationContextEvent{

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
