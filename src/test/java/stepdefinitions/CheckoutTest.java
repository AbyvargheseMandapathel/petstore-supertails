package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddressPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.PaymentPage;
import pages.SearchResultPO;
import testcase.SearchTest;
import utilities.ObjectReader;

public class CheckoutTest {
	WebDriver driver = Hooks.driver;
	Properties properties = Hooks.properties;
	HomePage hp;
	SearchResultPO spo;
	SearchTest st;
	CheckOutPage cop;
	AddressPage ap;
	PaymentPage pay;
	
	@Given("add items to the shopping cart")
	public void add_items_to_the_shopping_cart() throws InterruptedException {
	    driver.get(properties.getProperty("url"));
	    hp=new HomePage(driver);
	    hp.search(ObjectReader.searchQuery());
		  spo = new SearchResultPO(driver);
		  spo.addtocart();
		 
	}

	@Given("open the cartPage")
	public void open_the_cart_page() {
		 spo.clickCartButton();
		  cop = new CheckOutPage(driver);
		  
	}

	@Given("click the checkout button")
	public void click_the_checkout_button() {
	    cop.checkOut();
	    ap= new AddressPage(driver);
	}

	@When("click the continue shopping button")
	public void click_the_continue_shopping_button() {
		
		ap.clickContinue();
	}

	@Then("the error message should be displayed")
	public void the_error_message_should_be_displayed() {
		 Boolean res=ap.checkErrMsg();
		 assertEquals(res,true);
	}


	    @And("enter the valid email {word}")
	    public void enter_the_valid_email(String email) {
	    	ap.enterEmail(email);
	    }
	   

		/*
		 * @And("select the country {string}") public void select_the_country(String
		 * country) { ap.selectCountry(country); }
		 */
	    @And("enter the valid first name {word}")
	    public void enter_the_valid_first_name(String fname) {
	    	 ap.enterFname(fname);
	    }

	    @And("enter the valid last name {word}")
	    public void enter_the_valid_last_name(String lname) {
	    	 ap.enterLname(lname);
	    }

	    @And("enter the valid address {word}")
	    public void enter_the_valid_address(String address) {
	    	 ap.enterAddress1(address);
	    }

	    @And("enter the valid apartment {word}")
	    public void enter_the_valid_apartment(String apartment) {
	    	 ap.enterAddress2(apartment);
	    }

	    @And("enter the valid city {word}")
	    public void enter_the_valid_city(String city) {
	    	 ap.enterAddress2(city);
	    }

	    @And("select the state {word}")
	    public void select_the_state(String state) {
	    	 ap.enterState(state);
	    }

	    @And("enter the valid pincode {word}")
	    public void enter_the_valid_pincode(String pincode) {
	    	 ap.enterPincode(pincode);
	    }

	    
		/*
		 * @And("enter the valid phone number {long}") public void
		 * enter_the_valid_phone_number(long number) { ap.enterWhatsAppNumber(number); }
		 */
	    @Given("enter the valid phonenumber {int}")
	    public void enter_the_valid_phonenumber(Integer int1) {
	    	ap.enterWhatsAppNumber(int1);
	    }

	    

	    @Then("Navigate to next page")
	    public void navigate_to_next_page() throws InterruptedException {
	    	pay= new PaymentPage(driver);
	    	 Boolean res=pay.paymentTitle();
	    	 assertEquals(res,true);
	    }
	    

	        @And("enter the invalid email {word}")
	        public void enter_the_invalid_email(String email) {
	        	ap.enterEmail(email);
	        }

	        

	        @And("enter the invalid first name {word}")
	        public void enter_the_invalid_first_name(String fname) {
	        	 ap.enterFname(fname);
	        }

	        @And("enter the invalid last name {word}")
	        public void enter_the_invalid_last_name(String lname) {
	        	 ap.enterLname(lname);
	        }

	        @And("enter the invalid address {word}")
	        public void enter_the_invalid_address(String address) {
	        	 ap.enterAddress1(address);
	        }

	        @And("enter the invalid apartment {word}")
	        public void enter_the_invalid_apartment(String apartment) {
	        	 ap.enterAddress2(apartment);
	        }

	        @And("enter the invalid city {word}")
	        public void enter_the_invalid_city(String city) {
	        	ap.enterCity(city);
	        }

	        

	        @And("enter the invalid pincode {word}")
	        public void enter_the_invalid_pincode(String pincode) {
	        	 ap.enterPincode(pincode);
	        }

	       
			/*
			 * @And("enter the invalid phone number {long}") public void
			 * enter_the_invalid_phone_number(long int1) { ap.enterWhatsAppNumber(int1); }
			 */
	        @Given("enter the invalid phonenumber {int}")
	        public void enter_the_invalid_phonenumber(Integer int1) {
	        	ap.enterWhatsAppNumber(int1);
	        }

	        

	        @Then("appropriate error message should be displayed")
	        public void appropriate_error_message_should_be_displayed() throws InterruptedException {
	        	Boolean res=ap.verifyInvalidDetails();
	        	assertEquals(res,true);
	        }
	    }

	


