package testcase;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.SearchResultPO;
import testcasebase.SetUp;
import utilities.ExtentReportListener;
import utilities.ObjectReader;


@Listeners(ExtentReportListener.class)
public class AddToCartTest extends SetUp{
	HomePage hp;
	SearchResultPO spo;
	SearchTest st;
	CheckOutPage cop;
	
  @Test
  public void verifyAddToCart() throws InterruptedException {
	  hp = new HomePage(driver);
	  hp.search(ObjectReader.searchQuery());
	  spo = new SearchResultPO(driver);
	  spo.addtocart();
	  spo.clickCartButton();
	  cop = new CheckOutPage(driver);
	  
	  assertTrue(ru.isElementDisplayed(cop.carticon));  
  }
  
}
