package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Driver;

public class Day77_MultiSelect {
  @Test
  public void multiSelect() throws InterruptedException {
	  
	  Driver.getDriver().get("https://semantic-ui.com/modules/dropdown.html");
	  
	 WebElement multiSelct= Driver.driver.findElement(By.name("skills"));
	 Thread.sleep(1000);
	  
	  Select iSelect = new Select(multiSelct);
	  System.out.println("is this multi select? : " + iSelect.isMultiple());
	  Thread.sleep(1000);
  }
  
  @Test
  public void demoqa() throws InterruptedException {
	  
	  // multiSelect 
	  Driver.getDriver().get("https://demoqa.com/select-menu");
	  Thread.sleep(1000);
	  
	  WebElement cars = Driver.driver.findElement(By.id("cars"));
	  
	  Select car1 = new Select(cars);
	  System.out.println("is this multi select? : " + car1.isMultiple());
	  
	  car1.selectByVisibleText("Volvo");
	  car1.selectByVisibleText("Saab");
	  car1.selectByVisibleText("Opel");
	  car1.selectByVisibleText("Audi");
	  
	  System.out.println("First selected option : " + car1.getFirstSelectedOption().getTagName());
	  
	  
  }


@BeforeMethod
public void setup() {
Driver.getDriver().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
}

@AfterMethod
public void quitDriver() {
Driver.quitDriver();
}
}
