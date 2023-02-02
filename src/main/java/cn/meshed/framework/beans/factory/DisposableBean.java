package cn.meshed.framework.beans.factory;

/**
 * <h1>Bean 销毁操作接口</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface DisposableBean {

    /**
     * 销毁
     *
     * @throws Exception
     */
    void destroy() throws Exception;
}
