package com.li.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Demo3_UDP_MoreThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Receive().start();
		
		new Send().start();
	}

}

class Receive extends Thread {
	public void run() {
		try {
			DatagramSocket socket = new DatagramSocket(6666);		//����Socket�൱�ڴ�����ͷ
			DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);//����Packet�൱�ڴ�����װ��
			
			while(true) {
				socket.receive(packet);									//�ӻ�,��������
				
				byte[] arr = packet.getData();							//��ȡ����
				int len = packet.getLength();							//��ȡ��Ч���ֽڸ���
				String ip = packet.getAddress().getHostAddress();		//��ȡip��ַ
				int port = packet.getPort();							//��ȡ�˿ں�
				System.out.println(ip + ":" + port + ":" + new String(arr,0,len));
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}

class Send extends Thread {
	public void run() {
		try {
			Scanner sc = new Scanner(System.in);						//��������¼�����
			DatagramSocket socket = new DatagramSocket();				//����Socket�൱�ڴ�����ͷ
			
			while(true) {
				String line = sc.nextLine();							//��ȡ����¼����ַ���
				if("quit".equals(line)) {
					break;
				}
				DatagramPacket packet = 								//����Packet�൱�ڼ�װ��
						new DatagramPacket(line.getBytes(), line.getBytes().length, InetAddress.getByName("127.0.0.1"), 6666);
				socket.send(packet);									//����,�����ݷ���ȥ
			}
			socket.close();
		}  catch (IOException e) {
			
			e.printStackTrace();
		}		
	}
}