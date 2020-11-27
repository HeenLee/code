package com.base.junit4;

import org.junit.Test;

public class DemoTest {
	@Test
	public void testSum(){
		Demo d = new Demo();
		System.out.println(d.sum(2, 3));
	}

}
