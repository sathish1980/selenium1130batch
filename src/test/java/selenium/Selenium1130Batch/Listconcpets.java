package selenium.Selenium1130Batch;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Listconcpets {
	
	WebDriver driver;
	public void listconceptimplementation(String actualcountryname,String actualcityname) throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/select.xhtml");
		driver.findElement(By.xpath("(//*[contains(@class,'ui-selectonemenu-trigger')])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		List<WebElement> allelement=driver.findElements(By.xpath("//*[@id='j_idt87:country_items']//following-sibling::li"));
		for(WebElement eachelement:allelement)
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOfAllElements(eachelement));
			//OR
			//wait.until(ExpectedConditions.textToBePresentInElement(eachelement,"Select Country"));
			String countryname=eachelement.getText();
			System.out.println(countryname);
			if (countryname.equalsIgnoreCase(actualcountryname))
			{
				eachelement.click();
				break;
			}
		}
		/// City selection
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@class,'ui-selectonemenu-trigger')])[2]")));
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//*[contains(@class,'ui-selectonemenu-trigger')])[2]")).click();
				
				List<WebElement> allelementcity=driver.findElements(By.xpath("//*[@id='j_idt87:city_items']//li"));
				for(WebElement eachelementcity:allelementcity)
				{
					//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
					wait.until(ExpectedConditions.visibilityOfAllElements(eachelementcity));
					//OR
					//wait.until(ExpectedConditions.textToBePresentInElement(eachelement,"Select Country"));
					String cityname=eachelementcity.getText();
					System.out.println(cityname);
					if (cityname.equalsIgnoreCase(actualcityname))
					{
						eachelementcity.click();
						break;
					}
				}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Listconcpets c = new Listconcpets();
		c.listconceptimplementation("USA", "New York");
	}

}
