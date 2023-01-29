package cn.meshed.framework.core.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * <h1>默认资源加载器</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class DefaultResourceLoader implements ResourceLoader{


    /**
     * 获取资源
     *
     * @param location 路径
     * @return {@link Resource}
     */
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e){
                return new FileSystemResource(location);
            }
        }
    }
}
