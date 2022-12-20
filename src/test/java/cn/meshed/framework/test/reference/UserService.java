package cn.meshed.framework.test.reference;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class UserService {

    private String uid;

    private UserDao userDao;

    public void queryUserInfo(){
        String userName = userDao.queryUserName(uid);
        System.out.println(userName);
    }


}
