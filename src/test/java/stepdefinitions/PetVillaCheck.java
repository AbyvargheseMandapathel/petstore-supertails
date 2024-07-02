package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import pages.StayVistaBDD;

public class PetVillaCheck {
	
	WebDriver driver = Hooks.driver;
	Properties properties = Hooks.properties;
	HomePage hp;
	StayVistaBDD stb;
	
	
	@Given("user is on the homepage")
	public void user_is_on_the_homepage() {
		driver.get(properties.getProperty("url"));
		}
	@Given("user clicks on the pet villas")
	public void user_clicks_on_the_pet_villas() {
		hp = new HomePage(driver);
        hp.clickpetvilla();
	    	}
	@Then("validate if the new page is the page dedicated for pet villas")
	public void validate_if_the_new_page_is_the_page_dedicated_for_pet_villas() {
		stb=new StayVistaBDD(driver);
		assertEquals(stb.checktitle(),"Supertails' Pet Villas");
		
	    	}
}
