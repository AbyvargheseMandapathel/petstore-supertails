package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	WebDriver driver;
	
	@FindBy(xpath="(//button[@name='add'])[1]")
	public WebElement addtocartbtn;
	
	
	
	public void addtocart()
	{
		addtocartbtn.click();
	}
	
	public SearchResultPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

}
