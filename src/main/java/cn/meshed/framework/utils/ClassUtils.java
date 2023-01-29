package cn.meshed.framework.utils;

/**
 * <h1>类工具箱</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class ClassUtils {

    /**
     * 获取默认类加载器
     * @return {@link ClassLoader}
     */
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        }
        catch (Throwable ex) {
            // Cannot access thread context ClassLoader - falling back to system class loader...
        }
        if (cl == null) {
            // No thread context class loader -> use class loader of this class.
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }
}
