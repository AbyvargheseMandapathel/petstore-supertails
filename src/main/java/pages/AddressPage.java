package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {
	WebDriver driver;

	@FindBy(xpath = "//h2[@id='section-delivery-title']")
	public WebElement addresstitle;

	@FindBy(id = "checkout_shipping_address_country")
	public WebElement country;

	@FindBy(id = "error-for-email")
	public WebElement email_err;

	@FindBy(id = "checkout_email")
	public WebElement c_email;

	@FindBy(id = "checkout_shipping_address_first_name")
	public WebElement fname;

	@FindBy(id = "error-for-zip")
	public WebElement zip_err;

	@FindBy(id = "continue_button")
	public WebElement con_btn;

	@FindBy(id = "error-for-phone")
	public WebElement phn_err;

	@FindBy(id = "checkout_shipping_address_last_name")
	public WebElement lname;

	@FindBy(id = "checkout_shipping_address_address2")
	public WebElement apt;
	@FindBy(id = "checkout_shipping_address_address1")
	public WebElement address;
	@FindBy(id = "checkout_shipping_address_city")
	public WebElement city;
	@FindBy(id = "checkout_shipping_address_zip")
	public WebElement pin;
	@FindBy(id = "checkout_shipping_address_province")
	public WebElement state;
	@FindBy(id = "checkout_shipping_address_phone")
	public WebElement whatsapp;

	public String checkaddressbar() {
		return addresstitle.getText();
	}

	public AddressPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public PaymentPage clickContinue() {

		con_btn.click();
		return new PaymentPage(driver);
	}

	public Boolean checkErrMsg() {
		return email_err.isDisplayed();
	}

	public void selectCountry(String c) {
		Select con = new Select(country);
		con.selectByVisibleText(c);
	}

	public void enterEmail(String mail) {
		c_email.sendKeys(mail);
	}

	public void enterFname(String name) {
		fname.sendKeys(name);
	}

	public void enterLname(String n) {
		lname.sendKeys(n);
	}

	public void enterAddress1(String add) {
		address.sendKeys(add);
	}

	public void enterAddress2(String add) {
		apt.sendKeys(add);
	}

	public void enterCity(String c) {
		city.sendKeys(c);
	}

	public void enterState(String s) {

		Select con = new Select(state);
		con.selectByVisibleText(s);
	}

	public void enterPincode(String pincode) {
		pin.sendKeys(pincode);
	}

	public void enterWhatsAppNumber(long num) {

		whatsapp.sendKeys(Long.toString(num));
	}

	public Boolean verifyInvalidDetails() {
		return phn_err.isDisplayed() && email_err.isDisplayed() && zip_err.isDisplayed();
	}

}
