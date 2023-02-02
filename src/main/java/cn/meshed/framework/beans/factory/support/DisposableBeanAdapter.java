package cn.meshed.framework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import cn.meshed.framework.beans.BeansException;
import cn.meshed.framework.beans.factory.DisposableBean;
import cn.meshed.framework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * <h1>Bean销毁适配器</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class DisposableBeanAdapter implements DisposableBean {
    private final Object bean;
    private final String beanName;
    private final String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    /**
     * 销毁
     *
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        //1.实现接口DisposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        //2.执行配置的destroy-method
        // 避免二次销毁
        if (StrUtil.isNotEmpty(this.destroyMethodName)
                && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(this.destroyMethodName);

            destroyMethod.invoke(bean);
        }
    }
}
