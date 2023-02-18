package Testcase;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;

import Commons.DriverElements;
import Driver.BrowserDriver;
import Pages.FacebookLogin;
import Pages.FacebookLogout;
import Utils.ExcelFileHandling;
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

@Test(dataProvider="GetFBusernameData",dataProviderClass=Dataproviderclasss.class)
public void FacebookLoginwithValidData(String uname,String pword) 
{
	try
	{
		FacebookLogin FL = new FacebookLogin(driver);
		FL.EnterUseName(uname);
		test.log(LogStatus.INFO, "username is: kumar.sathish189@gmail.com");
		FL.EnterPassword(pword);
	
		test.log(LogStatus.INFO, "password is: pass");
		FL.ClickOnLoginButton();
	
		test.log(LogStatus.INFO, "Login button is clicked");
		FacebookLogout FO= new FacebookLogout(driver);
		
		Assert.assertEquals(FO.GetProfileName(), "Sathish Ramakrishnan");
		String screenshot=de.takescreenshot(driver);
		test.log(LogStatus.PASS, test.addScreenCapture(screenshot));
	
	//Thread.sleep(1000);
		FO.ClickOnProfileIcon();
		FO.ClickOnLogoutButton();
	
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
