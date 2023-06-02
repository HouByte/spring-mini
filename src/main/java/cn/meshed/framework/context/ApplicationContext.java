package cn.meshed.framework.context;

import cn.meshed.framework.beans.factory.HierarchicalBeanFactory;
import cn.meshed.framework.beans.factory.ListableBeanFactory;
import cn.meshed.framework.core.io.ResourceLoader;

/**
 * <h1>应用上下文</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
