package testcase;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.ConsultSubscriptionPage;
import pages.ConsultVetPage;
import pages.HomePage;
import testcasebase.SetUp;
import utilities.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class ReviewTest extends SetUp{
	
	HomePage hp;
	ConsultSubscriptionPage csp;
	ConsultVetPage cvp;
	
	
	  @Test public void verifyValidReviw() throws InterruptedException { hp = new
	  HomePage(driver); 
	  hp.consultVet(); 
	  Thread.sleep(5000);
	  cvp= new ConsultVetPage(driver);
	  cvp.clickconsultnow(); 
	  csp=new ConsultSubscriptionPage(driver);
	  Thread.sleep(2000);
	  csp.addYourReview(); Thread.sleep(3000);
	  
	  csp.WriteYourReview(); 
	  //Thread.sleep(4000); 
	  csp.enterName("Pranav"+Keys.TAB);
	  //Thread.sleep(2000);
	  csp.enterMailId("pranav@gmail.com");
	  //Thread.sleep(2000);
	  csp.starRating(); 
	  csp.enterReviewTitle("good"); 
	  csp. enterReviewContent("The doctors are knowledgeable, compassionate, and really take the time to listen to my concerns."); 
	  Thread.sleep(3000); 
	   csp.submitReview();
	   Thread.sleep(4500);
	  
	  
	  }
	 
  @Test
  public void verifyInValidReviw() throws InterruptedException {
	  hp = new HomePage(driver);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	  hp.consultVet();
	  cvp= new ConsultVetPage(driver);
	  cvp.clickconsultnow();
	  csp=new ConsultSubscriptionPage(driver);
	  
	  csp.addYourReview();
	 Thread.sleep(2000);
	  csp.WriteYourReview();
	  Thread.sleep(2000);
	  csp.submitReview();
		/*
		 * Thread.sleep(2000); Boolean err=csp.errorMessage(); assertEquals(err,true);
		 */
	 
	  }
}
