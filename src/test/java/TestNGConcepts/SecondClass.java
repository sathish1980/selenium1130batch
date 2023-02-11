package TestNGConcepts;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondClass {
	@BeforeSuite
	public void Beforesuite()
	{
		System.out.println("Beforesuite");
	}
	
	@BeforeTest
	public void BeforeTest()
	{
		System.out.println("BeforeTest");
	}
	
	@Test(priority=-1)
	public void Testcase4()
	{
		System.out.println("Testcase4");
	}
	
	@Test(priority=0)
	public void Testcase5()
	{
		System.out.println("Testcase5");
	}
	
}
