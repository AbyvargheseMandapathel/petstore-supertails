package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Posts {
	WebDriver driver;

	public Posts(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "bloggle--article-title")
	WebElement blogTitle;

	public String blogTitle() {
		return blogTitle.getText();
	}

}
