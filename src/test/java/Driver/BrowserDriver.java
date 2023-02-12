package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Utils.PropertyFileHandle;

public class BrowserDriver {

	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	private String reportpath=System.getProperty("user.dir");
	public void launchTheBrowser()
	{
		String Browsername=PropertyFileHandle.propreaddata().getProperty("Browser");
		if (Browsername.equalsIgnoreCase("chrome"))
		{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-Notifications");
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		}
		else if (Browsername.equalsIgnoreCase("edge"))
		{
			EdgeOptions options = new EdgeOptions();
			options.addArguments("start-maximized");
			options.addArguments("--disable-Notifications");
			options.addArguments("--incognito");
			driver = new EdgeDriver(options);
			driver.manage().window().maximize();
		}
	}
	
	public void extenterportstart()
	{
		report = new ExtentReports(reportpath+"//report//extentreport.html",true);
		test= report.startTest("Facebook Automation report");	
	}
	
	public void extentreportclose()
	{
		report.flush();
		
	}
}
