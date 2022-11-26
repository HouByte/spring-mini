package cn.meshed.framework.test.bean;

import cn.meshed.framework.beans.factory.config.BeanDefinition;
import cn.meshed.framework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class ApiTest {

    @Test
    public void testBeanFactory(){
        //1.初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //2.注册Bean对象
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registryBeanDefinition("userService",beanDefinition);
        //3.获取Bean对象
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        //再次调用
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
    }

    @Test
    public void testCglib(){
        //1.初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //2.注册Bean对象
        BeanDefinition beanDefinition = new BeanDefinition(BookService.class);
        beanFactory.registryBeanDefinition("bookService",beanDefinition);
        //3.获取Bean对象
        BookService bookService = (BookService) beanFactory.getBean("bookService","Spring");
        bookService.queryBookInfo();
        //再次调用
        BookService bookService_singleton = (BookService) beanFactory.getBean("bookService","Spring");
        bookService_singleton.queryBookInfo();
    }
}
