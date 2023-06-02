package cn.meshed.framework.test.event;

import cn.meshed.framework.context.event.ApplicationContextEvent;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class CustomEvent extends ApplicationContextEvent {

    private Integer id;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public CustomEvent(Object source,Integer id) {
        super(source);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
