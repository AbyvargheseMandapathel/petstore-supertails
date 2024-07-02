package testcasebase;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import base.Reusable;
import pages.ConsultSubscriptionPage;
import pages.ConsultVetPage;
import pages.HomePage;
import testcase.PinCodeTest;
import utilities.ObjectReader;


public class SetUp {
	
	
    
    protected WebDriver driver;
    Properties prop;
    ObjectReader or;
    protected Reusable ru;    
    PinCodeTest pct;
    HomePage hp;
    ConsultSubscriptionPage csp;
    ConsultVetPage cvp;
    
    
    @BeforeTest
    public void setUp() throws IOException {
        prop = new Properties();
        or = new ObjectReader();
        ru = new Reusable();
       
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeClass
    public void beforeclass() {
        driver = Reusable.invokeBrowser(ObjectReader.readObjects().getProperty("driver"));
        driver.get(ObjectReader.readObjects().getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        hp = new HomePage(driver); 
        
    }


}

