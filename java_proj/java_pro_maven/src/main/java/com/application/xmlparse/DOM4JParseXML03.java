package com.application.xmlparse;

/**
 * 使用迭代器遍历
 */

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;

public class DOM4JParseXML03 {
    public static void main(String[] args) throws DocumentException {
        //1.创建sax对象
        SAXReader saxReader = new SAXReader();
        //2.获取document对象
        Document document = saxReader.read(DOM4JParseXML03.class.getClassLoader().getResource("student.xml").getPath());
        //3.获取根元素对象
        Element rootElement = document.getRootElement();
        System.out.println(rootElement);

        //获取所有子元素
        Iterator<Element> iterator = rootElement.elementIterator();
        while (iterator.hasNext()){
            Element element = iterator.next();

            //未知属性名称情况下
            Iterator attr_iterator = element.attributeIterator();
            while(attr_iterator.hasNext()){
                Attribute attr_ele = (Attribute)attr_iterator.next();
                System.out.println(attr_ele.getName()+ " ***** " + attr_ele.getValue());
            }
            System.out.println("----------------->");
            //已知属性名称的情况
            System.out.println("number: " + element.attributeValue("number"));
            System.out.println("----------------->");

            //未知元素名的情况
            Iterator<Element> ele_iterator = element.elementIterator();
            while(ele_iterator.hasNext()){
                Element ele_element = ele_iterator.next();
                System.out.println(ele_element.getName() + "$$$$" + ele_element.getText());
            }
            System.out.println("---------------->");

            //已知元素名的情况下
            System.out.println("name " + element.elementText("name") );
            System.out.println("age " + element.elementText("age") );
            System.out.println("sex " + element.elementText("sex") );
            System.out.println("---------------->");

        }

    }
}
