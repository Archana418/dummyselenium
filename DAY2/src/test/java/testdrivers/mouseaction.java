package testdrivers;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class mouseaction {
	WebDriver driver;
	@BeforeTest
	public void ConfigureBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ARCHANA DAS\\Downloads\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@Test(priority = 1)
	public void OpenApplication()
	{
		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	}
	
	@Test(priority=2)
	public void LogIn()
	{
		driver.findElement(By.xpath("//a[contains(text(),'SignIn')]")).click();
		driver.findElement(By.id("userName")).sendKeys("Lalitha");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
	}
	@Test(priority = 3)
	public void AboutUs()
	{
		Actions act1= new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'AboutUs')]"))).moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Our')]"))).moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Chennai')]"))).click().build().perform();
		Assert.assertTrue(driver.getCurrentUrl().contains("chn"));
	}
	@AfterTest
	public void CloseApplication()
	{
		driver.quit();
	}

}
