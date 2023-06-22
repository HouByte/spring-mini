package cn.meshed.framework.test.aop;

import cn.meshed.framework.aop.AdvisedSupport;
import cn.meshed.framework.aop.TargetSource;
import cn.meshed.framework.aop.aspectj.AspectJExpressionPointcut;
import cn.meshed.framework.aop.framework.Cglib2AopProxy;
import cn.meshed.framework.aop.framework.JdkDynamicAopProxy;
import org.junit.Test;

import java.lang.reflect.Method;


/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class ApiTest {

    @Test
    public void testAop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* cn.meshed.framework.test.aop.UserService.*(..))");
        Class<UserService> clazz = UserService.class;
        Method method = clazz.getDeclaredMethod("queryUserInfo");

        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method, clazz));
        // true、true
    }
    @Test
    public void testDynamic() throws NoSuchMethodException {
        // 目标对象
        IUserService userService = new UserService();

        // 组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* cn.meshed.framework.test.aop.IUserService.*(..))"));

        // 代理对象(JdkDynamicAopProxy)
        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo());

        // 代理对象(Cglib2AopProxy)
        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_cglib.register("李四"));
    }

}
