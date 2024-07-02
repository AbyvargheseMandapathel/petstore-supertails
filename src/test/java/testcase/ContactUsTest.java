package testcase;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;
import testcasebase.SetUp;
import utilities.ExtentReportListener;
import utilities.ObjectReader;

@Listeners(ExtentReportListener.class)
public class ContactUsTest extends SetUp{
	HomePage hp;
	ContactUsPage cup;
	
	
	
  @Test
  public void verifyContactUs() throws InterruptedException {
	  hp = new HomePage(driver);
	  hp.contactusnav();
	  cup = new ContactUsPage(driver);
	  assertEquals(ru.textPresent(cup.getPhone()),ObjectReader.getPhone());  
	  assertEquals(ru.textPresent(cup.getEmail()),ObjectReader.getEmail());
  }
}
