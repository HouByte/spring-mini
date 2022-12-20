package cn.meshed.framework.test.reference;

import cn.meshed.framework.beans.PropertyValue;
import cn.meshed.framework.beans.PropertyValues;
import cn.meshed.framework.beans.factory.config.BeanDefinition;
import cn.meshed.framework.beans.factory.config.BeanReference;
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
    public void testBeanReference(){
        //1.初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //2.注册UserDao Bean对象
        beanFactory.registryBeanDefinition("userDao",new BeanDefinition(UserDao.class));
        //3，注入属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uid","001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));
        //4.注册UserService Bean对象并注入属性
        beanFactory.registryBeanDefinition("userService",new BeanDefinition(UserService.class,propertyValues));
        //5.获取Bean对象
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }


}
