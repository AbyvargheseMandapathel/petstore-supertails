package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Reusable;

public class ProductDetail {
	WebDriver driver;

	public ProductDetail(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "reviews-tab-jdgm")
	public WebElement review_tab;
	
	
	@FindBy(name = "reviewer_name")
	public WebElement reviewer_name;
	
	@FindBy(name = "reviewer_email")
	public WebElement reviewer_email;
	
	@FindBy(name = "review_title")
	public WebElement reviewer_title;
	
	
//	@FindBy(linkText="Write a review")
	@FindBy(xpath="//a[contains(text(),'Write a review')]")
	public WebElement writeareviewlink;
	
//	@FindBy(css = ".jdgm-form__rating > .jdgm-star:nth-child(5)")
//	public WebElement star;
	
	@FindBy(css = ".jdgm-form__rating > .jdgm-star")
	public List<WebElement> stars;
	
	@FindBy(xpath = "//div[5]/textarea")
	public WebElement reviewelement;
	
	@FindBy(className = "golden-pill")
	public WebElement hashtag;
	
	
	public void swapToReview() {
		review_tab.click();
	}
	
	public void clickreviewlink() throws InterruptedException {
		Reusable.justscroll(0,425,driver);
		Thread.sleep(5000);
		writeareviewlink.click();
		Thread.sleep(5000);
	}
	
	public void enterName(String name) throws InterruptedException {
//		Reusable.scroll(reviewer_name);
		Thread.sleep(8000);
		reviewer_name.sendKeys(name);
	}
	
	public void enterEmail(String email) throws InterruptedException {
		Thread.sleep(5000);
		Reusable.scroll(reviewer_email,driver);
		Thread.sleep(3000);
		reviewer_email.sendKeys(email);
	}
	
	public void enterTitle(String title) {
		reviewer_title.sendKeys(title);
	}
	
//	public void rateStar() {
//		star.click();
//	}
	
	public void rateStar(int starIndex) {
	    if (starIndex > 0 && starIndex <= stars.size()) {
	        stars.get(starIndex - 1).click();
	    } else {
	        System.out.println("Invalid star index provided.");
	    }
	}

	public void enterReview(String review) {
		reviewelement.sendKeys(review);
	}
	
	public String hashTagText() {
		String text = hashtag.getText();
	    text = text.replace("#", "")
	               .replace("-", "")
	               .replaceAll("\\s+", "-") 
	               .toLowerCase();
	    
	    text = text.replaceAll("-+$", "");		return text;		
	}
	
	public SearchResultPO clickKeyword() {
		hashtag.click();
		return new SearchResultPO(driver);
	}
	

}
