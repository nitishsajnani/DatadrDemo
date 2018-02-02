package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.Page;

public class BankManagerLoginTest extends Page {
@Test
public void doLogin()
{VisiblityWait(or.getProperty("BankLoginLink"));
	driver.findElement(By.xpath(or.getProperty("BankLoginLink"))).click();


VisiblityWait(or.getProperty("AddCustomer"));
	driver.findElement(By.xpath(or.getProperty("AddCustomer"))).click();
}
}
