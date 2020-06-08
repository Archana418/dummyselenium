package testdrivers;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class locators {
	
	WebDriver driver;
	
	@BeforeTest
	public void configureBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ARCHANA DAS\\Downloads\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@Test(priority = 1)
	public void OpenApplication()
	{
		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	}
	@Test(priority = 2)
	public void LogIn()
	{
		driver.findElement(By.xpath("//a[contains(text(),'SignIn')]")).click();
		String actuallogo="Login";
		String expectedlogo = driver.findElement(By.id("demo1")).getText();
		Assert.assertEquals(actuallogo, expectedlogo);
		driver.findElement(By.id("userName")).sendKeys("Lalitha");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'SignOut')]")).click();
	}
	@AfterTest
	public void CloseApplication()
	{
		driver.close();
	}
	
	

}
