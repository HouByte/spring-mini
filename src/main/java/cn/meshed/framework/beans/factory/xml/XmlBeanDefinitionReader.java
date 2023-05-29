package cn.meshed.framework.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import cn.meshed.framework.beans.BeansException;
import cn.meshed.framework.beans.PropertyValue;
import cn.meshed.framework.beans.factory.config.BeanDefinition;
import cn.meshed.framework.beans.factory.config.BeanReference;
import cn.meshed.framework.beans.factory.config.ConfigurableBeanFactory;
import cn.meshed.framework.beans.factory.support.AbstractBeanDefinitionReader;
import cn.meshed.framework.beans.factory.support.BeanDefinitionRegistry;
import cn.meshed.framework.core.io.Resource;
import cn.meshed.framework.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * <h1>通过XML读取Bean定义</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    /**
     * 根据资源加载Bean定义
     *
     * @param resource 资源
     * @throws BeansException bean 加载异常
     */
    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            try (InputStream inputStream = resource.getInputStream()) {
                doLoadBeanDefinitions(inputStream);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }


    /**
     * 根据多个资源加载Bean定义
     *
     * @param resources 多个资源
     * @throws BeansException bean 加载异常
     */
    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    /**
     * 根据位置加载Bean定义
     *
     * @param location 位置
     * @throws BeansException bean 加载异常
     */
    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    /**
     * 根据多个位置加载Bean定义
     *
     * @param locations 位置
     * @throws BeansException bean 加载异常
     */
    @Override
    public void loadBeanDefinitions(String... locations) throws BeansException {
        for (String location : locations) {
            loadBeanDefinitions(location);
        }
    }

    /**
     * 处理加载Bean定义核心方法
     *
     * @param inputStream
     * @throws ClassNotFoundException
     */
    private void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        Document doc = XmlUtil.readXML(inputStream);
        Element root = doc.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            //忽略非元素
            if (!(childNodes.item(i) instanceof Element)) {
                continue;
            }
            //忽略非bean标签
            if (!"bean".equals(childNodes.item(i).getNodeName())) {
                continue;
            }

            //解析标签
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            String initMethod = bean.getAttribute("init-method");
            String destroyMethod = bean.getAttribute("destroy-method");
            String beanScope = bean.getAttribute("scope");

            //获取Class,方便取类中的名称
            Class<?> clazz = Class.forName(className);
            //bean 名称优先级： id > name
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            //定义Bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            beanDefinition.setInitMethodName(initMethod);
            beanDefinition.setDestroyMethodName(destroyMethod);

            if (StrUtil.isNotBlank(beanScope)) {
                if (!(ConfigurableBeanFactory.SCOPE_PROTOTYPE.equals(beanScope) || ConfigurableBeanFactory.SCOPE_SINGLETON.equals(beanScope))) {
                    throw new BeansException("Scope invalid: " + beanScope);
                }
                beanDefinition.setScope(beanScope);
            }

            //读取属性填充
            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                //忽略非元素
                if (!(bean.getChildNodes().item(j) instanceof Element)) {
                    continue;
                }
                //忽略非bean标签
                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) {
                    continue;
                }
                //解析标签
                Element property = (Element) bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");

                //获取属性值：引用对象，值对象
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
                //重建属性信息
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }

            getRegistry().registryBeanDefinition(beanName, beanDefinition);
        }
    }
}
