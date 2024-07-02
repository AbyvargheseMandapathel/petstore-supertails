package testcase;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchResultPO;
import testcasebase.SetUp;
import utilities.ExtentReportListener;
import utilities.ObjectReader;

@Listeners(ExtentReportListener.class)

public class SearchTest extends SetUp{
	
	HomePage hp;
	SearchResultPO spo;
	
  @Test(priority=1)
  public void validSearch() throws InterruptedException {
	  hp = new HomePage(driver);
	  hp.search(ObjectReader.searchQuery());
	  spo = new SearchResultPO(driver);
	  Thread.sleep(5000);
	  
	  assertTrue(ru.isElementDisplayed(spo.getSearchresultresult()));
	  
  }
  
//test method to validate search function with invalid text
  @Test(priority=2)
  public void invalidSearch() {
	  hp = new HomePage(driver);
	  hp.search(ObjectReader.getInvalidQuery());
	  spo = new SearchResultPO(driver);
	  
	  assertTrue(ru.isElementDisplayed(spo.searchresultinresult));
  }
}
