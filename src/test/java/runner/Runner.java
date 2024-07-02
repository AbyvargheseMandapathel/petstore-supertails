package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = { "stepdefinitions" },

		features = "classpath:features",

		// features = "C:\\Capstone
		// Project\\capstone_team8\\src\\test\\resources\\features\\petvillascheck.feature",

//					dryRun=true,
		plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/" }

)
public class Runner extends AbstractTestNGCucumberTests {

}
