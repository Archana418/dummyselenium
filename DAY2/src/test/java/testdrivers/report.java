package testdrivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class report 
{
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeTest
	public void startReport()
	{
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user-dir")+"/test-output/myreport.html");
		htmlReporter.config().setDocumentTitle("Tiltle of report");
		htmlReporter.config().setReportName("Report namecome here");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("os", "Windows");
		extent.setSystemInfo("host", "localhost");
		extent.setSystemInfo("browser", "Chrome");
		extent.setSystemInfo("tester", "Archana");
	}
	@BeforeMethod
	public void ConfigureBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ARCHANA DAS\\Downloads\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	}
	@Test(priority = 1)
	public void LogInTitle()
	{
		logger=extent.createTest("LogInTitle");
		driver.findElement(By.xpath("//a[contains(text(),'SignIn')]")).click();
		String actuallogo="Login";
		String expectedlogo = driver.findElement(By.id("demo1")).getText();
		Assert.assertEquals(actuallogo, expectedlogo);
		
	}
	@Test(priority=2)
	public void LogIn()
	{
		logger=extent.createTest("LogIn");
		driver.findElement(By.id("userName")).sendKeys("Lalitha");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'SignOut')]")).click();
		Assert.assertTrue(true);
	}
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus()== ITestResult.FAILURE)
		{
			logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+ "-The test case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable() + "-The Test Case Faileed",ExtentColor.RED));
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.log(Status.PASS,MarkupHelper.createLabel(result.getName()+"- The test case PASSES ",ExtentColor.GREEN));
			
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+"-The test is SKKIPED", ExtentColor.ORANGE));
		}
	}
	@AfterTest
	public void endReport()
	{
		extent.flush();
	}
	
}
	