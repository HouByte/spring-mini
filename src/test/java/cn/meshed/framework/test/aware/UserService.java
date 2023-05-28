package cn.meshed.framework.test.aware;

import cn.meshed.framework.beans.BeansException;
import cn.meshed.framework.beans.factory.BeanClassLoaderAware;
import cn.meshed.framework.beans.factory.BeanFactory;
import cn.meshed.framework.beans.factory.BeanFactoryAware;
import cn.meshed.framework.beans.factory.BeanNameAware;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class UserService implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware {

    private String uid;

    private UserDao userDao;

    public String queryUserInfo(){
        return userDao.queryUserName(uid);
    }


    /**
     * 设置Bean加载器
     *
     * @param classLoader bean 加载器
     */
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader => " + classLoader);
    }

    /**
     * 设置Bean工厂
     *
     * @param beanFactory bean 工厂
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactory => " + beanFactory);
    }

    /**
     * 设置Bean 名称
     *
     * @param name 名称
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("BeanName => " + name);
    }
}
