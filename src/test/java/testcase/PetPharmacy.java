package testcase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.ConsultSubscriptionPage;
import pages.ConsultVetPage;
import pages.HomePage;
import pages.Pharmacy;
import testcasebase.SetUp;
import utilities.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class PetPharmacy extends SetUp{
	HomePage hp;
	ConsultSubscriptionPage csp;
	ConsultVetPage cvp;
	Pharmacy pp;
  @Test
  public void verifyPharmacyProducts() {
	  hp = new HomePage(driver);
	  hp.pharmacyProducts();
	  pp=new Pharmacy(driver);
	  
  }
}
