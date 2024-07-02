package testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.TrackLocation;
import pages.TrackResult;
import testcasebase.SetUp;
import utilities.ExtentReportListener;
import utilities.ObjectReader;

@Listeners(ExtentReportListener.class)

public class TrackOrder  extends SetUp{
	HomePage hp;
	TrackLocation tl;
	TrackResult tr;

@Test(priority=1)
  public void trackOrderVerifyValid() throws InterruptedException {
	hp = new HomePage(driver);
	hp.tracklocation();
	tl =new TrackLocation(driver);
	tl.enterOrderId(ObjectReader.getTrackingId());
	tr= new TrackResult(driver);
	assertTrue(ru.isElementDisplayed(tr.trackresult));
  }


@Test(priority=2)
public void trackOrderVerifyInvalid() throws InterruptedException {
	hp = new HomePage(driver);
	driver.get("https://supertails.com/");
	hp.tracklocation();
	tl =new TrackLocation(driver);
	tl.enterOrderId("as12345623453");
	tr= new TrackResult(driver);
//	assertTrue(ru.isPresent(tl.trackresultinvalid));
	assertEquals(ru.textPresent(tl.trackresultinvalid),ObjectReader.getInvalidResultMsg());
}

}
