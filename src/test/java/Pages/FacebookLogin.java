package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.DriverElements;

public class FacebookLogin extends DriverElements
{
WebDriver driver;
@FindBy(id="email")
WebElement username;
@FindBy(id="pass")
WebElement password;
@FindBy(name="login")
WebElement loginbutton;

	public FacebookLogin(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void EnterUseName(String uname)
	{
		//WebElement username =driver.findElement(By.id("email"));
		EnterintoTextbox(username,uname);
	}
	
	public void EnterPassword(String pword)
	{
		//WebElement password =driver.findElement(By.id("pass"));
		EnterintoTextbox(password,pword);
	}
	
	public void ClickOnLoginButton()
	{
		//WebElement loginbutton =driver.findElement(By.name("login"));
		ButtonClick(loginbutton);
	}
	
	public void ClickOnForgotPasswordLink()
	{
		WebElement loginbutton =driver.findElement(By.name("login"));
		ButtonClick(loginbutton);
	}
	
	public void ClickOnCreateAccount()
	{
		WebElement loginbutton =driver.findElement(By.name("login"));
		ButtonClick(loginbutton);
	}
}
