package com.study;

import com.alibaba.fastjson.JSONObject;

import java.io.*;

public class ConfigCSV {
    public static String readCsv(String filename){
        String jsonStr = "";
        try {
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            Reader reader = new InputStreamReader(new FileInputStream(file),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while((ch = reader.read()) != -1){
                sb.append((char) ch);
            }
            fr.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeCsv(JSONObject json,String filename){

        try {
            File file = new File(filename);
            FileWriter fileWriter = new FileWriter(file,false);
            BufferedWriter br = new BufferedWriter(fileWriter);
            br.write(json.toString());
            br.close();
            fileWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
