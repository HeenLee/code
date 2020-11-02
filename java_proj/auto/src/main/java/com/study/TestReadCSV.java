package com.study;
/*
读取json文件中的数据
 */
import com.alibaba.fastjson.JSONObject;

public class TestReadCSV {
    public static void main(String[] args) {
        String filename = "D:/IdeaProjects/java_study/src/com/study/abc.csv";
        String jsonStr = ConfigCSV.readCsv(filename);
        System.out.println(jsonStr);
        JSONObject json = JSONObject.parseObject(jsonStr);
        String name = json.getString("name");
        System.out.println(name);
    }
}
