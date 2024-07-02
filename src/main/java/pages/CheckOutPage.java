package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	WebDriver driver;


	public CheckOutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//span[@class='discount-code']")
	public WebElement applycoupon;
	
	@FindBy(xpath="//input[@id='discount-code']")
	public WebElement couponcolmn;
	
	@FindBy(xpath="//button[@id='apply-discount-btn']")
	public WebElement applybtn;
	
	@FindBy(xpath="//p[@class='discount_code_text']")
	public WebElement checkdiscode;
	
	@FindBy(xpath="(//button[@name='checkout'])[1]")
	public WebElement checkoutbutton;
	
	@FindBy(xpath="(//a[@id='HeaderCartTrigger'])[2]")
	public WebElement carticon;
	
	@FindBy(xpath="(//a[@id='HeaderCartTrigger'])[2]")
	public WebElement deleteicon;
	
	@FindBy(css= ".cart__item:nth-child(1) .cart__item-name")
	public WebElement firstelement;
	
	@FindBy(css=".cart__item:nth-child(1) rect")
	public WebElement removecartitem;
	
	@FindBy(css = ".removeItem_yes")
	public WebElement confirmremovebtn;
	
	@FindBy(xpath="(//a[@id='HeaderCartTrigger'])[2]")
	public WebElement cartbtn;
	
	@FindBy(css="path:nth-child(5)")
	public WebElement deletebtn;
	
	@FindBy(css=".header-icons_wrapper #CartBubble")
	public WebElement cartcount;
	
	@FindBy(xpath = "//header/div/p")
	public WebElement emptycarttext;
	
	@FindBy(xpath = "//div[@id=\"desktop_final_price\"]/span[2]")
	public WebElement total_price;
	
	@FindBy(name = "checkout")
	public WebElement checkout_btn;
	
	
	public String checkcouponcode(String couponcode)
	{
		applycoupon.click();
		couponcolmn.click();
		couponcolmn.sendKeys(couponcode);
		applybtn.click();
		return checkdiscode.getText();
		
	}
	public AddressPage checkOut()
	{
		checkoutbutton.click();
		return new AddressPage(driver);
	}
	
	
	
//	public void 

	public void clickCartButton() {
		carticon.click();
	}
	
	public boolean removeCart() throws InterruptedException {
	    System.out.println("entered");
	    // removecartitem.click(); 
	    cartbtn.click(); 
	    String initial_value_in_string = cartcount.getText();
	    int initial_value = Integer.parseInt(initial_value_in_string);
	    System.out.println(initial_value);
	    Thread.sleep(5000); 

	    System.out.println("entered remove");
	    deletebtn.click(); 
	    confirmremovebtn.click(); 
	    Thread.sleep(5000); 

	    // Assuming the cart count updates dynamically, fetch the updated count
	    String updated_value_in_string = cartcount.getText();
	    int updated_count = Integer.parseInt(updated_value_in_string);
	    System.out.println(updated_count);

	    // Check if updated_count is equal to initial_value - 1
	    boolean removedSuccessfully = (updated_count == initial_value - 1);

	    return removedSuccessfully;
	}
	
	public String emptyText() {
		return emptycarttext.getText();
	}
	
	public String totalPrice() {
		return total_price.getText();
	}
	
	public void clickApplyCoupon() {
		applycoupon.click();
	}
	
	public void enterCouponCode(String couponcode) {
		couponcolmn.sendKeys(couponcode);
	}
	
	public void clickApply() {
		applybtn.click();
	}
	
	public PaymentMethod clickCheckOut() {
		System.out.println(checkout_btn.getText());
		checkout_btn.click();
		
		return new PaymentMethod(driver);
	}
	
	


}
