package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Driver;

public class Day81_iframes {
  @Test
  public void f() throws InterruptedException {
	  
	  Driver.getDriver().get("https://demoqa.com/frames");
	  Thread.sleep(2000);
	  
	  Driver.driver.switchTo().frame("frame1");
	 String simplText = Driver.driver.findElement(By.id("sampleHeading")).getText();
	 System.out.println(simplText);
	 // at this point we are in anther frame called frame1 
	 Driver.driver.switchTo().parentFrame();
	 String longText = Driver.driver.findElement(By.xpath("//div[contains(text(),'Sample Iframe page There are 2 Iframes in this page.')]")).getText();
	 System.out.println(longText);
	 
	 //if you want to use webelement to switch
	 Driver.driver.switchTo().frame(Driver.driver.findElement(By.xpath("//iframe[@id='frame2']")));
	 System.out.println(Driver.driver.findElement(By.id("sampleHeading")).getText());
  }
  
  
  
  

@BeforeMethod
public void setup() {
Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@AfterMethod
public void quitDriver() {
Driver.quitDriver();
}
}
