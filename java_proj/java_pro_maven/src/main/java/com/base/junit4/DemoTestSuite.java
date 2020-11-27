package com.base.junit4;
/**
 * 执行测试套件，需要有不同的测试类
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({DemoTest.class,Demo2Test.class})
public class DemoTestSuite {
	public void test(){
		
	}
	

}
