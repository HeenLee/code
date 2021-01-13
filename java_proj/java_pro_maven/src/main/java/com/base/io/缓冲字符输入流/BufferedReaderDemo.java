package com.base.io.缓冲字符输入流;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 对content.txt中的内容进行排序后，写入新的文件
 */
public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        //1.创建hashmap
        Map<String, String> map = new HashMap<>();
        //2. 创建缓冲字符输入流
        BufferedReader br = new BufferedReader(new FileReader("d:/content.txt"));
       //3.逐行读取文件内容
        String line = null;
        while((line = br.readLine()) != null){
            //4. 将读取的文本内容进行分割，存入Map集合
            String[] arr = line.split(",");
            map.put(arr[0], arr[1]);
        }
        System.out.println(map);

        //5. 创建缓冲字符输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("content.txt"));
        //6.遍历集合
        for (String key : map.keySet()){
            String value = map.get(key);
            bw.write(key);
            bw.write(",");
            bw.write(value);
            bw.newLine();
        }

        //7.释放资源
        bw.close();
        br.close();
    }
}
