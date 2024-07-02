package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrackLocation {
	WebDriver driver;
	
	public TrackLocation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "/html/body/div/div/div[1]/div/div/div/div/p[1]/div/input")
	WebElement trackorderinput;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div/div/div/p[1]/span")
	WebElement trackorderbtn;
	
	@FindBy(xpath = "//div[5]//text()")
	public WebElement trackresultinvalid;
	
	
	public void enterOrderId(String orderid) throws InterruptedException {
		System.out.println("Entered");
		System.out.println(orderid);
		trackorderinput.click();
		trackorderinput.sendKeys(orderid);
	}
	
	public TrackResult submitBtn() throws InterruptedException {
		Thread.sleep(3000);
		trackorderbtn.click();	
		return new TrackResult(driver);
	}

}
