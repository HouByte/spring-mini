package cn.meshed.framework.test.reference;

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

    static {
        map.put("001","tom");
        map.put("002","jack");
    }

    public String queryUserName(String uid){
        return map.get(uid);
    }
}
