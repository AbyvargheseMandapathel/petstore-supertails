package testcase;

import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.PaymentMethod;
import pages.SearchResultPO;
import pages.ShippingPage;
import testcasebase.SetUp;
import utilities.ObjectReader;

public class CODTest extends SetUp{
	HomePage hp;
	SearchResultPO spo;
	CheckOutPage cop;
	ShippingPage sp;
	PaymentMethod pm;
	

	
  @Test(priority=1)
  public void verifyCodBelow700() throws InterruptedException {
	  hp = new HomePage(driver);
	  hp.search(ObjectReader.searchQuery());
	  
	  spo = new SearchResultPO(driver);
	  spo.clickDropDown();
	  spo.selectDropDownLowest();
	  spo.addtocart();	  
	  spo.clickCartButton();
	  
	  cop = new CheckOutPage(driver);	  
	  cop.clickCheckOut();
	  
	  sp= new ShippingPage(driver);
	  sp.fillContactEmail(ObjectReader.contactEmail());
	  sp.fillShippingAddress("686543","8921771610","amal","jose","Trivandrum","TVM","KL","India");
	  sp.clickContinue();
	  
	  pm = new PaymentMethod(driver);
//	  assertFalse(pm.isCodPresent());
//	  Thread.sleep(13000); 
  }
  
  @Test(priority=2)
  public void verifyAbove5000() throws InterruptedException {
	  hp = new HomePage(driver);
	  hp.search(ObjectReader.searchQuery());
	  
	  spo = new SearchResultPO(driver);
	  spo.clickDropDown();
	  spo.selectDropDownHighest();
	  spo.addtocart();	  
	  spo.clickCartButton();
	  
	  cop = new CheckOutPage(driver);	  
	  cop.clickCheckOut();
	  
	  sp= new ShippingPage(driver);
	  sp.fillContactEmail(ObjectReader.contactEmail());
	  sp.fillShippingAddress("686543","8921771610","amal","jose","Trivandrum","TVM","KL","India");
	  sp.clickContinue();
	  
	  pm = new PaymentMethod(driver);
//	  assertFalse(pm.isCodPresent());
//	  Thread.sleep(13000);
	  
  }
  
  @Test
  public void verifyCod() {
	  hp = new HomePage(driver);
	  hp.search(ObjectReader.searchQuery());
	  
	  spo = new SearchResultPO(driver);
	  
  }
  
}
