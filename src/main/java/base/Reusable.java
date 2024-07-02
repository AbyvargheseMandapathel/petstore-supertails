package base;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.messages.types.Duration;
import utilities.ObjectReader;
public class Reusable {
	
	//static object declarations
	public static WebDriver driver;
	public static  Properties pro;
	public static String browser_choice;
	// Constructor to initialize Properties
	public Reusable() throws IOException{
		pro = ObjectReader.readObjects() ;
	}
	// Method to invoke browser based on choice specified in properties file
	public static WebDriver invokeBrowser(String browser_choice) {
		System.out.println(browser_choice);
//		browser_choice = pro.getProperty("BROWSER");// Get browser choice from properties file
		try {
			// Invoke Chrome driver
			if (browser_choice.contentEquals("chrome")) {
				driver = DriverClass.getChrome();
			}
			// Invoke Edge driver
			else if (browser_choice.contentEquals("edge")) {
				driver = DriverClass.getEdge();
			} else {
				// Throw exception for invalid browser choice
				throw new Exception("invalid browsername provided in properties file");
			}
		} catch (Exception e) {
			e.getMessage();
		}
		// Return WebDriver instance
		return driver;
	}

	// Method to take screenshot and save it to specified file path
	public static void takeScreenShot(String filepath) {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		// Capture screenshot as File
		File srcFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		// Create destination file with specified file path
		File destFile = new File(filepath);
		try {
			// Copy screenshot file to destination file
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// Method to get current timestamp in a specific format
	public static String getTimeStamp() {
		return new SimpleDateFormat("yy.mm.dd.hh.mm.ss").format(new Date());
	}

	// Method to pause execution for a specified duration
	public static void waits() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isElementDisplayed(WebElement e) {
		return e.isDisplayed();
		}
	
	public String textPresent(WebElement e) {
		return e.getText();
		}
	public String gettheUrl() {
		return driver.getCurrentUrl();
	}
	public static void scroll(WebElement element,WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public static void justscroll(int x, int y,WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")", "");
	}
	
	public static List<String> getProductTitles(List<WebElement> productTitles) {
	    List<String> titles = new ArrayList<>();
	    
//	    productTitles.forEach(title -> {
//	        String text = title.getText();
//	        titles.add(text);
//	        System.out.println(text);
//	    });

	    for (WebElement title : productTitles) {
	        String text = title.getText();
	        titles.add(text);
	        System.out.println(text);
	    }

	    return titles;
	}
	
	public static void selectItemsFromDropDown(WebElement menuitem) {
		menuitem.click();
	}
	
	public static void selectByIndex(WebElement dropdownElement, int index) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(index);
    }
	
	public static void selectByValue(WebElement dropdownElement, String value) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }
	
	public static void selectByVisibleText(WebElement dropdownElement, String visibleText) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }
	
//	public boolean isPresent(WebElement element) {
//		if (element.isDisplayed()) {
//			return true;
//		} else {
//			return false;
//		}
//	}
	
	public static boolean isStringMatch(String name,WebElement element) {
		if((element.getText()).contains(name)) {
			return true;
		}else {
			return false;
		}
	}
}
