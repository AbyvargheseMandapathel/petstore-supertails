package testcase;

import static org.testng.Assert.assertEquals;

import java.util.List;

import javax.naming.directory.SearchResult;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchResultPO;
import testcasebase.SetUp;
import utilities.ExtentReportListener;
import utilities.ObjectReader;


@Listeners(ExtentReportListener.class)
public class FilterTest extends SetUp {
	HomePage hp;
	SearchResultPO spo;
	
  @Test
  public void filterItemsByKeyword() {
	  hp = new HomePage(driver);
	  hp.search(ObjectReader.searchQuery());
	  spo = new SearchResultPO(driver);
	  
	  List<String> titles = spo.getProductTitles();
      
      boolean result = spo.getSearchContainsText(titles,ObjectReader.searchQuery());
	  assertEquals(result,true);
  }
  
  @Test
  public void filterItemsByBrand() throws InterruptedException {
	  hp = new HomePage(driver);
	  hp.search(ObjectReader.searchQuery());
	  spo = new SearchResultPO(driver);
	  
	  
	  
	  boolean result = spo.getBrandFilterNameContains();
	  System.out.println(result);
	  
	  assertEquals(result,true);
      
  }
}
