package cn.meshed.framework.beans.factory;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface FactoryBean<T> {

    /**
     * 得到对象
     *
     * @return 对象
     * @throws Exception
     */
    T getObject() throws Exception;

    /**
     * 对象类型
     *
     * @return Class
     */
    Class<?> getObjectType();

    /**
     * 是否是单例
     *
     * @return 单例
     */
    boolean isSingleton();

}
