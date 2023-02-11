package selenium.Selenium1130Batch;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTable {

	WebDriver driver;
	String indentify="notdone";
	public void tableconcept(String expectedcountry) throws InterruptedException
	{
		
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		JavascriptExecutor js= (JavascriptExecutor)driver;
		driver.manage().window().maximize();
		driver.get("https://leafground.com/table.xhtml");
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='ui-paginator-pages']//a")));

		List<WebElement> PaginationRow=driver.findElements(By.xpath("//*[@class='ui-paginator-pages']//a"));
		for (int j=1;j<=PaginationRow.size();j++)
		{
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		driver.findElement(By.xpath("//*[@class='ui-paginator-pages']//a["+j+"]")).click();
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='ui-datatable-scrollable-body']//table//tbody//tr[1]//td[2]")));
		List<WebElement> TotalRows= driver.findElements(By.xpath("//*[@class='ui-datatable-scrollable-body']//table//tbody//tr"));
		for (int i=1;i<=TotalRows.size();i++)
		{
			WebElement eachelement=driver.findElement(By.xpath("//*[@class='ui-datatable-scrollable-body']//table//tbody//tr["+i+"]//td[2]//span[3]"));
			js.executeScript("arguments[0].scrollIntoView();", eachelement);
			
			//wait.until(ExpectedConditions.visibilityOf(eachelement));
			String actualcountry=driver.findElement(By.xpath("//*[@class='ui-datatable-scrollable-body']//table//tbody//tr["+i+"]//td[2]//span[3]")).getText();
			//System.out.println(actualcountry);
			if(expectedcountry.equalsIgnoreCase(actualcountry))
			{
				String Name=driver.findElement(By.xpath("//*[@class='ui-datatable-scrollable-body']//table//tbody//tr["+i+"]//td[1]")).getText();
				String Represntative=driver.findElement(By.xpath("//*[@class='ui-datatable-scrollable-body']//table//tbody//tr["+i+"]//td[3]//span[2]")).getText();
				String JoiningDate=driver.findElement(By.xpath("//*[@class='ui-datatable-scrollable-body']//table//tbody//tr["+i+"]//td[4]")).getText();
				String Status=driver.findElement(By.xpath("//*[@class='ui-datatable-scrollable-body']//table//tbody//tr["+i+"]//td[5]//span[2]")).getText();
				System.out.println(Name);
				System.out.println(Represntative);
				System.out.println(JoiningDate);
				System.out.println(Status);
				//indentify="done";
				//break;
			}
		}
		if(indentify=="done")
		{
			break;
		}
	}
}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebTable w = new WebTable();
		w.tableconcept("India");
	}

}
