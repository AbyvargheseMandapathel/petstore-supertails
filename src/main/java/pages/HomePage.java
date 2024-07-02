package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	WebDriver driver;
	// **************************constructor***************************//
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// ************************************************************//
	// *********************locator*******************************//
	@FindBy(linkText = "Offer Zone")
	WebElement offerzone;
	@FindBy(id = "mainfrm")
	WebElement searchbar;
	@FindBy(id = "pin-code")
	WebElement delivery_pin_location;
	@FindBy(xpath = "(//div[@id='shopify-section-header-new-desktop']/header//div/a[1])[1]")
	WebElement trackingorder_icon;

	@FindBy(linkText = "Refer and save")
	WebElement refernsave;

	@FindBy(linkText = "Blog")
	WebElement blog;

	@FindBy(linkText="Refer and save") WebElement refer;

	@FindBy(xpath = "//div[@id='shopify-section-header-new-desktop']//a[2]")
	WebElement contactuslink;

	@FindBy(linkText = "Dogs ") WebElement dogs;
	@FindBy(linkText = "Cats ") WebElement cats ;
	@FindBy(linkText = "Shop By Breed") WebElement shopByBreed;
	@FindBy(linkText = "Henlo ") WebElement henloProducts;

	@FindBy(linkText = "Pharmacy") WebElement pharmacy;

	@FindBy(linkText = "Consult a Vet") WebElement consultVet;
	@FindBy(css = "#shopify-section-header-new-desktop > header > nav > ul > li:nth-child(8) > a") 
	WebElement villas;

	@FindBy(css=".header-icons_wrapper #delivery_pin_location")
	WebElement pincodeicon;

	@FindBy(id="pincodeInput")
	WebElement pincodeinput;

	@FindBy(css=".apply_btn")
	WebElement applybtn;

	@FindBy(id="errorSpan")
	WebElement errorSpan;
	
	// *********************locator*******************************//

	public SearchResultPO search(String keyword) {
		searchbar.clear();
		searchbar.sendKeys( keyword + Keys.ENTER);
		return new SearchResultPO(driver);
	}
	public void tracklocation() {
		trackingorder_icon.click();
	}
	public void deli(String pin) {
		pincodeicon.click();
		pincodeinput.sendKeys(pin);
		applybtn.click();
	}
	public OfferZonePage offer() {
		offerzone.click();
		return new OfferZonePage(driver);
	}
	public ReferPage clickreferbtn() {
		refernsave.click();
		return new ReferPage(driver);
	}
	public BlogPage clickBlog()
	{
		blog.click();
		return new BlogPage(driver);
	}
	public ConsultVetPage consultVet() {
		consultVet.click();
		return new ConsultVetPage(driver);
	}
	public Pharmacy pharmacyProducts() {
		pharmacy.click();
		return new Pharmacy(driver);
	}
	public ReferPage referal() {
		System.out.println("entered");
		System.out.println(refernsave.getText());
		refernsave.click();
		System.out.println("clicked");
		return new ReferPage(driver);
	}
	public StayVistaBDD clickpetvilla()
	{
		villas.click();
		return new StayVistaBDD(driver);
	}
	public ContactUsPage contactusnav() {
		contactuslink.click();
		return new ContactUsPage(driver);
	}
}