package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pharmacy {
	WebDriver driver;

	public Pharmacy(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"price_slider\"]/div/div[2]/div/div")
	WebElement slider;
	@FindBy(xpath = "//*[@id=\"price_slider\"]/div/div[3]/div/div")
	WebElement slider1;
	@FindBy(id = "filter-price-range-input-min")
	WebElement min_value;
	@FindBy(id = "filter-price-range-input-max")
	WebElement max_value;
	@FindBy(className = "findify-components--cards--product--price__sale-price")
	List<WebElement> price;
	// ***************************************methods*****************************************

	public String getUpdatedMaxPrice() {
		String updated_max = max_value.getText().replaceAll("[^\\d.]", "");
		System.out.println(updated_max);
		return updated_max;
	}

	public String getUpdatedMinPrice() {
		String updated_min = min_value.getText().replaceAll("[^\\d.]", "");
		System.out.println("Updated Min Value: " + updated_min);
		return updated_min;
	}

	public String getInitialMaxPrice() {
		String initial_max = max_value.getText().replaceAll("[^\\d.]", "");
		System.out.println("Initial Max Value: " + initial_max);
		return initial_max;
	}

	public String getInitialMinPrice() {
		String initial_min = min_value.getText().replaceAll("[^\\d.]", "");
		System.out.println("Initial Min Value: " + initial_min);
		return initial_min;
	}

	public void chooseMaxPrice() throws InterruptedException {

		slider1.click();
		Actions act = new Actions(driver);
		act.dragAndDropBy(slider, -40, 0).perform();
		Thread.sleep(2000);

	}

	public void chooseMinPrice() {

		slider1.click();
		Actions act = new Actions(driver);
		act.dragAndDropBy(slider1, 50, 0).perform();

	}

	public List<WebElement> getPriceOfAllProducts() {
		List<WebElement> prices = price;

		return prices;

	}

	public Boolean verifyPrices(List<WebElement> list, String min, String max) {
		Boolean res = true;
		for (WebElement l : list) {
			String priceText = l.getText().replaceAll("[^\\d.]", "");
			double priceValue = Double.parseDouble(priceText);
			int updatedMin = Integer.parseInt(min);
			int updatedMax = Integer.parseInt(max);
			if ((updatedMin < priceValue) && (updatedMax > priceValue)) {
				res = true;
			}

		}
		return res;
	}

}
