package testcase;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utilities.ExcelReader;

public class DataProviderSearch {

  @DataProvider(name = "validSearch")
	public Object[][] readDataValid () throws IOException {
//		System.out.println(System.getProperty("user.dir"));
		return ExcelReader.locate(System.getProperty("user.dir")+"\\src\\test\\resources\\datasource\\data.xlsx", "search_valid");
	}
  
  @DataProvider(name = "invalidSearch")
	public Object[][] readDataInvalid () throws IOException {
//		System.out.println(System.getProperty("user.dir"));
		return ExcelReader.locate(System.getProperty("user.dir")+"\\src\\test\\resources\\datasource\\data.xlsx", "search_invalid");
	}
  
  
  }
