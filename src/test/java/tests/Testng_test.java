package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Driver;

public class Testng_test {
  @Test
  public void f() throws InterruptedException {
	  
	  
	  Driver.getDriver().get("https://demoqa.com/radio-button");
	  
	  
		
		//verify yes button is selected or not 
		 WebElement yesRadioBtn = Driver.driver.findElement(By.xpath("//label[@for='yesRadio']"));
		if(yesRadioBtn.isDisplayed()) {
			if(yesRadioBtn.isSelected()) {
				// if not click
				yesRadioBtn.click();
			}else {
				System.out.println("its already selected");
			}
			}else {
				System.out.println("The radio button is not Displayed");
				
			}
		Thread.sleep(1000);
		
		// verify the message " you have selected" display
		String yesText = Driver.driver.findElement(By.xpath("//p[contains(text(),'You have selected')]")).getText().trim();
		
		System.out.println("yestext : " + yesText);
		
		if(yesText.equals("You have selected")) {
			System.out.println("Test pass");
		}else {
			System.out.println("Test fail");
			
			
			}

	  

  }
 
  
@BeforeMethod
  public void setup() {
  Driver.getDriver().manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void quitDriver() {
  Driver.quitDriver();
  }
}

