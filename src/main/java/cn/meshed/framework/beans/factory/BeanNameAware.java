package cn.meshed.framework.beans.factory;

/**
 * <h1>感知到所属的 Bean名称</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface BeanNameAware extends Aware {

    /**
     * 设置Bean 名称
     * @param name 名称
     */
    void setBeanName(String name);

}
