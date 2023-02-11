package TestNGConcepts;

import org.testng.annotations.*;

public class Fristclass {
	
	@AfterMethod
	public void AfterMethod()
	{
		System.out.println("AfterMethod");
	}
	
	
	@BeforeClass
	public void BeforeClass()
	{
		System.out.println("BeforeClass");
	}
	
	@BeforeMethod
	public void BeforeMethod()
	{
		System.out.println("BeforeMethod");
	}
	
	@Test(priority=-1,groups="SIT")
	public void Testcase2()
	{
		System.out.println("Testcase2");
	}
	
	@Test(priority=0,groups="Sanity")
	public void Testcase1()
	{
		System.out.println("Testcase1");
	}
	
	@Test(priority=1,groups= {"Sanity","SIT"},description ="sampledata",enabled=true,timeOut=60,invocationCount=5,invocationTimeOut=60)
	public void Testcase3()
	{
		System.out.println("Testcase3");
	}
	
	
	@AfterClass
	public void AfterClass()
	{
		System.out.println("AfterClass");
	}
	
	@AfterTest
	public void AfterTest()
	{
		System.out.println("AfterTest");
	}
	
	@AfterSuite
	public void Aftersuite()
	{
		System.out.println("Aftersuite");
	}

}
