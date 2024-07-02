package stepdefinitions;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ProductDetail;
import pages.SearchResultPO;
public class Review {
	
	WebDriver driver = Hooks.driver;
	Properties properties = Hooks.properties;
	HomePage hp;
	Review rvw;
	SearchResultPO spo;
	ProductDetail pd;
	
	@Given("user is on the homep")
	public void user_is_on_the_home() {
		driver.get(properties.getProperty("url"));
	}
	@Given("searches for {string}")
	public void searches_for(String query) throws InterruptedException {
		hp = new HomePage(driver);
		hp.search(query);
	}
	@When("user selects on the first Product")
	public void user_selects_on_the_first_product() throws InterruptedException {
		spo = new SearchResultPO(driver);
		spo.openProduct();
	}
	@When("click on Review tab-index")
	public void click_on_review_tab_index() {
		pd = new ProductDetail(driver);
		pd.swapToReview();
		
	}
	@When("input details")
	public void input_details() throws InterruptedException {
		pd.clickreviewlink();
		Thread.sleep(3000);
		pd.enterEmail("pranavk@gmail.com");
		pd.enterName("pranav");
		pd.enterTitle("good");
//		pd.rateStar();
		pd.rateStar(3);
		pd.enterReview("I am totally satisfied with the product. Very good");
		
	}
	@Then("validate if form is submitted successfully")
	public void validate_if_form_is_submitted_successfully() {
		
	}
}




















