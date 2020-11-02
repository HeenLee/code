package com.li.network;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo3_TCP_Server {

	public static void main(String[] args) throws IOException {
		//3.建立多线程的服务器
		ServerSocket server = new ServerSocket(6666);
		System.out.println("服务器启动，绑定6666端口");
		//4.读取文件名
		while(true){
			Socket socket = server.accept();  //接受请求
			new Thread(){
				public void run(){
					try {
						InputStream is = socket.getInputStream();
						BufferedReader br = new BufferedReader(new InputStreamReader(is));
						PrintStream ps = new PrintStream(socket.getOutputStream());
						String fileName = br.readLine();
						
						//5.判断文件是否存在，将结果发回客户端
						File dir = new File("update");
						dir.mkdir();
						File file = new File(dir, fileName);
						if(file.exists()){
							ps.println("存在");
							System.out.println(file.getAbsolutePath());
							socket.close();
							return;
						}else{
							ps.println("不存在");
						}
						
						//8.定义fileoutputstream,从网络读取文件，写出存储到本地
						FileOutputStream fos = new FileOutputStream(file);
						byte[] arr = new byte[1024];
						int len;
						while((len = is.read(arr)) != -1){
							fos.write(arr, 0, len);
						}
						fos.close();
						socket.close();
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
			}.start();
			
		}
	}

}
