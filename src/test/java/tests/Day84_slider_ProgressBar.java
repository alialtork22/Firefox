package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Driver;

public class Day84_slider_ProgressBar {
  @Test
  public void Slider () throws InterruptedException {
	  
	  
	  // go to https://demoqa.com/slider
	  Driver.getDriver().get("https://demoqa.com/slider");
	  Thread.sleep(2000);
	  
	  
	  // slide the slider to 69
	  int range = 69; // after you put else you can change to 10
	  
	 WebElement slider = Driver.driver.findElement(By.xpath("//input[@class='range-slider range-slider--primary']"));
	  
	  int value = Integer.parseInt(slider.getAttribute("value"));
	  if(value < range) {
		  for(int i = value; i < range;i++) {
			  slider.sendKeys(Keys.ARROW_RIGHT);
		  }
			  
	  }else {
		  for(int i = value; i < range;i++) {
			  slider.sendKeys(Keys.ARROW_LEFT);
		  }
	  }
  }
			  
  
			  @Test
			  public void Slider2 () throws InterruptedException {
				  // or
				  
				  // go to https://demoqa.com/slider
				  Driver.getDriver().get("https://demoqa.com/slider");
				  Thread.sleep(2000);
				  
				  
				  // slide the slider to 69
				  int range = 10;
				 WebElement slider = Driver.driver.findElement(By.xpath("//input[@class='range-slider range-slider--primary']"));
				  
				  int value = Integer.parseInt(slider.getAttribute("value"));
				  if(value > range) {
					  for(int i = value; i > range;i--) {
						  slider.sendKeys(Keys.ARROW_LEFT);
						  
						  
			  
			  
		  }
		  
	  }  
	  
	  
	  
	  
  }




@BeforeMethod
public void setup() {
Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@AfterMethod
public void quitDriver() {
//Driver.quitDriver();
}
}