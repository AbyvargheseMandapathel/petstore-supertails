package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Reusable;

public class SearchResultPO {
	WebDriver driver;
	
	public SearchResultPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(className = "searched-word")
	private
	WebElement searchresultresult;
	
	@FindBy(className = "search-term")
	public
	WebElement searchresultinresult;
	
	@FindBy(xpath="(//button[@name='add'])[1]")
	public WebElement addtocartbtn;
	
	@FindBy(xpath="(//a[@id='HeaderCartTrigger'])[2]")
	public WebElement cartbtn;
	
	@FindBy(xpath = "//div[4]/div/ul/li/a")
	public WebElement firstproduct;
	
	@FindBy(css= ".Brand_uFilter .UNX-change-facet:nth-child(1)")
	public WebElement shebafilter;
	
	@FindBy(css = ".UNX-selected-facet-btn")
	public WebElement shebamenu;
	
	@FindBy(className = "findify-components--cards--product__title")
    private List<WebElement> productTitles;
	
	
	@FindBy(css = "button[data-facet-name=Brand_uFilter]")
    private List<WebElement> brandButtons;
	
	
	@FindBy(xpath="//*[@id=\"price_slider\"]/div/div[2]/div/div")
	WebElement slider;
	@FindBy(xpath="//*[@id=\"price_slider\"]/div/div[3]/div/div")
	WebElement slider1;
	@FindBy(id="filter-price-range-input-min")
	WebElement min_value;
	@FindBy(id="filter-price-range-input-max")
	WebElement max_value;
	@FindBy(className="findify-components--cards--product--price__sale-price")
	 List<WebElement> price;
	@FindBy(css=".findify-components--text__primary-lowercase")
	public WebElement dropdownfilter;
	@FindBy(css=".sort-item:nth-child(2) > span")
	public WebElement lowest;
	@FindBy(css=".sort-item:nth-child(3) > span")
	public WebElement highest;
	
	@FindBy(className = "findify-components--cards--product__title")
	public WebElement firstproductelement;
	
	//***************************************methods*****************************************
	
	
	
	public WebElement getSearchresultresult() {
		return searchresultresult;
	}

	public void setSearchresultresult(WebElement searchresultresult) {
		this.searchresultresult = searchresultresult;
	}
	
	
	public WebElement getInValidSearchresultresult() {
		return searchresultresult;
	}

	public void setInValidSearchresultresult(WebElement searchresultinresult) {
		this.searchresultinresult = searchresultinresult;
	}
	
	public void addtocart() throws InterruptedException
	{
		System.out.println(addtocartbtn.getText());
		Thread.sleep(3000);
		addtocartbtn.click();
		Thread.sleep(8000);
		
		
	}
	
	public CheckOutPage clickCartButton() {
		cartbtn.click();
		return new CheckOutPage(driver);
	}
	
	public ProductDetail openProduct() {
		firstproduct.click();
		return new ProductDetail(driver);
	}
	
	public void selectSheba() {
		shebafilter.click();
	}
	

	
//	public List<String> getProductTitles() {
//	    List<String> titles = new ArrayList<>();
//	    
////	    productTitles.forEach(title -> {
////	        String text = title.getText();
////	        titles.add(text);
////	        System.out.println(text);
////	    });
//
//	    for (WebElement title : productTitles) {
//	        String text = title.getText();
//	        titles.add(text);
//	        System.out.println(text);
//	    }
//
//	    return titles;
//	}
	
	public List<String> getProductTitles() {
		
		List<String> titles = Reusable.getProductTitles(productTitles);
				
		return titles;
	}

	public boolean getSearchContainsText(List<String> titles,String keyword) {
		System.out.println("keyword"+keyword);
        for (String title : titles) {
        	if (title.toLowerCase().contains(keyword.toLowerCase())) {
        	    return true;
        	}
        }
        return false;
    }

	
	public boolean getBrandFilterNameContains() throws InterruptedException {
        List<String> brandNames = new ArrayList<>();

        for (WebElement button : brandButtons) {
            String buttonText = button.getText().trim();
            String brandName = buttonText.substring(0, buttonText.lastIndexOf("(")).trim();
            brandNames.add(brandName);
        }

        Random random = new Random();
        int randomIndex = random.nextInt(brandNames.size());
        System.out.println(randomIndex);

        brandButtons.get(randomIndex).click();
        Thread.sleep(5000);
        
        System.out.println(brandNames.get(randomIndex));
        
        List<String> titles = getProductTitles();
        System.out.println("-------------------------");
        System.out.println("hi"+brandNames.get(randomIndex));
        boolean result = getSearchContainsText(titles,brandNames.get(randomIndex));
        System.out.println("-------------------------");        
        System.out.println(result);
        return result;
        
    }
	
	
	public String getUpdatedMaxPrice() {
		String updated_max = max_value.getText().replaceAll("[^\\d.]", "");
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
	public List<WebElement> getPriceOfAllProducts(){
		List<WebElement> prices=price;
		
		return prices;
		
	}
	public Boolean verifyPrices(List<WebElement> list,String min,String max) {
		Boolean res=true;
		for(WebElement l:list) {
			String priceText = l.getText().replaceAll("[^\\d.]", "");
			double priceValue = Double.parseDouble(priceText);
			 int updatedMin = Integer.parseInt(min);
			 int updatedMax = Integer.parseInt(max);
			 if((updatedMin<priceValue )&&(updatedMax>priceValue)) {
				res=true;
			 }
			
			
		}
		return res;
	}
	
	public void clickDropDown() {
		dropdownfilter.click();
	}
	
	public void selectDropDownLowest() {
		Reusable.selectItemsFromDropDown(lowest);
	}

	public void selectDropDownHighest() {
		Reusable.selectItemsFromDropDown(highest);
		
	}
	
	public void clickFirstProduct() {
		firstproductelement.click();
	}
	
	public boolean contains(String text) {
		boolean res = Reusable.isStringMatch(text, searchresultresult);
		return res;
	}
	 
}
