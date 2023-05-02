package tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.Driver;
import utils.ExcelUtils;

@Test
public class Day87_AmazonSearchWithExcel {

	@Test(dataProvider = "searchData") // we linked with the down method searchData
	public void amazonSearchWithExcel(Object obj) {
		System.out.println(obj);
	}

	@DataProvider
	public Object[] searchData() {
		
		Object [] obj = ExcelUtils.getExcelDataInAColumn("./src/test/resources/testData/amazonTestData.xlsx", "departments");
		
		
		return obj; 
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