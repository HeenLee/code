package com.base.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo02InputStreamReader {
    public static void main(String[] args) {
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(new FileInputStream("D:/hello.txt"));
            int len = 0;
            while((len=isr.read()) != -1){
                System.out.println(len);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Map<String,String> map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("age", "12");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();

    }

}
