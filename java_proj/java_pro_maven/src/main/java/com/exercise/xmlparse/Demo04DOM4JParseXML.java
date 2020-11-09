package com.exercise.xmlparse;

/**
 * 使用列表 增强for循环
 */

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;
import java.util.List;

public class Demo04DOM4JParseXML {
    public static void main(String[] args) throws DocumentException {
        //1.创建sax对象
        SAXReader saxReader = new SAXReader();
        //2.获取document对象
        Document document = saxReader.read(Demo04DOM4JParseXML.class.getClassLoader().getResource("student.xml").getPath());
        //3.获取根元素对象
        Element rootElement = document.getRootElement();
        System.out.println(rootElement);

        //获取所有子元素
        List<Element> childElements = rootElement.elements();

        //未知属性名的情况下
        for (Element childElement : childElements) {
            List<Attribute> attributes = childElement.attributes();
            for (Attribute attribute : attributes) {
                System.out.println(attribute.getName() + " & " + attribute.getValue());
            }
            System.out.println("----------------------------------->");

            //已知属性名的情况下
            System.out.println("number:" + childElement.attribute("number"));
            System.out.println("----------------------------------->");

            //未知子元素的情况下
            List<Element> elements = childElement.elements();
            for (Element element : elements) {
                System.out.println(element.getName() + " *** " + element.getText());
            }
            System.out.println("----------------------------------->");

            //已知子元素名的情况下
            System.out.println("name:" + childElement.elementText("name") );
            System.out.println("age:" + childElement.elementText("age") );
            System.out.println("sex:" + childElement.elementText("sex") );

            System.out.println("----------------------------------->");
        }






    }
}
