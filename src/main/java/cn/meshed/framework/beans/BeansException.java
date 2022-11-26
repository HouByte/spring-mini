package cn.meshed.framework.beans;

/**
 * <h1>Bean Exception</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
