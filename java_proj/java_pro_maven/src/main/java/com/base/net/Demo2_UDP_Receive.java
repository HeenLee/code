package com.base.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Demo2_UDP_Receive {
/*
 * 2.接收Receive
* 创建DatagramSocket, 指定端口号
* 创建DatagramPacket, 指定数组, 长度
* 使用DatagramSocket接收DatagramPacket
* 关闭DatagramSocket
* 从DatagramPacket中获取数据
 */
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(6666); //创建socket相当于码头
		DatagramPacket packet= new DatagramPacket(new byte[1024], 1024); //创建packet相当于集装箱
		while(true){
			socket.receive(packet);   	//接收数据
			byte[] arr = packet.getData();   //获取数据
			int len = packet.getLength();	//获取有效的字节个数
			String ip = packet.getAddress().getHostAddress(); //获取IP地址
			int port = packet.getPort(); //获取端口号
			System.out.println(ip + ":" + port + ":" + new String(arr,0,len));
		}
		
	}

}
