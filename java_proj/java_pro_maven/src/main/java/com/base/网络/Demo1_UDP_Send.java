package com.base.网络;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Demo1_UDP_Send {
/*	 * 1.发送Send
	 * 创建DatagramSocket, 随机端口号
	 * 创建DatagramPacket, 指定数据, 长度, 地址, 端口
	 * 使用DatagramSocket发送DatagramPacket
	 * 关闭DatagramSocket
 * 
 */
	public static void main(String[] args) throws IOException {
		String str = "hello world";
		DatagramSocket socket = new DatagramSocket(); //创建socket相当于创建码头   
		
		//创建Packet相当于集装箱
		DatagramPacket packet = new DatagramPacket(str.getBytes(), 
				str.getBytes().length, InetAddress.getByName("127.0.0.1"), 6666);
		socket.send(packet);  //发货，将数据发出去
		socket.close();		 //关闭码头
	}

}
