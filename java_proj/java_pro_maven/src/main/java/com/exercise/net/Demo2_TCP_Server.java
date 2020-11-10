package com.exercise.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
/*
 * 2.服务端
 创建ServerSocket(需要指定端口号)
 调用ServerSocket的accept()方法接收一个客户端请求，得到一个Socket
 调用Socket的getInputStream()和getOutputStream()方法获取和客户端相连的IO流
 输入流可以读取客户端输出流写出的数据
 输出流可以写出数据到客户端的输入流
 */
public class Demo2_TCP_Server {

	public static void main(String[] args) throws IOException {
		//demo();
		ServerSocket server = new ServerSocket(12345);
		while(true){
			final Socket socket = server.accept();
			new Thread(){
				public void run(){
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						PrintStream ps = new PrintStream(socket.getOutputStream());
						
						ps.println("欢迎咨询黑马程序员");
						System.out.println(br.readLine());
						ps.println("不好意思，爆满了");
						System.out.println(br.readLine());
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
			}.start();
		}
	}

	
	/*
	 * 服务器单线程
	 */
	private static void demo() throws IOException {
		ServerSocket server = new ServerSocket(12345);
		
		Socket socket = server.accept();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream ps = new PrintStream(socket.getOutputStream());
		
		//向服务器发送字符串
		ps.println("欢迎咨询黑马程序员");
		//读取客户端发过来的字符串
		System.out.println(br.readLine());
		ps.println("不好意思，爆满了");
		System.out.println(br.readLine());
		
		//
		ps.print("");
	}

}
