package cn.meshed.framework.test.lifecycle;

import cn.meshed.framework.beans.factory.DisposableBean;
import cn.meshed.framework.beans.factory.InitializingBean;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class UserService implements InitializingBean, DisposableBean {

    private String uid;

    private UserDao userDao;

    public String queryUserInfo(){
        return userDao.queryUserName(uid);
    }


    /**
     * 销毁
     *
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("执行：destroy");
    }

    /**
     * Bean 处理了属性填充后调用
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：afterPropertiesSet");
    }
}
