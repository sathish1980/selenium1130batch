package Testcase;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;

import Commons.DriverElements;
import Driver.BrowserDriver;
import Utils.PropertyFileHandle;

public class Facebooklogin extends BrowserDriver
{
	DriverElements de = new DriverElements();
@BeforeSuite
public void Launch()
{
	launchTheBrowser();
	extenterportstart();
}

@BeforeTest
public void EntertheURL()
{
	String URLData=PropertyFileHandle.propreaddata().getProperty("URL");
	driver.get(URLData);
	test.log(LogStatus.INFO, "The Given URL is :" + URLData);
}

@Test
public void FacebookLoginwithValidData() 
{
	try
	{
	WebElement username =driver.findElement(By.id("email"));
	de.EnterintoTextbox(username,"kumar.sathish189@gmail.com");
	test.log(LogStatus.INFO, "username is: kumar.sathish189@gmail.com");

	WebElement password =driver.findElement(By.id("pass"));
	de.EnterintoTextbox(password,"pass");
	test.log(LogStatus.INFO, "password is: pass");

	WebElement loginbutton =driver.findElement(By.name("login"));
	de.ButtonClick(loginbutton);
	test.log(LogStatus.INFO, "Login button is clicked");

	By profilename=By.xpath("//*[text()='Sathish Ramakrishnan']");
	de.Explicitwaitforpresencefelement(driver, profilename);
	String ProfileNameActual =driver.findElement(profilename).getText();
	Assert.assertEquals(ProfileNameActual, "Sathish Ramakrishnan");
	String screenshot=de.takescreenshot(driver);
	test.log(LogStatus.PASS, test.addScreenCapture(screenshot));
	WebElement logoutdropdownbutton = driver.findElement(By.xpath("//*[local-name()='svg' and @aria-label='Your profile']")); 
	de.Explicitwaitforelementobeclickable(driver, logoutdropdownbutton);
	de.ButtonClick(logoutdropdownbutton);
	//Thread.sleep(1000);
	By logoutbutton = By.xpath("//span[text()='Log Out']"); 
	de.Explicitwaitforpresencefelement(driver, logoutbutton);
	de.ButtonClick(driver.findElement(logoutbutton));
	String screenshot1=de.takescreenshot(driver);
	test.log(LogStatus.PASS, test.addScreenCapture(screenshot1));
	}
	catch(Exception e)
	{
		String screenshot1=de.takescreenshot(driver);
		test.log(LogStatus.INFO, e);
		test.log(LogStatus.FAIL, test.addScreenCapture(screenshot1));
		
	}
}
	


@AfterSuite
public void teardown() 
{
	extentreportclose();
	driver.quit();
}

}
