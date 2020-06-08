package testdrivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class wait {
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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("userName")).sendKeys("Lalitha");
		driver.findElement(By.id("password")).sendKeys("Password123");
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='Login']")));
	
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		String url=driver.getCurrentUrl();
		System.out.println("URL:"+url);

	}
	@AfterTest
	public void CloseApplication()
	{
		driver.close();
	}


}
