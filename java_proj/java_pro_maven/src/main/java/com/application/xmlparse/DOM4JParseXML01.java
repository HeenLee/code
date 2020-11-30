package com.application.xmlparse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;

public class DOM4JParseXML01 {
    public static void main(String[] args) throws DocumentException {
        //1.创建sax对象
        SAXReader saxReader = new SAXReader();
        //2.获取document对象
        Document document = saxReader.read(DOM4JParseXML01.class.getClassLoader().getResource("student.xml").getPath());
        //3.获取根元素对象
        Element rootElement = document.getRootElement();
        System.out.println(rootElement);
        
        //获取所有子元素
        Iterator<Element> childElement = rootElement.elementIterator("student");
        while( childElement.hasNext()){
            Element element = childElement.next();
            System.out.println(element.attribute("number"));
            String name = element.elementText("name");    //子元素的name字段值
            System.out.println(element.element("name").attributeValue("id"));  //name字段的id属性值
            String age = element.elementText("age");                        //age字段值
            String sex = element.elementText("sex");                        //sex字段值
            System.out.println(name + " " +  age + " " + sex);
        }

/*        Iterator<Element> childElement = rootElement.elementIterator();
        while (childElement.hasNext()){
            Element element = childElement.next();
            //遍历属性及属性值
            List<Attribute> attributes = element.attributes();
            for (Attribute attribute : attributes) {
                System.out.println(attribute);
                System.out.println(attribute.getValue());
            }

            Iterator iterator1 = element.elementIterator();
            while (childElement.hasNext()){
                Element element1 = (Element)iterator1.next();
                System.out.println(element.getName() + element.getStringValue());
            }
        }*/



    }
}
