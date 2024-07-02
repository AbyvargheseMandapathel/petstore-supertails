package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StayVistaBDD {
	WebDriver driver;
	
	@FindBy(xpath="//h1[@class='Collection_aboutCollection__collectionName__fYwND collection-title']")
	public WebElement title;
	
	public String checktitle()
	{
		return title.getText();
	}
	
public StayVistaBDD(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
}
