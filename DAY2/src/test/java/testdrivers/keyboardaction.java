package testdrivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class keyboardaction {
	WebDriver driver;
	@BeforeTest
	public void ConfigureBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ARCHANA DAS\\Downloads\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@Test(priority=1)
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
		driver.manage().window().maximize();
	}
	@Test
	public void Search()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement search=driver.findElement(By.id("myInput"));
		Actions act1=new Actions(driver);
		act1.keyDown(search,Keys.SHIFT).perform();
		act1.sendKeys("b").pause(1000).sendKeys("a").pause(1000).sendKeys("g").pause(1000).build().perform();
		act1.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Hand Bag')]"))).click().perform();
		driver.findElement(By.xpath("//input[value='FIND DETAILS']")).click();
		String text=driver.findElement(By.xpath("//h4[contains(text(),'Hand Bag')]")).getText();
		Assert.assertTrue(text.contains("Hand Bag"));
		
	}
	@AfterTest
	public void CloseApplication()
	{
		driver.close();
	}

}
