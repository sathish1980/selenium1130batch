package Testcase;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utils.ExcelFileHandling;

public class Dataproviderclasss {

	@DataProvider
	public Object[][] GetFBusernameData() throws IOException
	{
		ExcelFileHandling E = new ExcelFileHandling();
		return E.ExcelReaddata("Testdata.xls","FBUsername");
	}
}
