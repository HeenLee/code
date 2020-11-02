package selenium;

import java.nio.channels.Selector;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	/**
	 * 登录 Login
	 * @throws InterruptedException
	 */
  @Test
  public void testLogin() throws InterruptedException {
	  //访问的地址
	  String url = "https://yqtblackbox.sinosun.com:18093/yqt/tcm/pages/login.jsp";
	 //浏览器驱动
	  System.setProperty("driver", "d:/chromedriver.ext");
	 //创建浏览器对象
	  WebDriver chromeDriver = new ChromeDriver();
	  chromeDriver.get(url);
	  
	  //chromeDriver.findElement(By.id("mgrPhone")).sendKeys("lh1234");id定位
	  //chromeDriver.findElement(By.cssSelector(".login_name.uc-a1")).sendKeys("lh1234");//class选择器定位
	  chromeDriver.findElement(By.className("login_name")).sendKeys("lh1234");//class属性名定位
	  
	  chromeDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  //chromeDriver.findElement(By.id("mgrPwd")).sendKeys("Lh666666");
	 // chromeDriver.findElement(By.cssSelector(".login_pw.uc-a1")).sendKeys("Lh666666");class选择器
	  chromeDriver.findElement(By.className("login_pw")).sendKeys("Lh666666");
	  
	  chromeDriver.findElement(By.id("login_submit")).click();
	  
	  Thread.sleep(3000);
	  chromeDriver.quit();
  }
  
  /**
   * 测试页面返回上一页
   * @throws InterruptedException
   */
  @Test
  public void testForwardAndBackward() throws InterruptedException{
	  String url = "https://yqtblackbox.sinosun.com:18093/yqt/tcm/pages/login.jsp";
	  System.setProperty("driver", "d:/chromedriver.ext");
	  WebDriver chromeDriver = new ChromeDriver();
	  chromeDriver.get(url);
	  
	  chromeDriver.findElement(By.id("mgrPhone")).sendKeys("lh1234");
	  
	  chromeDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	
	  chromeDriver.findElement(By.id("mgrPwd")).sendKeys("Lh666666");
	  
	  
	  //点击进入页面
	  chromeDriver.findElement(By.id("login_submit")).click();
	   
	  //点击右上角的修改密码
	  Thread.sleep(10000);
	  chromeDriver.findElement(By.className("nav1")).click();
	  Thread.sleep(5000);
	  //弹出弹框后，返回上一层页面
	  chromeDriver.navigate().back();
	  
	  chromeDriver.quit();
  }
  
  /**
   * 清楚输入的文本
 * @throws InterruptedException 
   */
  @Test
  public void testClearText() throws InterruptedException{
	  String url = "https://yqtblackbox.sinosun.com:18093/yqt/tcm/pages/login.jsp";
	  
	  System.setProperty("chromedriver", "d:/chromedriver.ext");
	  
	  WebDriver chromeDriver = new ChromeDriver();
	  chromeDriver.get(url);
	 //获取页面元素
	  WebElement usrElement = chromeDriver.findElement(By.id("mgrPhone"));
	  //输入文本
	  usrElement.sendKeys("lh123456");
	  Thread.sleep(3000);
	 //清楚输入的文本
	  usrElement.clear();
	  Thread.sleep(3000);
	  chromeDriver.quit();
  }
  
  /**
   * 获取标签文本内容
 * @throws InterruptedException 
   */
  @Test
  public void testGetText() throws InterruptedException{
	  String url = "https://yqtblackbox.sinosun.com:18093/yqt/tcm/pages/login.jsp";
	  
	  System.setProperty("chromedriver", "d:/chromedriver.ext");
	  
	  WebDriver chromeDriver = new ChromeDriver();
	  chromeDriver.get(url);
	 //获取页面元素
	  WebElement inputElement = chromeDriver.findElement(By.id("mgrPhone"));
	  inputElement.sendKeys("hello");
	  Thread.sleep(2000);
	  
	 //通过value属性获取输入框的内容
	  Assert.assertEquals("hello", inputElement.getAttribute("value"));
	  
	  //获取元素中的文本  getText()用来获取元素中的文本内容
	  WebElement element = chromeDriver.findElement(By.id("login_submit"));
	  String text = element.getText();
	  Assert.assertEquals("登录", text);
	  
  }
  
  /**
   * 定位下拉框的元素
   * 三种方法 ：
   * 1. 使用Webdriver提供的Select类的方法  使用方法
   * 2. 先定位select 然后在定位option	 使用元素定位
   * 3.直接通过xpath层级标签定位  (浏览器可自动选择)  使用xPath定位
 * @throws InterruptedException 
   */
  @Test
  public void testSelect() throws InterruptedException{
	  
	  String url = "https://yqtblackbox.sinosun.com:18093/yqt/tcm/pages/login.jsp";
	  
	  System.setProperty("chromedriver", "d:/chromedriver.ext");
	  
	  WebDriver chromeDriver = new ChromeDriver();
	  chromeDriver.get(url);
	  
	  chromeDriver.findElement(By.id("mgrPhone")).sendKeys("lh1234");
	  chromeDriver.findElement(By.id("mgrPwd")).sendKeys("Lh666666");
	  chromeDriver.findElement(By.id("login_submit")).click();
	  
	  Thread.sleep(2000);
	  chromeDriver.findElement(By.id("infoStatMenu")).click();
	  chromeDriver.findElement(By.id("cpyAuthMenu")).click();
	
/*	  //方法一 :通过select提供的方法  selectByIndex()  selectByValue()   selectByVisibleText()选择下拉框的选项
	  Select select = new Select(chromeDriver.findElement(By.id("cpyStatus")));
	  //select.selectByIndex(3);
	 // select.selectByValue("4");
	  select.selectByVisibleText("解约");*/

	  
	  //方法二 通过先定位到selector   然后再定位到option
	  WebElement selector =  chromeDriver.findElement(By.id("cpyStatus"));
	  selector.findElements(By.tagName("option")).get(3).click();
	 
	  //方法三 使用xPath直接定位到option
	 /* WebElement element = chromeDriver.findElement(By.xpath(".//*[@id='cpyStatus']/option[4]"));
	  element.click();*/
	}
	  
  }
  
