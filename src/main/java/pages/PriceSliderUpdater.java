package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PriceSliderUpdater {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    // Constructor to initialize WebDriver, WebDriverWait, and Actions
    public PriceSliderUpdater() {
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    // Function to update the price slider
    public void updatePriceSlider(int minValue, int maxValue) {
        // Navigate to your webpage
        driver.get("https://supertails.com/search?q=Wet+Food&page=1");

        // Locate slider handles
        WebElement lowerHandle = driver.findElement(By.cssSelector(".noUi-handle-lower"));
        WebElement upperHandle = driver.findElement(By.cssSelector(".noUi-handle-upper"));

        // Move lower handle to the desired minimum value
        moveSlider(lowerHandle, minValue);

        // Move upper handle to the desired maximum value
        moveSlider(upperHandle, maxValue);
    }

    private void moveSlider(WebElement sliderHandle, int value) {
        actions.dragAndDropBy(sliderHandle, calculateOffset(value), 0).perform();
    }

    private int calculateOffset(int value) {
        
        double range = 8500;
        double sliderWidth = 1000; 
        return (int) ((value / range) * sliderWidth);
    }

}