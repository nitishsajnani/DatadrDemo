package Rough;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelReader1;

public class TestParameterization {

	
	public WebDriver driver;
	@BeforeTest
	public void BrowserLaunch()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Tester\\Desktop\\Softwares\\chromedriver.exe");

		driver = new ChromeDriver(capabilities);
		
		
		
	}
	
	
	@AfterTest
	public void BrowserQuit()
	{
		driver.quit();
		
	}
	@Test(dataProvider= "getdata")
	public void login(String username, String password)
	{driver.get("https://webmail.qainfotech.com");
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/form/table/tbody/tr[3]/td[2]/input[2]")).click();
		
		
	}
	
	@DataProvider
	public static Object[][] getdata()
	{
		
		ExcelReader1 excel= new ExcelReader1(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\TestParameteriztion.xlsx");
	
		String SheetName= "Sheet1";
	int row=	excel.getRowCount(SheetName);
		int col=excel.getColumnCount(SheetName);
		System.out.println(excel.getCellData(SheetName, 1, 2));
		
		
		System.out.println("No. of row:"+row+""+"No of col:"+""+col);
		Object[][] data= new Object[row-1][col];
		for(int rows=2;rows<=row;rows++)
		{
			
			for(int cols=0;cols<col;cols++)
				
			{
				
				data[rows-2][cols]=excel.getCellData(SheetName, cols,rows);
				
				
			}
			
		}
		
		return data;
		
	}
}
