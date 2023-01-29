package cn.meshed.framework.beans.factory.config;

import cn.meshed.framework.beans.factory.HierarchicalBeanFactory;

/**
 * <h1>定义BeanFactory的配置.</h1>
 * 这边定义了太多太多的api,比如类加载器,类型转化,属性编辑器,BeanPostProcessor,作用域,bean定义,处理bean依赖关系,合并其他ConfigurableBeanFactory,bean如何销毁.
 * 待完善
 * @author Vincent Vic
 * @version 1.0
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory {

    /**
     * 单例
     */
    String SCOPE_SINGLETON = "singleton";

    /**
     * 原型
     */
    String SCOPE_PROTOTYPE = "prototype";

}
