package testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.SearchResultPO;
import testcasebase.SetUp;
import utilities.ObjectReader;

public class RemoveCartTest extends SetUp{
	AddToCartTest addToCartTest;
	HomePage hp;
	SearchResultPO spo;
	CheckOutPage cop;
	
  @Test
  public void verifyRemoveCart() throws InterruptedException {
	  hp = new HomePage(driver);
	  hp.search(ObjectReader.searchQuery());
	  spo = new SearchResultPO(driver);
	  spo.addtocart();
	  spo.clickCartButton();
	  cop = new CheckOutPage(driver);
	  System.out.println("reached checkout");
	  cop.clickCartButton();
	  boolean result = cop.removeCart();
	  System.out.println(result);
	  assertTrue(result);
	  Thread.sleep(5000);	
  }
  
  @Test
  public void removeFromEmptyCart() {
	  cop = new CheckOutPage(driver);
	  cop.clickCartButton();
	  String text = cop.emptyText();
	  assertEquals(text,ObjectReader.emptyCartMsg());
	  
  }
}
