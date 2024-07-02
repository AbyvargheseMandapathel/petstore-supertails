package testcase;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import pages.ConsultSubscriptionPage;
import pages.ConsultVetPage;
import pages.HomePage;
import testcasebase.SetUp;
import utilities.ExtentReportListener;
import utilities.ObjectReader;

@Listeners(ExtentReportListener.class)
public class ConsultationSubscriptionTest extends SetUp{
	HomePage hp;
	ConsultSubscriptionPage csp;
	ConsultVetPage cvp;
	
	
	
  @Test
  public void verifySubscription() {
	  hp = new HomePage(driver);
	  hp.consultVet();
	  cvp= new ConsultVetPage(driver);
	  cvp.clickconsultnow();
	  csp= new ConsultSubscriptionPage(driver);
	  String rs0=csp.getPrice();
	  assertTrue(rs0.contains(ObjectReader.getAmount()));
	 
	  csp.sixMonthSubscription();
	  
	  String rs=csp.getPrice();
	  System.out.println(rs);
	  csp.yearlySubscription();
	  String rs1=csp.getPrice();
	  System.out.println(rs1);
	  assertNotEquals(rs,rs1);
  
  }
  
}
