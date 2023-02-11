package selenium.Selenium1130Batch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Firstclass {
	
	public void firsttestcase() 
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://www.facebook.com/");
		//WebElement username=browser.findElement(By.id("email"));
		WebElement username=browser.findElement(By.name("email"));
		//WebElement username=browser.findElement(By.className("inputtext _55r1 _6luy"));
		
		username.sendKeys("sarhish");
		username.clear();
		username.sendKeys("kumar");
		username.sendKeys("new value");
		//browser.findElement(By.linkText("Forgotten password?")).click();
		browser.findElement(By.partialLinkText("assword?")).click();
		/*browser.navigate().to("https://www.gmail.com/");
		browser.navigate().back();
		browser.navigate().forward();
		browser.navigate().refresh();*/
		//browser.quit();
		//browser.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Firstclass f = new Firstclass();
		f.firsttestcase();
	}

}
