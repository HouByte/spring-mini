package cn.meshed.framework.beans.factory.config;

/**
 * <h1>Bean Reference</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }


    @Override
    public String toString() {
        return "BeanReference{" +
                "beanName='" + beanName + '\'' +
                '}';
    }
}
