package cn.meshed.framework.context.support;

/**
 * <h1>XML 文件应用上下文</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    public ClassPathXmlApplicationContext(String configLocation) {
        this(new String[]{configLocation});
    }

    public ClassPathXmlApplicationContext(String[] configLocations) {
        this.configLocations = configLocations;
        refresh();
    }

    /**
     * 加载配置位置
     *
     * @return {@link String[]}
     */
    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }

}
