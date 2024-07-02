package testcase;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ReferPage;
import testcasebase.SetUp;
import utilities.ExtentReportListener;
@Listeners(ExtentReportListener.class)
public class ReferalLinkTest extends SetUp{
	HomePage hp;
	ReferPage rp;
  @Test
  public void verifyReferal() throws InterruptedException {
	  hp = new HomePage(driver);
	  hp.referal();
	  rp=new ReferPage(driver);
	  Thread.sleep(3000);
	  rp.enterEmail("sobhasoniya@gmail.com");
	  rp.enterName("sobha");
	  rp.clickReferal();
//	  String refertxt=rp.referaltextget();
//	  System.out.println(refertxt);
	  boolean res = rp.referalText();
	  assertTrue(res);
	
  }
}




