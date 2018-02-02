package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Utilities.ExcelReader1;

public class Page {

	/*Excel
	 * DB connection
	 * browser
	 * logs
	 * Properties
	 * 
	 *  
	 *  
	 *  
	 *  */
	
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties or= new Properties();
	public static Logger log= Logger.getLogger("devpinoylogger");
	public static FileInputStream fis;
	public static ExcelReader1 excel=new ExcelReader1(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\TestParameteriztion.xlsx");
	
	
	@BeforeSuite
	public void setup() throws FileNotFoundException
	{
		
		if(driver==null)
		{
			
			fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\Config.properties");
			try {
				config.load(fis);
				log.debug("config properties loaded");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\OR.properties");
			try {
				or.load(fis);
				log.debug("OR properties loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(config.getProperty("Browser").equalsIgnoreCase("Chrome"))
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

			driver = new ChromeDriver(capabilities);}
			
			else
				
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

				driver = new ChromeDriver(capabilities);}
			
				driver.get(config.getProperty("TestURL"));
		driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.MILLISECONDS);
		
		}
	}
	public static void VisiblityWait(String Element)
	{
		WebDriverWait wait= new WebDriverWait(driver,5);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Element)));
	}
	
	@AfterSuite
	public void teardown()
	{
		
		//driver.quit();
	}
}
