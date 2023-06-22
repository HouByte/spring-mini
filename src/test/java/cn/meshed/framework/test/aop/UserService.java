package cn.meshed.framework.test.aop;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class UserService implements IUserService{

    @Override
    public String queryUserInfo(){
        return "用户：李四 ！";
    }

    /**
     * @param userName
     * @return
     */
    @Override
    public String register(String userName) {
        return "注册用户：" + userName + " success！";
    }

}
