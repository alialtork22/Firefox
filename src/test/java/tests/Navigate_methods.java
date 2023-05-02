package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Driver;


public class Navigate_methods {
  @Test
  public void f() throws InterruptedException {
	  
		Driver.driver.manage().window().maximize();
		Driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		// go to amazon.com
		Driver.driver.get("https://Amazon.com");
		// search coffee ugly mug and click search
		WebElement searchBox = Driver.driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("coffee mug");
		Driver.driver.findElement(By.id("nav-search-submit-button")).click();
		// Navigate back
		Driver.driver.navigate().back();
		
		Thread.sleep(2000);// java code method
		
		// search ugly coffee mug and click search
		// we have to refind element again when we move between pages
		// but if we stay in same page we dont have to re inialize it again
		Driver.driver.findElement(By.id("twotabsearchtextbox")).sendKeys("ugly coffee mug");
		Driver.driver.findElement(By.id("nav-search-submit-button")).click();
		//navigate back
		Driver.driver.navigate().back();
		// navigate forward
		Driver.driver.navigate().forward();
		// refresh the page
		Driver.driver.navigate().refresh();
	} 


  

@BeforeMethod
public void setup() {
Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}

@AfterMethod
public void quitDriver() {
Driver.quitDriver();
}
}
