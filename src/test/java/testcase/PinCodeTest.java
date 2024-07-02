package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.HomePage;
import testcasebase.SetUp;
import utilities.ObjectReader;



public class PinCodeTest extends SetUp {
    HomePage hp;


    @Test
    public void pinCodeVerify() throws InterruptedException {
        hp = new HomePage(driver);
        Thread.sleep(8000);
        hp.deli(ObjectReader.getPinCode());
//        "₹299"
        Thread.sleep(8000);



    }

}
