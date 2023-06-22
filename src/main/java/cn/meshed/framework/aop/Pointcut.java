package cn.meshed.framework.aop;

/**
 * <h1>切入点</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface Pointcut {

    /**
     * Return the ClassFilter for this pointcut.
     * @return the ClassFilter (never <code>null</code>)
     */
    ClassFilter getClassFilter();

    /**
     * Return the MethodMatcher for this pointcut.
     * @return the MethodMatcher (never <code>null</code>)
     */
    MethodMatcher getMethodMatcher();

}
