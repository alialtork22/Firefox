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

public class Day77_Amazon_Dropdown {
  @Test
  public void f() throws InterruptedException {
	  
	  
	// go to Amazon.com
	  Driver.getDriver().get("https://amazon.com"); 
	  Thread.sleep(2000);
	  
	// get all the options in the department select Dropdown
	  WebElement departmentDrpDwn = Driver.driver.findElement(By.id("searchDropdownBox"));
	  
	  Select iSelect = new Select(departmentDrpDwn);
	  
	 java.util.List<WebElement> allDepartment = iSelect.getOptions();
	 
	 if(allDepartment.size()==59) {
		System.out.println("there are 59 departments"); 
	 }else {
		 System.out.println("there are no 59 departments" + allDepartment.size());
		 
	 }
	 
	 System.out.println();
	 
	  int counter = 0;
	  for(Object department : allDepartment) {
		  counter++;
		  System.out.println("departemnt : " + counter + ": " + ((WebElement) department).getText());
		  // OR
		  
		  // for loop only 
		//  for(Object department : allDepartment) {
			//  System.out.println(department.getText));
	//	  }
		  
	  }
	  
	 
		  
	  }
	  
	 
  @Test
  public void selectDepartments() throws InterruptedException {
	  
	  // go to amazon
	  Driver.getDriver().get("https://amazon.com"); 
	  Thread.sleep(2000);
	  
	  //verify that you are on the amazon home page. (verify with title)
	  String expectedTitle = "Amazon.com : amazon outlet stores";
	  
	  Driver.driver.getTitle();
	  if(Driver.driver.getTitle().equals(expectedTitle)) {
		  System.out.println("Title match (pass)");
	  }else {
		  System.out.println("Title not match (Fail)");
	  }
	  
	  // verify dropdown value is by default "All Departments" 
	  WebElement departmentDrpDwn = Driver.driver.findElement(By.id("searchDropdownBox"));
	  Select iSelect = new Select(departmentDrpDwn);
	  if(iSelect.getFirstSelectedOption().getText().equals("All Departments")) {
		 System.out.println("defaul drpdown verified");
		 
	  }else {
		  System.out.println("default dropdown not currect");
	  }
	  
	  // select department home$ kitchen, and search coffee mug
	  iSelect.selectByVisibleText("Home & Kitchen");
	  Driver.driver.findElement(By.id("twotabsearchtextbox")).sendKeys("coffee mug");
	  Driver.driver.findElement(By.id("nav-search-submit-button")).click();
	  
	  // verify you are on Coffee mug search result page(use title)
	  Driver.driver.getTitle();
	  
	  String VerifyCoffeeMug = "Amazon.com : coffe mug";
	  
	  if(Driver.driver.getTitle().equals(VerifyCoffeeMug)) {
		  System.out.println(" Coffee mug Title match (pass)");
	  }else {
		  System.out.println("Coffee mug Title not match (Fail)");
		  
		  // verify you are in home & Kitchen department
		  String homekitchenText = Driver.driver.findElement(By.xpath("//span[@class='a-list-item']//span[text()='Home & Kitchen']")).getText().trim();
		  
		  if(homekitchenText.equals("Home & Kitchen")) {
			  System.out.println("home and Kitchen text page verified");
		  }else {
			  System.out.println("home and Kitchen text page not found");
		  }
	  }
	  
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