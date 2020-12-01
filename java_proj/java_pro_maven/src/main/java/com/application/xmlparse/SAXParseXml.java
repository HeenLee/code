package com.application.xmlparse;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class SAXParseXml {
    public static void main(String[] args) {
        //1.创建sax镀锡
        SAXReader sax = new SAXReader();
        try {
            //2. 创建Document对象
            Document document = sax.read(SAXParseXml.class.getClassLoader().getResourceAsStream("domain.xml"));
            //3. 获取根节点
            Element rootElement = document.getRootElement();
            //4. 获取子节点列表
            List<Element> child = rootElement.elements();
            for (Element element : child) {
                Element ele = element.element("attribute");
                System.out.println(ele.attribute("name").getValue());
                System.out.println(ele.attribute("value").getValue());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
