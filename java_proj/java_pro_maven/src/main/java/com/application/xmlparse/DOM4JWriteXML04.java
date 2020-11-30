package com.application.xmlparse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.*;

/**
 * 将内容写入xml文件    主要还是addText()添加元素   addAttribute()添加属性
 *
 */
public class DOM4JWriteXML04 {
    public static void main(String[] args) throws IOException {
        Document doc = DocumentHelper.createDocument();
        
        //增加跟节点
        Element books = doc.addElement("books");
        
        //增加子节点
        Element book1 = books.addElement("book");
        //子节点添加元素
        Element title1 = book1.addElement("title");
        Element author1 = book1.addElement("author");

        Element book2 = books.addElement("book");
        Element title2 = book2.addElement("title");
        Element author2 = book2.addElement("author");

        //为子节点添加属性
        book1.addAttribute("id","001");

        //为子元素添加内容
        title1.addText("哈利波特");
        author1.addText("柏林");

        book2.addAttribute("id","002");
        title2.addText("xml learning");
        author2.addText("ray");

        //实例化输出格式对象
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        File file = new File(File.separator + "books.xml");
        XMLWriter writer = new XMLWriter(new FileOutputStream(file),format);
        writer.write(doc);



    }
}
