package selenium;
/**
 * maven + testNG + java + selenium环境搭建后测试程序
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo {
    public WebDriver driver;
    String baseUrl = "http://www.baidu.com/";
  @Test
  public void testBaiduSearch() {
      driver.get(baseUrl+"/");
      WebElement inputBox = driver.findElement(By.id("kw"));
      Assert.assertTrue(inputBox.isDisplayed());
      inputBox.sendKeys("CSDN");
      driver.findElement(By.id("su")).click();
  }
  
  @BeforeMethod
  public void beforeMethod(){
	  System.setProperty("webdriber.chrome.driver", "d:/chromedriver.exe");
	  driver = new ChromeDriver();
  }
  
  @AfterMethod
  public void afterMethod(){
	  driver.quit();
  }
  
      
}
