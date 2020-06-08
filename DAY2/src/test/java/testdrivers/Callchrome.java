package testdrivers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.Utility;

public class Callchrome {
WebDriver driver;
	
	@BeforeTest
	public void configureBrowser()
	{
		driver=Utility.getDriver("chrome");
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
