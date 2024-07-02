package pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.Reusable;
public class ReferPage {
	WebDriver driver;
	
	public ReferPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
//	@FindBy(css="#access_page_email_input")
//	public WebElement emailfield;
//	@FindBy(xpath = "(//input[@name='email' and @type = 'email' and  @oninput='isEmailValid(this.value)'])")
//	public WebElement emailfield2;
	
//	@FindBy(xpath = "//input[@id='access_page_email_input']")
//	public WebElement emailfield;
	
	@FindBy(id="refcandy-candyjar")
	public WebElement frame1;
	
	@FindBy(id="myframe")
	public WebElement frame2;
	
	
	@FindBy(id = "access_page_email_input")
	public WebElement emailfield;
	
	@FindBy(id="access_page_first_name_input")
	public WebElement namefield;
	
//	@FindBy(xpath ="//input[@id='access_page_first_name_input']")
//	public WebElement namefield;
	
	@FindBy(xpath="//button[@value='Get invite link']")
	public WebElement invitebtn;
	
	@FindBy(xpath="//button[@id='registration_form']")
	public WebElement referallink;
	
	@FindBy(xpath="//div[@id='copy-button']")
	public WebElement refertext;
	
	public void enterEmail(String email) throws InterruptedException
	{
		//Reusable.scroll(emailfield2);
		Reusable.justscroll(0, 625, driver);
		Thread.sleep(5000);
		driver.switchTo().frame(frame1);
		//System.out.println(emailfield.getAttribute("placeholder"));
		driver.switchTo().frame(frame2);
		//System.out.println(emailfield.getAttribute("placeholder"));
		emailfield.click();
        emailfield.sendKeys(email);
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
	}
	public void enterName(String uname) throws InterruptedException {
		//System.out.println(uname);
		Reusable.justscroll(0, 625, driver);
		Thread.sleep(5000);
		driver.switchTo().frame(frame1);
		driver.switchTo().frame(frame2);
		namefield.sendKeys(uname);
		driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
		
	}
	public void clickReferal() throws InterruptedException {
		driver.switchTo().frame(frame1);
		driver.switchTo().frame(frame2);
		invitebtn.click();
		Thread.sleep(5000);
		driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
	}
	
//	public String referaltextget()
//	{
//		driver.switchTo().frame(frame1);
//	    driver.switchTo().frame(frame2);
//		return refertext.getText();
//	}
	
	public boolean referalText() {
		driver.switchTo().frame(frame1);
	    driver.switchTo().frame(frame2);
//		return refertext.getText().Re
	    return Reusable.isStringMatch("refr", refertext);
	}
	
}