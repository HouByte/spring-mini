package cn.meshed.framework.test.xml;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class UserService {

    private String uid;

    private UserDao userDao;

    public String queryUserInfo(){
        return userDao.queryUserName(uid);
    }


}
