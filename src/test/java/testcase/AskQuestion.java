package testcase;

import java.time.Duration;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.ConsultSubscriptionPage;
import pages.ConsultVetPage;
import pages.HomePage;
import testcasebase.SetUp;
import utilities.ExtentReportListener;

@Listeners(ExtentReportListener.class)

public class AskQuestion extends SetUp {
	HomePage hp;
	ConsultSubscriptionPage csp;
	ConsultVetPage cvp;
  @Test
  public void verifyNullAskQuestion() {
	  hp = new HomePage(driver);
	  hp.consultVet();
	  cvp= new ConsultVetPage(driver);
	  cvp.clickconsultnow();
	  csp= new ConsultSubscriptionPage(driver);
	  csp.addYourReview();
	  csp.AskYourQuestion();
	  csp.submitQstn();
	  
  }
  @Test
  public void verifyAskQuestion() {
	  hp = new HomePage(driver);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  hp.consultVet();
	  cvp= new ConsultVetPage(driver);
	  cvp.clickconsultnow();
	  csp= new ConsultSubscriptionPage(driver);
	  csp.addYourReview();
	  csp.AskYourQuestion();
	  csp.enterYourname("pranav");
	  csp.enterYourmail("pranav@gmail.com");
	  csp.enterYourquestion("Is the service available in any other states except karnataka?");
	  csp.submitQstn();
	  
  }
}
