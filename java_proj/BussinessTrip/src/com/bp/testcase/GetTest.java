package com.bp.testcase;

import java.io.IOException;

import org.junit.Test;

import com.base.Config;

public class GetTest {
	@Test
	public void test_get() throws IOException{
		Config conf = new Config();
		String add = conf.getBPAddress();
		System.out.println(add);
	}

}
