package cn.meshed.framework.core.io;

import java.io.InputStream;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface ResourceLoader {

    /**
     * 用于从类路径加载的伪URL前缀：“classpath:”
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 获取资源
     * @param location 路径
     * @return {@link Resource}
     */
    Resource getResource(String location);
}
