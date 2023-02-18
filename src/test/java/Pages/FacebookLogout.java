package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.DriverElements;

public class FacebookLogout extends DriverElements
{
	WebDriver driver;
	@FindBy(xpath="//*[local-name()='svg' and @aria-label='Your profile']")
	WebElement logoutdropdownbutton;
	
	final String profileElement="//*[text()='Sathish Ramakrishnan']";
	final String LogoutDropdown="//span[text()='Log Out']";
	
	public FacebookLogout(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String GetProfileName()
	{
		By profilename=By.xpath(profileElement);
		Explicitwaitforpresencefelement(driver, profilename);
		String ProfileNameActual =driver.findElement(profilename).getText();
		return ProfileNameActual;
	}
	
	public void ClickOnProfileIcon()
	{
		//WebElement logoutdropdownbutton = driver.findElement(By.xpath("//*[local-name()='svg' and @aria-label='Your profile']")); 
		Explicitwaitforelementobeclickable(driver, logoutdropdownbutton);
		ButtonClick(logoutdropdownbutton);
	}
	
	public void ClickOnLogoutButton()
	{
		//By logoutbutton = By.xpath("//span[text()='Log Out']"); 
		By logoutbutton = By.xpath(LogoutDropdown); 
		Explicitwaitforpresencefelement(driver, logoutbutton);
		ButtonClick(driver.findElement(logoutbutton));
	}
}
