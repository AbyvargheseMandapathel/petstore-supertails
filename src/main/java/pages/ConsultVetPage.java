package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConsultVetPage {
	WebDriver driver;

	public ConsultVetPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "Consult now")
	public WebElement consultnow;
	
	public ConsultSubscriptionPage clickconsultnow()
	{
		consultnow.click();
		return new ConsultSubscriptionPage(driver);
	}
	

}
