package com.base.net;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Demo01FileUploadClient {
    public static void main(String[] args) throws IOException {
//        创建本地字节输入流
        FileInputStream fis = new FileInputStream("conf/a.txt");
//        创建客户端socket对象
        Socket socket = new Socket("127.0.0.01",8888);
        OutputStream os = socket.getOutputStream();  //socket
        int len = 0;
        byte[] bytes = new byte[1024];
        while((len = fis.read(bytes)) != -1){
            os.write(bytes,0, len);
        }

        InputStream is = socket.getInputStream();
        while((len = is.read(bytes)) != -1){
            System.out.println(new String(bytes,0, len));
        }
        fis.close();
        socket.close();
    }
}
