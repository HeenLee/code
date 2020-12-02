package com.application.encpry.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String text = "aabbcc";

        byte[] encode = Base64.getEncoder().encode(text.getBytes());
        String secret = new String(encode, "utf8");
        System.out.println(secret);

        byte[] decode = Base64.getDecoder().decode(secret);
        String t = new String(decode, "utf8");
        System.out.println(t);
        System.out.println("=============");

        String base64 = Base64.getEncoder().encodeToString(text.getBytes("utf8"));
        System.out.println(base64);

        String src = new String(Base64.getDecoder().decode(base64), "utf8");
        System.out.println(src);

    }
}
