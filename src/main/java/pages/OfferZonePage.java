package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;


public class OfferZonePage {
	WebDriver driver;
	/******************Constructor****************/
	public OfferZonePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	

	

}
