package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Driver;

public class Day77_BoostStrap_Dropdown {
  @Test
  public void f() throws InterruptedException {
	  
	  Driver.getDriver().get("https://semantic-ui.com/modules/dropdown.html");
	  
	  Thread.sleep(2000);
	  
	 WebElement maleoption = Driver.driver.findElement(By.xpath("(//div[@class='ui selection dropdown'])[1]"));
	 maleoption.click();
	  
	 Thread.sleep(1000);
	 
	 // keep this step in mind
	 Driver.driver.findElement(By.xpath("//div[@class='menu transition visible']//div[text()='Male']")).click();
	 Thread.sleep(500);
	  
	// WebDriverWait wait = new WebDriverWait(Driver.driver, 10);
	 //wait.until(ExpectedConditions.visibilityOf(maleoption));
	 
	// maleoption.click();
	 
	  
	  
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