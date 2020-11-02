package com.study;
/*
往json文件中写入数据
 */
import com.alibaba.fastjson.JSONObject;

public class TestWriteCSV {
    public static void main(String[] args) {
        String filename = "D:/IdeaProjects/java_study/src/com/study/abc.csv";
        String jsonStr = ConfigCSV.readCsv(filename);
        JSONObject json = JSONObject.parseObject(jsonStr);
        json.put("school","xihu");
        json.put("id",1);
        System.out.println(json.toString());
        ConfigCSV.writeCsv(json,filename);

    }
}
