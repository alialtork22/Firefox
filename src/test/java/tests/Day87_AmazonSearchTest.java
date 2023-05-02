package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AmazonSearchPage;
import utils.Driver;

public class Day87_AmazonSearchTest {
	

	  @Test (dataProvider = "searchItems")
	  public void AmazonSearchTest(String item) {
		  AmazonSearchPage AmazonSearchpage = new AmazonSearchPage();
		  Driver.getDriver().get("https://amazon.com");
		  AmazonSearchpage.searchBox.sendKeys(item);
		  AmazonSearchpage.searchBtn.click();
		  String actualText = AmazonSearchpage.searchResaultTest.getText().substring(1, item.length()+1);
		  System.out.println(actualText + "  " + item.length());
		  Assert.assertEquals(actualText, item);
		  
		  //  "coffee mug"   coffee mug 
	  }
	  
	  @DataProvider
	  public String[] searchItems() {
		  String[] items = new String[6];
		  items[0] = "coffee mug";
		  items[1] = "pretty coffee mug";
		  items[2] = "ugly coffee mug";
		  items[3] = "funny coffee mug";
		  items[4] = "gold coffee mug";
		  items[5] = "argentina coffee mug";
		  return items;
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
