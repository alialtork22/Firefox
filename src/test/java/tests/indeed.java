package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import utils.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class indeed {
  @Test
  public void f() throws InterruptedException {
	  
	  Driver.getDriver().get("https://indeed.com");
	
		// search SDET
		Driver.driver.findElement(By.id("text-input-what")).sendKeys("SDET");
		Driver.driver.findElement(By.xpath("//button[@type='submit']"));
		
		Thread.sleep(2000);
		
		//verify that there are 15 jobs in first page
		// we are trying here to find multiple boxes of jobs (list of elements)
		List <WebElement> jobs = Driver.driver.findElements(By.cssSelector(".jobsearch-ResultsList css-0"));
		
		if(jobs.size() == 15) {
			System.out.println("Test pass");
		}else {
			System.out.println("Test fail");
		}
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



  
