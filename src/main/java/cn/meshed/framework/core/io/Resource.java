package cn.meshed.framework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * <h1>资源顶层接口</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface Resource {

    /**
     * 获取输入流
     * @return {@link InputStream}
     * @throws IOException
     */
    InputStream getInputStream()  throws IOException;
}
