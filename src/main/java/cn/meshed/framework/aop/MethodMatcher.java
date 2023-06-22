package cn.meshed.framework.aop;

import java.lang.reflect.Method;

/**
 * <h1>方法匹配</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface MethodMatcher {

    /**
     * Perform static checking whether the given method matches. If this
     * @return whether or not this method matches statically
     */
    boolean matches(Method method, Class<?> targetClass);
}
