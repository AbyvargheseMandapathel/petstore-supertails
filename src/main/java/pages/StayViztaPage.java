package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StayViztaPage {
	WebDriver driver;
	@FindBy(linkText = "List Your Property")
	public WebElement listproperty;
	
	public PropertyPage clicklistyourproperty()
	{
		listproperty.click();
		return new PropertyPage(driver);
	}
	public StayViztaPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}


}
