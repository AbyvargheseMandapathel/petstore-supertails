package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.Reusable;

public class ExtentManager {
	
	// Static object declaration for ExtentReports and ExtentSparkReporter
	public static ExtentReports extent;
	public static ExtentSparkReporter htmlRepoerter;
	
    
	// Method to create an instance of ExtentReports
	public static  ExtentReports createInstance() {
		try {
			// Create report name with time stamp
			String repname="TestReport--"+Reusable.getTimeStamp()+".html";
			 // Initialize ExtentSparkReporter with file path
			htmlRepoerter=new ExtentSparkReporter(System.getProperty("user.dir")+"//reports//"+repname);
			 // Configure ExtentSparkReporter
			htmlRepoerter.config().setDocumentTitle("Extent Report  Demo");
			htmlRepoerter.config().setReportName("Test Report");
			htmlRepoerter.config().setTimelineEnabled(true);
			htmlRepoerter.config().setTheme(Theme.DARK);
			htmlRepoerter.config().setTimeStampFormat("MM/dd/yy HH:mm:ss");
			
			// Initialize ExtentReports
			extent= new ExtentReports();
			// Attach ExtentSparkReporter to ExtentReports
			extent.attachReporter(htmlRepoerter);
			// Set system informations &user name
			extent.setSystemInfo("OS", "Windows");
			extent.setSystemInfo("Host Name", "localHost");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("User Name", "Team 8");
		
			
		}catch(Exception e) {
			e.printStackTrace();// Print stack trace if exception occurs
		}
		// Return ExtentReports instance
		return extent;
	}

}

