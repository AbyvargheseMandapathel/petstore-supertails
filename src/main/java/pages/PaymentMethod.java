package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethod {
	WebDriver driver;
	
	public PaymentMethod(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".content-box__row:nth-child(3) .radio__label__primary")
	public WebElement codpresent;
	
	public boolean isCodPresent() {
		System.out.println(codpresent.isDisplayed());
		return codpresent.isDisplayed();
		
	}

}
