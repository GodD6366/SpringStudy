package com.godd.core.beans.xml;

import com.godd.core.beans.AbstractBeanDefiition;
import com.godd.core.beans.BeanDefinition;
import com.godd.core.beans.BeanReference;
import com.godd.core.beans.Property.PropertyValue;
import com.godd.core.beans.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * Description:
 * User: godd
 * Date: 2017-10-23
 * Time: 下午10:42
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefiition {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinitions(inputStream);
    }

    /**
     * 创建XML对象
     *
     * @author 戴长春    dcc@vtc365.com
     * @date 2017/10/24 下午1:38
     */
    protected void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(inputStream);
        // 解析bean
        registerBeanDefinitions(doc);
        inputStream.close();
    }

    public void registerBeanDefinitions(Document doc) throws Exception{
        Element root = doc.getDocumentElement();
        parseBeanDefinitions(root);
    }

    protected void parseBeanDefinitions(Element root) throws Exception{
        NodeList nl = root.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                processBeanDefinition(ele);
            }
        }
    }

    protected void processBeanDefinition(Element ele) throws Exception{
        String name = ele.getAttribute("name");
        String className = ele.getAttribute("class");
        String schema = ele.getAttribute("schema");
        BeanDefinition beanDefinition = new BeanDefinition();
        processProperty(ele, beanDefinition);
        beanDefinition.setBeanClassName(className);
        beanDefinition.setSchema(schema);
        getRegistry().put(name, beanDefinition);
    }

    /**
     * 解析XML定义的值,存入到容器中
     *
     * @author 戴长春    dcc@vtc365.com
     * @date 2017/10/24 下午1:38
     */
    private void processProperty(Element ele, BeanDefinition beanDefinition) throws Exception {
        NodeList propertyNode = ele.getElementsByTagName("property");
        for (int i = 0; i < propertyNode.getLength(); i++) {
            Node node = propertyNode.item(i);
            if (node instanceof Element) {
                Element propertyEle = (Element) node;
                String name = propertyEle.getAttribute("name");
                String value = propertyEle.getAttribute("value");
                String ref = propertyEle.getAttribute("ref");

                if (!value.equals("")) {
                    beanDefinition.getFiledValues().addPropertyValue(new PropertyValue(name, value));
                    continue;
                }
                if (!ref.equals("")) {
                    BeanReference beanReference = new BeanReference(ref);
                    beanDefinition.getFiledValues().addPropertyValue(new PropertyValue(name, beanReference));
                    continue;
                }

                throw new IllegalAccessException("Configuration problem: <property> element for property '" + name + "' must specify a ref or value");


            }
        }
    }
}
