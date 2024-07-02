package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Reusable;

public class ConsultSubscriptionPage {
	WebDriver driver;
//	Reusable ru=new Reusable();
	//******************************subscription*******************************
	@FindBy(xpath="(//input[@id='ProductSelect-template--16703736905966__main-option-subscription-One-time'])[1]")
	public WebElement onetimebtn;
	
	@FindBy(xpath="(//span[@id='ProductPrice-template--16703736905966__main'])[1]")
	public WebElement onetimeprice;
	
	@FindBy(xpath ="(//div[3]/label)[1]")
	public WebElement sixmonthbtn;
	
	@FindBy(xpath ="(//fieldset/div[4]/label)[1]")
	public WebElement yearlybtn;
	
	@FindBy(xpath="(//span[@id='ProductPrice-template--16703736905966__main'])[1]")
	public WebElement sixmonthprice;
	//methods
	public void onetimeSubscription()
	{
		onetimebtn.click();
		
	}
	public String getPrice() {
		String price=onetimeprice.getText();
		return price;
	}
	public void sixMonthSubscription()
	{
		sixmonthbtn.click();
		
	}
	public void yearlySubscription()
	{
		yearlybtn.click();
		
	}
	
	//******************************review*******************************
	
	@FindBy(id="reviews-tab-jdgm")
	public WebElement review;
	
	@FindBy(xpath ="//*[@id=\"judgeme_product_reviews\"]/div/div[1]/div[7]/form/div[3]/span/a[4]")
	public WebElement star;
	
	@FindBy(xpath= "(//input[@name='reviewer_name'])[1]")
	public WebElement name;
	
	@FindBy(className = "jdgm-write-rev-link")
	public WebElement write_review;
	
	@FindBy(name="reviewer_email")
	public WebElement email;
	
	@FindBy(name="review_title")
	public WebElement title;
	
	@FindBy(name="review_body")
	public WebElement content;
	
	@FindBy(className = "jdgm-submit-rev")
	public WebElement submit;
	
	@FindBy(className="shopify-payment-button__button")
	public WebElement buy;
	
	@FindBy(xpath = "//div[@id='jdgm_review_reviewer_name_7mian3bxr-error']")
	public WebElement err;
	
	//methods
	public void starRating() {
		star.click();
	}
	public  void addYourReview() {
		review.click();
		
	}
	public void WriteYourReview() {
		write_review.click();
	}
	public void enterMailId(String mail) {
		//email.click();
		Reusable.scroll(email, driver);
		email.sendKeys(mail);
	}
	public void enterName(String uname) {
		//name.click();
		name.sendKeys(uname);
	}
	public void enterReviewTitle(String t) {
		title.sendKeys(t);
	}
	public void enterReviewContent(String c) {
		content.sendKeys(c);
	}
	
	public void submitReview() {
		submit.click();
	}
	
	//******************************askQuestion*******************************
	
	@FindBy(className="jdgm-ask-question-btn")
	public WebElement askQstn;
	
	@FindBy(id="jdgm_question_reviewer_name")
	public WebElement q_name;
	
	@FindBy(id="jdgm_question_content")
	public WebElement question;
	
	@FindBy(className="jdgm-submit-question")
	public WebElement submit_qstn;
	
	@FindBy(id="jdgm_question_reviewer_email")
	public WebElement q_email;
	
	public void AskYourQuestion() {
		askQstn.click();
	}
	
	public void enterYourname(String uname) {
		q_name.sendKeys(uname);
	}
	public void enterYourmail(String mail) {
		q_email.sendKeys(mail);
	}

	public void enterYourquestion(String qstn) {
		question.sendKeys(qstn);
	}
	
	public void submitQstn() {
		submit_qstn.click();
	}
	
	
//*******************************constructor*****************************
	public ConsultSubscriptionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public Boolean errorMessage() {
		
		Boolean res =err.isDisplayed();
		String str=err.getText();
		System.out.println(str);
		return res;
	}
	
}
