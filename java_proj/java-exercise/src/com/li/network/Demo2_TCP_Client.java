package com.li.network;
/**
 * 向服务器发送或者接收字符
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
/*
1.客户端
创建Socket连接服务端(指定ip地址,端口号)通过ip地址找对应的服务器
调用Socket的getInputStream()和getOutputStream()方法获取和服务端相连的IO流
 输入流可以读取服务端输出流写出的数据
 输出流可以写出数据到服务端的输入流
 */
public class Demo2_TCP_Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 12345);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //将字节流包装成字符流
		
		//用BufferedWriter的write("")写入字符串的时候，每次需要写"\r\n"换行符,所以用PrintStream的println()方法，就不需要写换行符了
		PrintStream ps = new PrintStream(socket.getOutputStream());
		
		//读取服务器的字符串
		System.out.println(br.readLine());
		
		//向服务器发送字符串
		ps.println("我想报名黑马程序员");
		
		//读取服务器的字符串
		System.out.println(br.readLine());
		
		//向服务器发送字符串
		ps.println("能不能给次机会");
		socket.close();
		
		
		
		
	}

}
