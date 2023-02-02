package cn.meshed.framework.test.lifecycle;

import cn.meshed.framework.context.ApplicationContext;
import cn.meshed.framework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;


/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class ApiTest {

    @Test
    public void test_lifecycle() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-lifecycle.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String info = userService.queryUserInfo();
        System.out.println(info);
    }

}
