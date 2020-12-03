package com.application.xmlparse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;

/**
 * 将xml配置的内容转为对象
 */
public class XMLParseObj {
    /**
     * 配置文件名
     */
    private static String filename = "conf.xml";
    private static Config config;

    /**
     * 从配置文件中读取参数并保存到Config类中
     */
    public static Config loadConfig() throws DocumentException {
        if(config == null){
            config = getConfig();
        }
        return config;
    }

    private static Config getConfig() throws DocumentException {
        Config config = new Config();
        SAXReader sax = new SAXReader();
        Document document = sax.read(Config.class.getClassLoader().getResourceAsStream(filename));
        Element rootElement = document.getRootElement();
        Iterator<Element> iterator = rootElement.elementIterator("value");
        while (iterator.hasNext()){
            Element element = iterator.next();
            String server = element.elementText("server");
            config.setServer(server);
            config.setServer(element.elementText("server"));
            config.setDbname(element.elementText("dbname"));
            config.setUser(element.elementText("user"));
            config.setPass(element.elementText("pass"));
            config.setPort(element.elementText("port"));
        }
        return config;
    }

    public static void main(String[] args) throws DocumentException {
        Config conf = loadConfig();
        System.out.println(conf.getConnString());

    }


}
