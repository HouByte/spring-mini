package cn.meshed.framework.beans.factory;

/**
 * <h1>感知到所属的 ClassLoader</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface BeanClassLoaderAware extends Aware {

    /**
     * 设置Bean加载器
     *
     * @param classLoader bean 加载器
     */
    void setBeanClassLoader(ClassLoader classLoader);

}
