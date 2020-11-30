package com.base.网络;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo01FileUploadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();

        InputStream is = socket.getInputStream();
        File file = new File("/conf/upload/");
        if(!file.exists()){
            file.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream(file + "/a.txt");
        int len = 0;
        byte[] bytes = new byte[1024];
        while((len = is.read(bytes)) != -1){
            fos.write(bytes,0,len);

        }

        socket.getOutputStream().write("上传成功".getBytes());
        fos.close();
        is.close();
        server.close();

    }
}
