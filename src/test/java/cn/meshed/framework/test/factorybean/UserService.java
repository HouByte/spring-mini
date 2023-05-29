package cn.meshed.framework.test.factorybean;

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
public class UserService {

    private String uid;

    private IUserDao userDao;

    public String queryUserInfo(){
        return userDao.queryUserName(uid);
    }


}
