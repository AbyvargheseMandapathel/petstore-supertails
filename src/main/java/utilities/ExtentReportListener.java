package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.Reusable;

public class ExtentReportListener implements ITestListener {
	static WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;
	public void onStart(ITestContext context) {
		try {
			extent = ExtentManager.createInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}
	public void onTestSuccess(ITestResult result) {
	    test.log(Status.PASS, "Test case passed");
	    test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
//	    String folderName = result.getInstanceName();
//	    String testName = result.getName();
//	    String filepath = System.getProperty("user.dir") + "/ScreenShots/screenshots of " + folderName + "/"+Reusable.getTimeStamp() + testName
//	            + "/" + testName + "_passed.png";
//	    try {
//	        Reusable.takeScreenShot(filepath);
//	        test.pass("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(filepath).build());
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
	}
	public void onTestFailure(ITestResult result) {
	    test.log(Status.FAIL, "Test case Failed");
	    test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
	    String folderName = result.getInstanceName();
	    String testName = result.getName();
	    String filepath = System.getProperty("user.dir") + "/ScreenShots/screenshots of " + folderName + "/" + testName
	            + "/" + testName + "_failed.png";
	    try {
	    	Reusable.takeScreenShot(filepath);
	        test.fail("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(filepath).build());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test case Skipped");
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.AMBER));
	}
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}


