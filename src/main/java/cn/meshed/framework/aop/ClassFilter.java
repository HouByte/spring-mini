package cn.meshed.framework.aop;

/**
 * <h1>类别筛选器</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface ClassFilter {

    /**
     * Should the pointcut apply to the given interface or target class?
     * @param clazz the candidate target class
     * @return whether the advice should apply to the given target class
     */
    boolean matches(Class<?> clazz);
}
