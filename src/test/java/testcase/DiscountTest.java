package testcase;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import pages.HomePage;
import pages.SearchResultPO;
import testcasebase.SetUp;
import utilities.ExtentReportListener;
import utilities.ObjectReader;
@Listeners(ExtentReportListener.class)
public class DiscountTest extends SetUp{
	HomePage hp;
	SearchResultPO spo;
	SearchTest st;
	CheckOutPage cop;
	
	@Test
	public void verifyDiscountAmount() throws InterruptedException {
		hp = new HomePage(driver);
		  hp.search("wet food");
		  spo = new SearchResultPO(driver);
		  spo.addtocart();
		  spo.clickCartButton();
		  cop = new CheckOutPage(driver);
		  String before=cop.totalPrice();
		  System.out.println(before);
		  cop.clickApplyCoupon();
		  cop.enterCouponCode(ObjectReader.getCoupon());
		  cop.clickApply();
		  Thread.sleep(3000);
		  String After=cop.totalPrice();
		  System.out.println(After);
	}
	
}