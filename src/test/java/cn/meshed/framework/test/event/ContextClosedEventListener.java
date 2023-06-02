package cn.meshed.framework.test.event;

import cn.meshed.framework.context.ApplicationListener;
import cn.meshed.framework.context.event.ContextClosedEvent;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }
}
