package TestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Utilities.TestUtil;

public class OpenAccount extends Page{

	
	@Test(dataProvider="getdata",groups="High")
	public void OpenAccountdetails(String Customer, String Currency)
	{
		VisiblityWait(or.getProperty("OpenAccount"));
		
		driver.findElement(By.xpath(or.getProperty("OpenAccount"))).click();
		WebElement we= driver.findElement(By.id(or.getProperty("Customerid")));
		WebElement cu=driver.findElement(By.xpath(or.getProperty("Currency")));

		
		
	
		Select se= new Select(we);
	se.selectByVisibleText(Customer);
	
	se=new Select(cu);
		se.selectByVisibleText(Currency);
		
		
		driver.findElement(By.xpath(or.getProperty("Process"))).click();
		Alert al= driver.switchTo().alert();
		al.accept();
	}

	
	@DataProvider
public static Object[][] getdata()
{
	

return TestUtil.getData("Sheet3");
}

}
