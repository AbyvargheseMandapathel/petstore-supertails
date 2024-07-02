package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticlePage {
	WebDriver driver;
	
	@FindBy(xpath = "//h1[text()='Exploring the Curious Reasons Why Do Cats Hate Water?']")
	public WebElement articletitle;
	
	public String checkarticle()
	{
		return articletitle.getText();
	}
	
	public ArticlePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}




}
