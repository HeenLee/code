package com.li.junit4;
/**
 * junit注解
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
@Ignore
public class TsetSum {
	Sum s = new Sum();
	int a = s.sum(1,3);
	int b = s.multi(2,4);
	int c = s.divid(12, 3);
	@BeforeClass
	public static void testIni(){
		System.out.println("初始化");
	}
	@Before
	public  void testBefor(){
		System.out.println("你好");
	}
	
	@Test
	public void testSum(){
		Assert.assertEquals(4, a);
		System.out.println("aaaa");
	}
	@Test
	public void testMulti(){
		Assert.assertEquals(8, b);
		System.out.println("bbbb");
	}
	
	@Test
	public void testDivid(){
		Assert.assertEquals(3, c);
		System.out.println("cccc");
	}
	
	
	@After
	public  void testAfte(){
		System.out.println("结束");
	}
	
	@AfterClass
	public static void testClear(){
		System.out.println("清理操作");
	}
	
	

}
