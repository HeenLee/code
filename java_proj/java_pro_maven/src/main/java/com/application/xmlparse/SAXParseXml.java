package com.application.xmlparse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class SAXParseXml {
    public static void main(String[] args) {
        SAXReader sax = new SAXReader();
        try {
            Document document = sax.read(SAXParseXml.class.getClassLoader().getResourceAsStream("domain.xml"));
            Element rootElement = document.getRootElement();

            List<Element> elements = rootElement.elements();
            for (Element element : elements) {
                String name = element.attribute("name").getValue();
                String child = element.getName();
                if("domain".equals(child)){
                    String name1 = element.attribute("name").getValue();
                    System.out.println(name);
                }
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
