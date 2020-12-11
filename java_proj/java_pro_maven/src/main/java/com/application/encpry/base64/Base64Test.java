package com.application.encpry.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String text = "aabbcc";

        //将字符串转为字节数组进行编码
        byte[] encode = Base64.getEncoder().encode(text.getBytes());
        String secret = new String(encode, "utf8");
        System.out.println(secret);

        //将编码后的字符串解码为字节数组
        byte[] decode = Base64.getDecoder().decode(secret);
        //将字节数解码为原始字符串
        String t = new String(decode, "utf8");
        System.out.println(t);
        System.out.println("=============");

        String base64 = Base64.getEncoder().encodeToString(text.getBytes("utf8"));
        System.out.println(base64);

        String src = new String(Base64.getDecoder().decode(base64), "utf8");
        System.out.println(src);

    }
}
