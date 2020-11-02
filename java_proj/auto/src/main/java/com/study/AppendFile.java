package com.study;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppendFile {
    // 将content写入到指定文件fileName中
    public static void appendFile(String fileName, String content) throws IOException {
        FileWriter writer = null;
        try {

            writer = new FileWriter(fileName, true);
            content = content + "\n";
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    // fileName中的内容清空
    public static void clearFile(String fileName) throws IOException {
        FileWriter writer = null;
        try {

            writer = new FileWriter(fileName);
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}