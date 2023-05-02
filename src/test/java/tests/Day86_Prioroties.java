package tests;

import org.testng.annotations.Test;

import utils.Driver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Day86_Prioroties {
	
  @Parameters("datea1")
  @Test (priority = -1,description = "this is google test",groups = {"smokeTest"})// this is numbering and description
  public void google(String str) {
	  
	//  Driver.getDriver().get("");
	  
	  System.out.println("im going to google" + str);
  }
  
  @Test (priority = 2)// this is only numbering 
 public void etsy() {
	  
	  System.out.println("im going to etsy");
  }
  
 @Test  (priority = 30,groups = "smokeTest")
 public void facebook() {
	  Assert.fail();
	  System.out.println("im going Facebook");
  }
 
 
 @Test  (dependsOnMethods = "facebook",groups = {"smokeTest","amazonSearchTest"})     // depends on face book method if facebook pass then ammazon will be excuted
 public void amazon() {
	  
	  System.out.println("im going to amazon");
 }
 
 
  
  
  
  
  
  @BeforeTest
  public void setup() {
	  Driver.getDriver().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
  }

  @AfterTest
  public void quitDriver() {
	  Driver.quitDriver();
  }

}
