package cn.meshed.framework.test.factorybean;

import cn.meshed.framework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class ProxyBeanFactory implements FactoryBean<IUserDao> {
    /**
     * 得到对象
     *
     * @return 对象
     * @throws Exception
     */
    @Override
    public IUserDao getObject() throws Exception {
        InvocationHandler handler = ((proxy, method, args) -> "您被代理了，" + method.getName());

        return (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IUserDao.class}, handler);
    }

    /**
     * 对象类型
     *
     * @return Class
     */
    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

    /**
     * 是否是单例
     *
     * @return 单例
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
