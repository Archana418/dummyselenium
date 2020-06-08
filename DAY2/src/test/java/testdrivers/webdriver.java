package testdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class webdriver {
	WebDriver driver;
	
	@BeforeTest
	public void configureBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ARCHANA DAS\\Downloads\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@Test
	public void openApplication()
	{
		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	}
	@AfterTest
	public void closeApplication() 
	{
		driver.close();
	}
	
}
