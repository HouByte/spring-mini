package cn.meshed.framework.test.event;

import cn.meshed.framework.context.ApplicationListener;
import cn.meshed.framework.context.event.ContextClosedEvent;
import cn.meshed.framework.context.event.ContextRefreshedEvent;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }
}
