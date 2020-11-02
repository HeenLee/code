package com.li.thread2;

import java.io.IOException;

public class Demo2_Runtime {

	public static void main(String[] args) throws IOException {
		Runtime r = Runtime.getRuntime();
//		r.exec("shutdown -s -t 300");   //300s后关机
		r.exec("shutdown -a"); //取消关机
	}

}
