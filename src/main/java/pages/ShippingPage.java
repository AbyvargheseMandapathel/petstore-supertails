package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Reusable;
import utilities.ObjectReader;

public class ShippingPage {
	
	 WebDriver driver;

	public ShippingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(id= "checkout_email")
	public WebElement emailfield;
	
	@FindBy(id="checkout_shipping_address_first_name")
	public WebElement firstnameelmt;
	
	@FindBy(id="checkout_shipping_address_last_name")
	public WebElement lastnameelmt;
	
	@FindBy(id="checkout_shipping_address_address1")
	public WebElement addresselmt;
	
	@FindBy(id="checkout_shipping_address_city")
	public WebElement address_city;
	
	@FindBy(id="checkout_shipping_address_country")
	public WebElement  country;
	
	@FindBy(id="checkout_shipping_address_phone")
	public WebElement phone;
	
	@FindBy(id="checkout_shipping_address_zip")
	public WebElement zip;
	
	@FindBy(id="checkout_shipping_address_province")
	public WebElement province;
	
	@FindBy(id = "continue_button")
	public WebElement continuebutton;
	
	public void fillContactEmail(String email) {
		emailfield.sendKeys(email);
		
	}

	public void fillShippingAddress(String pincode,
					String phoneno , 
					String firstname , 
					String lastname,
					String address,
					String addresscity,
					String state,
					String countryvalue
			){
		System.out.println("Entered");
		zip.sendKeys(pincode);
		phone.sendKeys(phoneno);
		firstnameelmt.sendKeys(firstname);
		lastnameelmt.sendKeys(lastname);
		addresselmt.sendKeys(address);
		address_city.sendKeys(addresscity);
//		province.sendKeys(state);
		Reusable.selectByValue(country,countryvalue );
		Reusable.selectByValue(province, state);		
		
	}
	
	public void clickContinue() {
		continuebutton.click();
	}

}
