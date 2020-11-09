package com.exercise.xmlparse;
/**
 * xml解析：jsoup 入门
 *
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class Demo02Jsoup {
    public static void main(String[] args) throws IOException {
        //2.获取Document对象，根据xml文档获取
        //2.1获取xml的path
        String path = Demo02Jsoup.class.getClassLoader().getResource("student.xml").getPath();
        //2.2解析xml文档，加载文档进内场，获取DOM树--- Document
        Document document = Jsoup.parse(new File(path),"utf-8");
        //3.获取Element对象
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements);
        System.out.println(elements.size());

        Elements elements1 = document.getElementsByAttribute("id");
        System.out.println(elements1);
        Elements elements2 = document.getElementsByAttributeValue("number","heima_002");
        System.out.println(elements2);
        //3.1获取第一个name的Element对象
        Element element = elements.get(0);
        System.out.println(element.text());


    }
}
