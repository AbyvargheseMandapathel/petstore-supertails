package testcase;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchResultPO;
import testcasebase.SetUp;
import utilities.ObjectReader;

public class Buy1Get1 extends SetUp{
	HomePage hp;
	SearchResultPO spo;
	
	
  @Test
  public void verifyBuy1Get1() {
	  hp = new HomePage(driver);
	  hp.search(ObjectReader.buyOneQuery());
	  spo = new SearchResultPO(driver);  
	  List<String> titles = spo.getProductTitles();
	  
	  boolean result = spo.getSearchContainsText(titles, ObjectReader.buy1Assertion());
	  
	  assertEquals(result,true);
	  
	  
  }
}
