package cn.meshed.framework.test.event;

import cn.meshed.framework.context.ApplicationListener;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("消息：" + event.getId());
    }
}
