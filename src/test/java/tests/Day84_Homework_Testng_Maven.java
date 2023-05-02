package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Driver;

public class Day84_Homework_Testng_Maven {
	
	// this still im gonna act like i dont have maven so im gonna write extra codes just to know what the different when i have maven
	
	
	WebDriver driver; // acting we dont have maven so we are required to put instance variables
	WebDriverWait wait;
	
	public void setup() {
		
	//  BeforeMethod      because we have inherted class and maven can work if active
		  // acting we dont have inherited class and no maven 
		  driver = new ChromeDriver();
		  wait = new WebDriverWait(driver,10);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	 // Taste case 1
	// go to  https://saucedemo.com
	// log in with valid username = standerd_user  password = secret_sauce
	//verify that you are logged in successfully 
	
  @Test           // here without maven we will not have Run| Debug just we will have @Teste
  public void testCase1 () throws InterruptedException {
	 
	  Driver.getDriver().get("https://saucedemo.com");
	  Driver.driver.findElement(By.id("user-name")).sendKeys("standard_user");
	  Driver.driver.findElement(By.id("password")).sendKeys("secret_sauce");
	  // click login
	  Driver.driver.findElement(By.id("login-button")).click();
	  Thread.sleep(2000);
	  
	  // verifying we are on the login page
	 boolean prodectText =  Driver.driver.findElement(By.id("react-burger-menu-btn")).isDisplayed();// is displayed return something back ton us so we have to catch
	  // we catch by put it in a contaner
	  
	 Assert.assertTrue(prodectText);// if this line is true the next print line will be exuted
	 System.out.println("im logged in");
  }
  
  @Test
  public void testCase2 () throws InterruptedException { // wrong user to go through
	  
	  Driver.getDriver().get("https://saucedemo.com");
	  Driver.driver.findElement(By.id("user-name")).sendKeys("_user");
	  Driver.driver.findElement(By.id("password")).sendKeys("secret_sauce");
	  // click login
	  Driver.driver.findElement(By.id("login-button")).click();
	  Thread.sleep(2000);
	  
	  // verifying we are on the login ((((login button)
	 boolean loginBtn =  Driver.driver.findElement(By.id("login-button")).isDisplayed();// is displayed return something back ton us so we have to catch
	  // we catch by put it in a contaner
	  Thread.sleep(2000);
	 Assert.assertTrue(loginBtn);// if this line is true the next print line will be exuted
	 System.out.println("im not logged in");
	 
	 String acualErrorMessge = Driver.driver.findElement(By.xpath("//h3[@data-test='error']")).getText().trim();
	 
	 Assert.assertEquals(acualErrorMessge, "Epic sadface: Username and password do not match any user in this service");
	 System.out.println("Error mesage is there");
	 
  }
 // AfterMethod
  public void setupAfterMethod() {
	  
	  Driver.driver.close();
  }
}
