package stepdefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	static WebDriver driver;
	static Properties properties;
	String config_path = System.getProperty("user.dir")+"\\src\\test\\resources\\objectrepo\\object.properties";
	
	@Before
	public void setup() {
		properties = new Properties();
		try (FileInputStream fis = new FileInputStream(config_path)) {
			properties.load(fis);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		String driverType = properties.getProperty("driver");
		if (driverType.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
		} else if (driverType.equals("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--start-maximized");
			driver = new EdgeDriver(options);
		}
	
	}
	
	public static void waits() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public static void tearDown(Scenario scenario) {
		String filePath = System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+"Cucumber/"+scenario.getName();
		//validate if scenario has failed
		if(!scenario.isFailed()) {
			takeScreenshot(filePath+"_failed.png");
		}	
		
		driver.close();
		driver.quit();
	}
	public static void takeScreenshot(String filepath) {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File srcFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filepath);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}

