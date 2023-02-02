package cn.meshed.framework.test.lifecycle;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class UserDao {

    private static Map<String,String> map = new HashMap<>();


    public void initDataMethod(){
        System.out.println("执行：init-method");
        map.put("001","tom");
        map.put("002","jack");
    }

    public void destroyDataMethod(){
        System.out.println("执行：destroy-method");
        map.clear();
    }
    public String queryUserName(String uid){
        return map.get(uid);
    }
}
