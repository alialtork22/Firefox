package tests;

import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Driver;

public class Day77_Dropdown_Select {
  @Test
  public void f() throws InterruptedException {
	  
	  // go to facebook.com
	  Driver.getDriver().get("https://facebook.com");
	  Driver.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  //click on create account Btn
	  Driver.driver.findElement(By.cssSelector("a[data-testid=\"open-registration-form-button\"]")).click();
	  Thread.sleep(2000);
	  
	  // select by index mar from month
	  WebElement months = Driver.driver.findElement(By.id("month")); 
	  Thread.sleep(2000);
	  // create an Object select class
	  Select monthSelect = new Select(months);
	  monthSelect.selectByIndex(2);
	  
	  // select by value 12 from day
	  WebElement days = Driver.driver.findElement(By.id("day"));
	  Select daySelect = new Select(days);
	  daySelect.selectByValue("12");
	  
	  // select by visible text 2006 from years
	  WebElement years = Driver.driver.findElement(By.id("year"));
	  Select yearSelect = new Select(years);
	  yearSelect.selectByVisibleText("2006");
	  Thread.sleep(2000);
	  
	  // as you can select from dropdown also you can deselect but this function only 
	  // only suported by multiselect dropdown
	  
	  System.out.println(yearSelect.getFirstSelectedOption().getText());
	  
	  // select.getOption
	  java.util.List<WebElement> allyears = yearSelect.getOptions();
	  
	  // java
	  int counter = 0;
	  for(WebElement yearly : allyears) {
		  counter++;
		  System.out.println("Option" + counter + ": " + yearly.getText());
		  
		 //yearSelect.isMultiple();// false because you only can pick a year
		 System.out.println("is this multiple select ? : " + yearSelect.isMultiple());
	  }
	 
	  
	  
	  
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