package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogPage {
	WebDriver driver;

	public BlogPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "Exploring the Curious Reasons Why Do Cats Hate Water?")
	public WebElement clickarticle;
	
	@FindBy(linkText="Why Pets Have Less Appetite in Summer: Exploring the Reasons")
	WebElement post;
	
	public ArticlePage clickonarticle()
	{
		clickarticle.click();
		return new ArticlePage(driver);
	}


public Posts openPost() {
	post.click();
	return new Posts(driver);
	
}
public String postTitle() {
	return post.getText();
}


}
