package com.li.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * 简单的小例子
 * @author lihe
 *
 */
public class Demo01_Test {
	@Test
	public void testnum() {
		//chromedriver服务地址
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
      //新建一个WebDriver 的对象，但是new 的是ChromeDriver的驱动
        WebDriver driver =new ChromeDriver(); 	
        
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //打开指定网页
        driver.get("https://www.baidu.com"); 
        driver.findElement(By.id("kw")).sendKeys(new String[] {"hello"});   //找到kw元素的id，然后输入hello
        driver.findElement(By.id("su")).click(); //点击按扭
	    try {
	        /**
	         * WebDriver自带了一个智能等待的方法。
	        dr.manage().timeouts().implicitlyWait(arg0, arg1）；
	        Arg0：等待的时间长度，int 类型 ；
	        Arg1：等待时间的单位 TimeUnit.SECONDS 一般用秒作为单位。
	         */
	        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    /**
	     * dr.quit()和dr.close()都可以退出浏览器,简单的说一下两者的区别：第一个close，
	     * 如果打开了多个页面是关不干净的，它只关闭当前的一个页面。第二个quit，
	     * 是退出了所有Webdriver所有的窗口，退的非常干净，所以推荐使用quit最为一个case退出的方法。
	     */
      driver.quit();//退出浏览器
}
}