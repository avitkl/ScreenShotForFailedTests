package screenShotListener;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static WebDriver driver;
	
	public static void intialization()
	{
		System.setProperty("webdriver.chrome.driver","F:\\SeleniumDrivers\\chromedriver.exe");
 		driver=new ChromeDriver();
 		driver.manage().window().maximize();
 		driver.manage().deleteAllCookies();
 		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
 		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 		driver.get("http://www.google.com");
	}
	
	public void failed(String testMethodName)
	{
		File scrFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileUtils.copyFile(scrFile, new File("F:\\JavaSeleniumFramework\\ScreenShotForFailedTests\\ScreenShotsForFailedTests\\"+testMethodName+".jpg"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
}
