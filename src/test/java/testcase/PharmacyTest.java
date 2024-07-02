package testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.Pharmacy;
import testcasebase.SetUp;
import utilities.ObjectReader;

public class PharmacyTest extends SetUp {
	
	HomePage hp;
	//Pharmacy py;
	
	@Test(priority=1)
	public void pharmacyValidate() {
		hp = new HomePage(driver);
		System.out.println(ru.gettheUrl());	
		hp.pharmacyProducts();
		System.out.println(ru.gettheUrl());	
		assertTrue(ru.gettheUrl().contains(ObjectReader.getPharmacyValidate()));		

	}

}
