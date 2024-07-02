package testcase;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetail;
import pages.SearchResultPO;
import testcasebase.SetUp;
import utilities.ObjectReader;

public class HashTagSearch extends SetUp{
	HomePage hp;
	SearchResultPO spo;
	ProductDetail pd;
	
  @Test
  public void searchHashTag() throws InterruptedException {
	  hp = new HomePage(driver);
	  hp.search(ObjectReader.searchQuery());
	  
	  spo = new SearchResultPO(driver);
	  spo.clickFirstProduct();
	  
	  pd = new ProductDetail(driver);
	  String text = pd.hashTagText();
	  pd.clickKeyword();
	  
	  spo = new SearchResultPO(driver);
	  spo.getSearchresultresult();
	  
	  assertTrue(spo.contains(text));
//	  pd.searchKeyWord();
	  
	  Thread.sleep(3000);
	  
  }
}
