package TestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Utilities.TestUtil;

public class AddCustomer extends Page{

	
	@Test(dataProvider="getdata")
	public void AddCustomerDetails(String FirstName, String LastName, String pinCode)
	{
		
		driver.findElement(By.xpath(or.getProperty("FisrtName"))).sendKeys(FirstName);;
		driver.findElement(By.xpath(or.getProperty("LastName"))).sendKeys(LastName);;
		driver.findElement(By.xpath(or.getProperty("PinCode"))).sendKeys(pinCode);;
		driver.findElement(By.xpath(or.getProperty("Add"))).click();
		Alert al= driver.switchTo().alert();
		al.accept();
		
	}
	
	
	
	@DataProvider
	public static Object[][] getdata()
	{
		
		
		return TestUtil.getData("Sheet2");
		
		
	}
}
