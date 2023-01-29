package cn.meshed.framework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * <h1>文件系统资源</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class FileSystemResource implements Resource {

    private final File file;

    public FileSystemResource(String path) {
        this.file = new File(path);
    }

    public FileSystemResource(File file) {
        this.file = file;
    }

    /**
     * 获取输入流
     *
     * @return {@link InputStream}
     */
    @Override
    public InputStream getInputStream() throws IOException {
        return Files.newInputStream(this.file.toPath());
    }

    public String getPath() {
        return file.getPath();
    }
}
