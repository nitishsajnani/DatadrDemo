package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Utilities.TestUtil;

public class VerifyCustomer extends Page{

	@Test(dataProvider="getdata",groups="Low")
	public void CustomerCheck(String Person)
	{
		driver.findElement(By.xpath(or.getProperty("Customer"))).click();
		WebElement element = driver.findElement(By.xpath(or.getProperty("SearchCustomer")));
	
				
		element.sendKeys(Person);
	
		driver.findElement(By.xpath(or.getProperty("Delete"))).click();
		driver.findElement(By.xpath(or.getProperty("SearchCustomer"))).clear();
	}
	@DataProvider
	public static Object[][] getdata()
	{
		

	return TestUtil.getData("Sheet4");
}
}
