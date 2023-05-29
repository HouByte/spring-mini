package cn.meshed.framework.test.factorybean;

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
    public void testFactoryBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-factorybean.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String info = userService.queryUserInfo();
        System.out.println(info);
    }

    @Test
    public void testPrototype() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-factorybean.xml");
        UserService userService1 = applicationContext.getBean("userService", UserService.class);
        UserService userService2 = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService1);
        System.out.println(userService2);
    }

}
