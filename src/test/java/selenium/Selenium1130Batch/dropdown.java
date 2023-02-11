package selenium.Selenium1130Batch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown {
	WebDriver driver;
	
	public void mutiselect() throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		Select products= new Select(driver.findElement(By.cssSelector("select#first")));
		products.selectByVisibleText("Google");
		Select animals= new Select(driver.findElement(By.cssSelector("select#animals")));
		animals.selectByIndex(2);
		Select multidropdown= new Select(driver.findElement(By.xpath("(//*[@id='second'])[2]")));
		System.out.println(multidropdown.isMultiple());
		//drodpwon.selectByIndex(4);
		if(multidropdown.isMultiple())
		{
			multidropdown.selectByIndex(1);
			multidropdown.selectByValue("bonda");
			multidropdown.selectByVisibleText("Pizza");
			Thread.sleep(1000);
			multidropdown.deselectByValue("pizza");
			Thread.sleep(1000);
			multidropdown.deselectByVisibleText("Donut");
			Thread.sleep(1000);
			multidropdown.deselectAll();

		}
	
		
	}

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		dropdown d = new dropdown();
		d.mutiselect();
	}

}
